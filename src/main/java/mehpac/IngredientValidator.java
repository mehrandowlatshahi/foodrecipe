package mehpac;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;



public class IngredientValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		return Ingredient.class.equals(arg0);
	}

	@Override
	public void validate(Object obj, Errors errs) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errs, "item", "valid.ingredient");
		
	}

}
