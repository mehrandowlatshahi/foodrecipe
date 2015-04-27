package mehpac.controller;

import javax.validation.Valid;

import mehpac.Ingredient;
import mehpac.Ingreds;
import mehpac.Recipe;
import mehpac.Recipes;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value="/food")
public class RecipesControler {

	
	
	@RequestMapping("/form/recipes")	
	public ModelAndView ingredientsPage() {
		
		Recipes recipes = new Recipes();
		ModelAndView mav = new ModelAndView("recipes", "recps", recipes);
						
		return mav;
	}
	
	@RequestMapping("/form/recipes_added")
	public String processForm(@Valid @ModelAttribute("recps")Recipes recps,BindingResult result)
	{
		if(result.hasErrors())
		{
			return "recipes";
		}
		else
		{
			if (recps ==null){
				return "recipes";
			}
			int trn = Recipe.getNumRecipes();
			Recipe.createRecipes(recps.getJsonRecipes());
			
			if (Recipe.getNumRecipes()<1)
				return "recipes";
			return "index";
		}
	}
	
}