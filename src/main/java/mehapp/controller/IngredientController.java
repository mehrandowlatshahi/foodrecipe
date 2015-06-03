package mehapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/food")
public class IngredientController {
	
	/*
	@Autowired
    @Qualifier("IngredientValidator")
    private Validator validator;
    
    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }
	*/
    
	@RequestMapping(value = "/form/ingredients", method = RequestMethod.GET)	
	public ModelAndView ingredientsPage() {
		ModelAndView mav = new ModelAndView("ingredientsform");
				
		return mav;
	}
	
	@RequestMapping(value = "/form/ingredients_added", method = RequestMethod.GET)	
	public ModelAndView ingredientsSubmitted() {
		
		ModelAndView mav = new ModelAndView("ingredientslist");
		
		
		return mav;
	}
	

}
