package mehpac.controller;

import mehpac.Ingreds;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/food")
public class IngredsController {

	
	@RequestMapping(value = "/form/ingreds")	
	public String ingredientsPage(Model model) {
		//ModelAndView mav = new ModelAndView("ingreds");
		Ingreds ingreds=new Ingreds();
		//mav.addObject("ingredients", ingreds);
		model.addAttribute("ingredients", ingreds);
				
		return "ingreds";
	}
	
	@RequestMapping(value = "/form/ingreds_added", method = RequestMethod.POST)	
	public ModelAndView ingredientsSubmitted() {
		
		ModelAndView mav = new ModelAndView("ingredientslist");
		
		
		return mav;
	}
}
