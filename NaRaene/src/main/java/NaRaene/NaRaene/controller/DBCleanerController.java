package NaRaene.NaRaene.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import NaRaene.NaRaene.database.DBException;
import NaRaene.NaRaene.database.DatabaseCleaner;

@Controller
public class DBCleanerController {
	
	@RequestMapping(value="dbcleaner")
	public ModelAndView test(HttpServletRequest request, HttpServletResponse response) throws IOException, DBException{
		ModelAndView model = new ModelAndView();
		DatabaseCleaner cleaner = new DatabaseCleaner();
		
		cleaner.cleanDatabase();
	    String str = "database cleaned";		
		
		model.setViewName("dbcleaner");
		model.addObject("model", str);
			
		return model;
	}

}
