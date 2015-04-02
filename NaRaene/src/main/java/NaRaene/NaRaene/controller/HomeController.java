package NaRaene.NaRaene.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import NaRaene.NaRaene.database.dao.UserDAO;
import NaRaene.NaRaene.domain.User;

@Controller
public class HomeController {
	
@Autowired
   private UserDAO userDao;

	@RequestMapping(value="home")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		ModelAndView model = new ModelAndView();
		
		List<User> list = userDao.listUser();
		User user = list.get(0);
		String name = user.getFirstName();
		
		model.setViewName("home");
		model.addObject("model", name);
		
		return model;
	}
}

