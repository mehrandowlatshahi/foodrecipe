package mehapp.controller;

import javax.validation.Valid;

import mehapp.Ingredient;
import mehapp.Ingreds;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/food")
@SessionAttributes("ingredslist")
public class IngredsController {

	
	
	@RequestMapping("/form/ingreds")	
	public ModelAndView ingredientsPage() {
		//ModelAndView mav = new ModelAndView("ingreds");
		Ingreds ingreds=new Ingreds();
		ModelAndView mav = new ModelAndView("ingreds", "ings", ingreds);
		mav.addObject("ingredslist", Ingredient.getAllIngredients());
				
		return mav;
	}
	
	@RequestMapping("/form/ingreds_added")
	public String processForm(@Valid @ModelAttribute("ings")Ingreds ingreds,BindingResult result)
	{
		if(result.hasErrors())
		{
			return "ingreds";
		}
		else
		{
			if (ingreds ==null){
				return "ingreds";
			}
		//	int tin = Ingredient.getNumIngredients();
			Ingredient.addIngredients(ingreds.getTextIngreds().trim());
			if (Ingredient.getNumIngredients()<1)
				return "ingreds";
			
			return "index";
		}
	}
	
}
