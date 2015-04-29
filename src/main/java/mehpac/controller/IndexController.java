package mehpac.controller;

import mehpac.Ingredient;
import mehpac.Recipe;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	
	@RequestMapping(value={"/", "index"}, method=RequestMethod.GET)
	public ModelAndView index() {
		
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("message", "Mehran Food Maker");
		return mav;
	}
	
	@RequestMapping(value={"/getrecipe", "offeredrecipe"}, method=RequestMethod.GET)
	public ModelAndView getRecipe() {
		
		ModelAndView mav = new ModelAndView("offeredrecipe");
		String msg = "Order Takeout";
		int sz = Recipe.getNumRecipes();
		int ingsz = Ingredient.getNumIngredients();
		if (ingsz> 0 && sz > 0){
			msg = Recipe.getRecipeByIndex(0).getName();
		}
		
		mav.addObject("recipe", msg);
		return mav;
	}

}

