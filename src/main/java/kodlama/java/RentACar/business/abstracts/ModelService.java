package kodlama.java.RentACar.business.abstracts;

import java.util.List;

import kodlama.java.RentACar.business.requests.CreateModelRequest;
import kodlama.java.RentACar.business.responses.GetAllModelsResponse;

public interface ModelService {
	List<GetAllModelsResponse> getAll();
	void add(CreateModelRequest createModelRequest);
}
