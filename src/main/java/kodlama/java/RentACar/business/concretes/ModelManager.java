package kodlama.java.RentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.java.RentACar.business.abstracts.ModelService;
import kodlama.java.RentACar.business.requests.CreateModelRequest;
import kodlama.java.RentACar.business.responses.GetAllModelsResponse;
import kodlama.java.RentACar.core.utilities.mappers.ModelMapperService;
import kodlama.java.RentACar.dataAccess.abstracts.ModeRepository;
import kodlama.java.RentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;

@Service 
@AllArgsConstructor
public class ModelManager implements ModelService {
	
	private ModeRepository modelRepository;
	private ModelMapperService modelMapperService;
	
	@Override
	public List<GetAllModelsResponse> getAll() {
		List<Model> models = modelRepository.findAll();

		List<GetAllModelsResponse> modelResponse = models.stream()
				.map(model -> this.modelMapperService.forResponse().map(model, GetAllModelsResponse.class))
				.collect(Collectors.toList());
		// TODO Auto-generated method stub
		return modelResponse;
	}

	@Override
	public void add(CreateModelRequest createModelRequest) {
		Model model = this.modelMapperService.forRequest().map(createModelRequest, Model.class);
		
		this.modelRepository.save(model);
		
	}

}
