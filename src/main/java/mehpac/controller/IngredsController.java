package mehpac.controller;

import javax.validation.Valid;

import mehpac.Ingredient;
import mehpac.Ingreds;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/food")
public class IngredsController {

	
	
	@RequestMapping("/form/ingreds")	
	public ModelAndView ingredientsPage() {
		//ModelAndView mav = new ModelAndView("ingreds");
		Ingreds ingreds=new Ingreds();
		//mav.addObject("ingredients", ingreds);
		//model.addAttribute("ingredients", ingreds);
		ModelAndView mav = new ModelAndView("ingreds", "ings", ingreds);
		
				
		return mav;
	}
	
	@RequestMapping("/form/ingreds_added")
	public String processForm(@Valid @ModelAttribute("ings")Ingreds ings,BindingResult result)
	{
		if(result.hasErrors())
		{
			return "ingreds";
		}
		else
		{
			if (ings ==null){
				return "ingreds";
			}
			int tin = Ingredient.getNumIngredients();
			Ingredient.addIngredients(ings.getTextIngreds().trim());
			if (Ingredient.getNumIngredients()<1)
				return "ingreds";
			return "index";
		}
	}
	
}
