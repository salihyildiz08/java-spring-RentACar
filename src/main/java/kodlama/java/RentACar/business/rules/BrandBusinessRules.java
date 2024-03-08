package kodlama.java.RentACar.business.rules;

import org.springframework.stereotype.Service;

import kodlama.java.RentACar.core.utilities.exceptions.BusinessException;
import kodlama.java.RentACar.dataAccess.abstracts.BrandRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BrandBusinessRules {
	private BrandRepository brandRepository;
	
	public void checkIfBrandNameExists(String name) {
		if (this.brandRepository.existsByName(name)) {
			throw new BusinessException("Brand name already exists");
		}
	}
}
