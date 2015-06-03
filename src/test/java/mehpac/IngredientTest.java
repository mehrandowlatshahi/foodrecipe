package mehpac;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import mehapp.Ingredient;

import org.junit.Before;
import org.junit.Test;

public class IngredientTest {

	static final String ss = "bread,10,slices,25/12/2014 \n"+ 
			"cheese,10,slices,25/12/2014\n"+
			"butter,250,grams,25/12/2014 peanut\n"+
			"butter,250,grams,2/12/2014 mixed\n"+
			"salad,150,grams,26/12/2013";
	
	@Before
    public void setUp() {
		Ingredient.resetIngredientList();
		
	}
	@Test
	public void testAddIngredients() {
		Ingredient.addIngredients(ss);
		assertEquals(5, Ingredient.getNumIngredients());
		assertEquals(0, Ingredient.getIngredientIndex("mixed salad"));
		assertEquals(1, Ingredient.getIngredientIndex("peanut butter"));
	}

	@Test
	public void testGetDate() throws ParseException {
		Ingredient ing=null;
		Date d = Ingredient.getDate("2/12/2014");
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		int month = cal.get(Calendar.MONTH);
		assertEquals(11, month);
		assertEquals(2,cal.get(Calendar.DAY_OF_MONTH));
		assertEquals(2014,cal.get(Calendar.YEAR));
		
	}

}
