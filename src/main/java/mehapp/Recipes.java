package mehapp;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Recipes {
	
	@NotNull
	@Size(min=5, max=5000 )
	private String jsonRecipes;

	public String getJsonRecipes() {
		return jsonRecipes;
	}

	public void setJsonRecipes(String jsonRecipes) {
		this.jsonRecipes = jsonRecipes;
	}
	
}
