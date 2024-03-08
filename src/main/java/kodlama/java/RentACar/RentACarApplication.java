package kodlama.java.RentACar;

import java.util.HashMap;
import java.util.Iterator;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import kodlama.java.RentACar.core.utilities.exceptions.BusinessException;
import kodlama.java.RentACar.core.utilities.exceptions.ProblemDetails;
import kodlama.java.RentACar.core.utilities.exceptions.ValidationProblemDetails;

@SpringBootApplication
@RestControllerAdvice
public class RentACarApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentACarApplication.class, args);
	}
	
	@ExceptionHandler
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public ProblemDetails handlerBusinessException(BusinessException businessException) {
		ProblemDetails details=new ProblemDetails();
		details.setMessage(businessException.getMessage());
		
		return details;
	}
	
	@ExceptionHandler
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public ValidationProblemDetails handleCalidationException(MethodArgumentNotValidException notValidException) {
		ValidationProblemDetails details=new ValidationProblemDetails();
		details.setMessage("Validation Errors");
		
		details.setValidationErrors(new HashMap<String, String>());
		
		for (FieldError fieldError: notValidException.getBindingResult().getFieldErrors()) {
			details.getValidationErrors().put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		return details;
	}

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
}
