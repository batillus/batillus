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
import NaRaene.NaRaene.database.dao.UserDAO;
import NaRaene.NaRaene.domain.Player;
import NaRaene.NaRaene.domain.User;

@Controller
public class UserPageController {
	
	@Autowired
	private PlayerDAO playerDAO;
	@Autowired
	   private UserDAO userDao;

	@RequestMapping(value="userpage")
	public ModelAndView test(HttpServletRequest request, HttpServletResponse response) throws IOException{
		ModelAndView model = new ModelAndView();
		HttpSession session = request.getSession(true);
		User user = (User) session.getAttribute("user");
		List<Player> list = playerDAO.listPlayer();
		int num = getQuantity(list, user);	
		List<Player> sortedList = filterList(list, user);		
		String userName = user.getFirstName();
				
		Map<String, Object> modelHashMap = new HashMap<String, Object> ();
		
		modelHashMap.put("username", userName);
		modelHashMap.put("quantity", num);
		modelHashMap.put("playerlist", sortedList);
				
		model.setViewName("userpage");
		model.addObject("model", modelHashMap);
		
		return model;
	}
	
	


	public int getQuantity(List<Player> list, User user) {
		int num = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getUserId() == user.getUserId()) {
				num++;
			}
		}
		return num;
	}
	
	public List<Player> filterList(List<Player>list, User user){
		for(int i=0;i<list.size();i++){
		if(list.get(i).getUserId() != user.getUserId()){
			list.remove(i);
		}
		}
		return list;
	}

}