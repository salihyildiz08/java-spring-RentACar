package kodlama.java.RentACar.business.abstracts;

import java.util.List;

import kodlama.java.RentACar.business.requests.CreateBrandsRequest;
import kodlama.java.RentACar.business.requests.UpdateBrandRequest;
import kodlama.java.RentACar.business.responses.GetAllBrandsReponse;
import kodlama.java.RentACar.business.responses.GetByIdBrandResponse;


public interface BrandService {
	List<GetAllBrandsReponse> getAll();
	GetByIdBrandResponse getId(int id);
	void add(CreateBrandsRequest createBrandsRequest);
	void update(UpdateBrandRequest updateBrandRequest);
	void delete(int id);
	
}
