package mehpac;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class Recipe {
	
	private static LinkedList<Recipe> recipeList = new LinkedList<Recipe>();
	
	private static JSONParser jParser = new JSONParser();
			
	String name;
	List<Ingredient> ingredients=new ArrayList<Ingredient>();
	long expirey =Long.MAX_VALUE;
	
	public static int getNumRecipes(){
		return recipeList.size();
	}
	public static Recipe getRecipeByIndex(int ii){
		if(ii < recipeList.size()){
			return recipeList.get(ii);
		}
		return null;
	}
	public static void createRecipes(String s){
		String name;
		
		JSONArray obja=null;
		JSONObject obj=null;
		
		try {
			obja = (JSONArray) jParser.parse(s);
			Iterator rit = obja.iterator();
			while(rit.hasNext()){
				JSONObject aing = (JSONObject) rit.next();
				
				name = (String) aing.get("name");
				JSONArray ja = (JSONArray) aing.get("ingredients");
				Iterator ingit = ja.iterator();
								
				Recipe r = new Recipe();
				r.setName(name);
				long expdate = Long.MAX_VALUE;
				
				while(ingit.hasNext()){
					obj = (JSONObject) ingit.next();
					String item = (String) obj.get("item");
					int jj = Ingredient.getIngredientIndex(item);
					if(jj <0)//ingredient not exist
						break;
					Ingredient ling =  Ingredient.getIngredient(jj);
					int amt = Integer.parseInt(((String) obj.get("amount")).trim());
					if(amt > ling.getAmount())//not enough ingredient
						break;
					if (expdate > ling.getUseBy().getTime()){
						////System.out.println("recipe name: "+name+ " item "+item);
						expdate = ling.getUseBy().getTime();
					}
					//Ingredient(String s, int n, String unitnm, Date d )
					Ingredient ning = new Ingredient();
					ning.setAmount(amt);
					ning.setItem(item);
					ning.setUseBy(ling.getUseBy());
					r.ingredients.add(ning);
				}
				r.setExpirey(expdate);
				
				int k=0;
				//insert based on expire date
				for(Recipe rr:recipeList){
					if(rr.getExpirey()>expdate)
						break;
					k++;
				}
				recipeList.add(k,r);
								
			}			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally{
			obj.clear();
			
		}
				
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public long getExpirey() {
		return expirey;
	}


	public void setExpirey(long expirey) {
		this.expirey = expirey;
	}
}
