package mehapp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.TimeZone;

public class Ingredient {
	
	public static final TimeZone TMZONE = TimeZone.getTimeZone("UTC");
	
	public static final String[] Units = {"of", "grams", "milliliters", "slices"};
	private static SimpleDateFormat timeFormat;
	private static LinkedList<Ingredient> ings = new LinkedList<Ingredient>();
	
	////class internal member vars
	String item;
	int amount; 
	String unitName; 
	Date useBy;
	
	
	public static List<Ingredient> getAllIngredients(){
		return ings;
	}
	public static int getNumIngredients(){
		return ings.size();
	}
	
	public static void resetIngredientList(){
		ings.removeAll(ings);
	}
	public static int getIngredientIndex(String name){
		int k=0, j=-1;
		for(Ingredient ling:ings){
			if(ling.getItem().equals(name)){
				j=k;
				break;
			}
			k++;
		}
		return j;
	}
	
	public static Ingredient getIngredient(int z){
		if (z<ings.size()){
			return ings.get(z);
		}
		return null;
	}
	
	
	public static void addIngredients(String s){
		String bs = "\r\n";
		if (s.indexOf("\r")<0){
			bs = "\n";
		}
		String lss = s.replaceAll(" ", bs);		
		String[] isa = lss.split(bs);
		String t=null;
		for(String ss:isa){
			if (ss.indexOf(",")<0){
				t=ss;
				continue;
			}
			if (t !=null){
				ss= t+" "+ss;
				t=null;
			}
			Ingredient aa =createIngredient(ss.trim());
			if(aa ==null){
				continue;
			}
			
			int k=0;
			//insert and sort
			for(Ingredient ig:ings){
				if(ig.useBy.getTime()>aa.useBy.getTime())
					break;
				k++;
			}
			ings.add(k,aa);
			
		}
	}
	public static Date getDate(String date) throws ParseException{
		{
			if (timeFormat ==null){
				timeFormat = new SimpleDateFormat("dd/MM/yyyy");
		        timeFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
			}
		}
		return  timeFormat.parse(date.trim());	
	}
	/**
	 * creates Ingredient and stores in a sorted static list for later use
	 * validates input string
	 * @param s
	 * @return
	 */
	public static Ingredient createIngredient(String s){
		
		String[] sa = s.split(",");
		if (sa.length<4)
			return null;
		
		String nm;
		int m=0;
		String su=null;
		Date uBy=null;
		try{
			
			nm = sa[0].trim();
			m = Integer.parseInt(sa[1]);
			su = sa[2].trim();
			;
			uBy = getDate(sa[3].trim());						
			
		}catch(Exception e){
			nm=null;
		}
		if (nm ==null)
			return null;
		Ingredient aa = new Ingredient(nm, m, su,uBy);
		
		
		return aa;
		
	}
	public Ingredient(){
		super();
	}
	public Ingredient(String s, int n, String unitnm, Date d ){
		super();
		item =s;
		amount = n;
		unitName = unitnm;
		useBy = d;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public Date getUseBy() {
		return useBy;
	}
	public void setUseBy(Date useBy) {
		this.useBy = useBy;
	}
	
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	
}
