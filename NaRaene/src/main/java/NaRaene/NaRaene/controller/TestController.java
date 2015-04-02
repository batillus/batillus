package NaRaene.NaRaene.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import NaRaene.NaRaene.database.dao.UserDAO;
import NaRaene.NaRaene.domain.User;

@Controller
public class TestController {
	
	@Autowired
	   private UserDAO userDao;
	
	@RequestMapping(value="testjsp")
	public ModelAndView test(HttpServletRequest request,HttpServletResponse response) throws IOException{
		ModelAndView model = new ModelAndView();
		
		User user = userDao.getByLogin("user1");
		
		String str = user.getFirstName();
		
		model.setViewName("testjsp");
		model.addObject("model" , str);
		return model;
	}

}
