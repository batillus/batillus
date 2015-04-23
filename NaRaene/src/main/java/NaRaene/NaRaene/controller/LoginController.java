package NaRaene.NaRaene.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import NaRaene.NaRaene.database.dao.UserDAO;
import NaRaene.NaRaene.domain.User;

@Controller
public class LoginController {
	
	@Autowired
	   private UserDAO userDao;
	
	@RequestMapping(value="login")
	public ModelAndView test(HttpServletRequest request, HttpServletResponse response) throws IOException{
		ModelAndView model = new ModelAndView();
		
		HttpSession session = request.getSession(true);
		
		String check = "false";
		
		String login = (String) request.getParameter("userlogin");
		String password = (String) request.getParameter("password");
		
		
		
		if(login != null){
			
			try{
		 if(checkLogin(login, password)){
			check = "true";
			User user = userDao.getByLogin(login);
			session.setAttribute("user", user);
			//String userName = userDao.getByLogin(login).getFirstName(); //hz
			//session.setAttribute("user", userName);                     //hz
		  }
			} catch (NullPointerException e) {
				check = "false";
			}
		}	
		model.setViewName("login");
		model.addObject("model", check);
		
				
		
		return model;
	}
	
	public boolean checkLogin(String login, String password){
	
		if(userDao.getByLogin(login).getPassword().equals(password)){
			return true;
		} else return false;
	}	
	
	
}
