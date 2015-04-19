package mehpac;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;


public class RecipeTest {
	static final String recipFP ="src/test/java/mehpac/recipes.json";
	static final String ss = "bread,10,slices,25/12/2014 \n"+ 
			"cheese,10,slices,24/12/2014\n"+
			"butter,250,grams,25/12/2014 peanut\n"+
			"butter,250,grams,25/12/2014 mixed\n"+
			"salad,150,grams,26/12/2015";
	@Before
    public void setUp() {
		Ingredient.resetIngredientList();
		Ingredient.addIngredients(ss);
    }
	@Test
	public void testCreateRecipe() throws Exception{
		String rs ="";
		FileReader frd = new FileReader(recipFP);
		BufferedReader brd = new BufferedReader(frd);
		String s=null;
		while( (s=brd.readLine()) !=null){
			rs +=s;
		}		
		brd.close();
		frd.close();
		Recipe.createRecipes(rs);
		assertEquals(2, Recipe.getNumRecipes());
		Recipe r = Recipe.getRecipeByIndex(0);
		long t = Ingredient.getDate("24/12/2014").getTime();
		
		assertEquals(t, r.getExpirey());
	}

}
