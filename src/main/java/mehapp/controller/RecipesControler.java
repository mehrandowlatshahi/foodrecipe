package mehapp.controller;

import javax.validation.Valid;


//import mehpac.Ingredient;
//import mehpac.Ingreds;

import mehapp.Recipe;
import mehapp.Recipes;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value="/food")
@SessionAttributes("recipeslist")
public class RecipesControler {

	
	
	@RequestMapping("/form/recipes")	
	public ModelAndView ingredientsPage() {
		
		Recipes recipes = new Recipes();
		ModelAndView mav = new ModelAndView("recipes", "recpsCmd", recipes);
		mav.addObject("recipeslist", Recipe.getAllRecipesList());				
		return mav;
	}
	
	@RequestMapping("/form/recipes_added")
	public String processForm(@Valid @ModelAttribute("recpsCmd")Recipes recps,BindingResult result)
	{
		if(result.hasErrors())
		{
			return "recipes";
		}
		else
		{			
			Recipe.createRecipes(recps.getJsonRecipes());
			
			if (Recipe.getNumRecipes()<1)
				return "recipes";
			return "index";
		}
	}
	
}