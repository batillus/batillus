package NaRaene.NaRaene.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import NaRaene.NaRaene.domain.User;

@Controller
public class UserPageController {

	@RequestMapping(value="userpage")
	public ModelAndView test(HttpServletRequest request, HttpServletResponse response) throws IOException{
		ModelAndView model = new ModelAndView();
		HttpSession session = request.getSession(true);
		
		User user = (User) session.getAttribute("user");
		
		int id = (int) user.getUserId();
		String str = Integer.toString(id);
		
		model.setViewName("userpage");
		model.addObject("model", str);
		
		return model;
	}
	
}
