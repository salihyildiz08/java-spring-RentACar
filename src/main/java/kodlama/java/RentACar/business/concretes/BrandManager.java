package kodlama.java.RentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.java.RentACar.business.abstracts.BrandService;
import kodlama.java.RentACar.business.requests.CreateBrandsRequest;
import kodlama.java.RentACar.business.requests.UpdateBrandRequest;
import kodlama.java.RentACar.business.responses.GetAllBrandsReponse;
import kodlama.java.RentACar.business.responses.GetByIdBrandResponse;
import kodlama.java.RentACar.business.rules.BrandBusinessRules;
import kodlama.java.RentACar.core.utilities.mappers.ModelMapperService;
import kodlama.java.RentACar.dataAccess.abstracts.BrandRepository;
import kodlama.java.RentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;

@Service // bu sınıf 1 business nesnesidir
@AllArgsConstructor
public class BrandManager implements BrandService {

	private BrandRepository brandRepository;
	private ModelMapperService mapperService;
	private BrandBusinessRules brandBusinessRules;
	
	@Override
	public List<GetAllBrandsReponse> getAll() {
		List<Brand> brands = brandRepository.findAll();

		List<GetAllBrandsReponse> brandResponse = brands.stream()
				.map(brand -> this.mapperService.forResponse().map(brand, GetAllBrandsReponse.class))
				.collect(Collectors.toList());
		// TODO Auto-generated method stub
		return brandResponse;
	}

	@Override
	public void add(CreateBrandsRequest createBrandsRequest) {
		this.brandBusinessRules.checkIfBrandNameExists(createBrandsRequest.getName());
		
		Brand brand = this.mapperService.forRequest().map(createBrandsRequest, Brand.class);

		this.brandRepository.save(brand);

	}

	@Override
	public GetByIdBrandResponse getId(int id) {
		Brand brand = this.brandRepository.findById(id).orElseThrow();

		GetByIdBrandResponse response = this.mapperService.forResponse().map(brand, GetByIdBrandResponse.class);
		return response;
	}

	@Override
	public void update(UpdateBrandRequest updateBrandRequest) {

		Brand brand = this.mapperService.forRequest().map(updateBrandRequest, Brand.class);
		this.brandRepository.save(brand);
	}

	@Override
	public void delete(int id) {
		this.brandRepository.deleteById(id);

	}

}
