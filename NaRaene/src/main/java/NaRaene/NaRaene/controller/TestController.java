package NaRaene.NaRaene.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import NaRaene.NaRaene.database.dao.PlayerDAO;
import NaRaene.NaRaene.database.dao.UserDAO;
import NaRaene.NaRaene.domain.Player;
import NaRaene.NaRaene.domain.User;

@Controller
public class TestController {
	
	@Autowired
	   private UserDAO userDao;
	@Autowired
	   private PlayerDAO playerDao;
	
	@RequestMapping(value="testjsp")
	public ModelAndView test(HttpServletRequest request,HttpServletResponse response) throws IOException{
		ModelAndView model = new ModelAndView();
		
		//User user = userDao.getByLogin("user");
		//User user = userDao.getById(1003);
		//List<Player> list = playerDao.listPlayer();
		
		Player player = playerDao.getById(4);
		
		//String str = user.getFirstName();
		//String str = list.get(0).getPlayerName();
		String str = player.getPlayerName();
		
		model.setViewName("testjsp");
		model.addObject("model" , str);
		return model;
	}

}
