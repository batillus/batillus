package NaRaene.NaRaene.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import NaRaene.NaRaene.database.dao.PlayerDAO;
import NaRaene.NaRaene.domain.Player;
import NaRaene.NaRaene.domain.User;

@Controller
public class UserPageController {
	
	@Autowired
	private PlayerDAO playerDAO;

	@RequestMapping(value="userpage")
	public ModelAndView test(HttpServletRequest request, HttpServletResponse response) throws IOException{
		ModelAndView model = new ModelAndView();
		HttpSession session = request.getSession(true);
		
		List<Player> list = playerDAO.listPlayer();
		int num = list.size();
		
		User user = (User) session.getAttribute("user");
		String userName = user.getFirstName();
		
		Map<String, Object> modelHashMap = new HashMap<String, Object> ();
		
		modelHashMap.put("username", userName);
		modelHashMap.put("quantity", num);
		modelHashMap.put("playerlist", list);
		
		model.setViewName("userpage");
		model.addObject("model", modelHashMap);
		
		return model;
	}
	
	
}
