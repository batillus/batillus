package NaRaene.NaRaene.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import NaRaene.NaRaene.database.DBException;
import NaRaene.NaRaene.database.DatabaseCleaner;
import NaRaene.NaRaene.database.dao.UserDAO;
import NaRaene.NaRaene.domain.User;

@Controller
public class UserRegController {

	@Autowired
	   private UserDAO userDao;
	
	@RequestMapping(value="userreg")
	public ModelAndView test(HttpServletRequest request, HttpServletResponse response) throws IOException, DBException{
		ModelAndView model = new ModelAndView();
				
		String test = "test";
		if(checkForms(request)){
			test = "true";
			createUserInDB(request);
		} else {
			test = "false";
		}
				
		model.setViewName("userreg");
		model.addObject("model", test);
					
		return model;
	}
	
	public boolean checkForms(HttpServletRequest request){
		String login = (String) request.getParameter("login");
		String password = (String) request.getParameter("password");
		String name = (String) request.getParameter("firstname");
		String surname = (String) request.getParameter("lastname");
		
		ArrayList<String> list = new ArrayList<String>();
		list.add(login);
		list.add(password);
		list.add(name);
		list.add(surname);
		
		for (String item : list) {
		    if(item == "" || item == null){
		    	return false;
		    }
		  }
		return true;
	}
	
	public void createUserInDB(HttpServletRequest request){
		String login = (String) request.getParameter("login");
		String password = (String) request.getParameter("password");
		String name = (String) request.getParameter("firstname");
		String surname = (String) request.getParameter("lastname");
		
		User user = new User(login, password, name, surname);
		
		try{
		userDao.addUser(user);
		} catch (Exception e){
			System.out.println("bybyby");
		}
	}
}
