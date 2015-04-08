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

import NaRaene.NaRaene.database.dao.PlayerDAO;
import NaRaene.NaRaene.domain.Player;
import NaRaene.NaRaene.domain.User;

@Controller
public class CreatePlayerController {
	
	private static final int DEFAULT_HP = 100;
	private static final int DEFAULT_STR = 10;
	
	@Autowired
	private PlayerDAO playerDAO;
	
	@RequestMapping(value="createplayer")
	public ModelAndView test(HttpServletRequest request, HttpServletResponse response) throws IOException{
		ModelAndView model = new ModelAndView();
		
		String test = "test";
		if(checkForms(request)){
			createPlayerInDB(request);
			test = "true";
		} else {
			test = "false";
		}
		
		model.setViewName("createplayer");
		model.addObject("model", test);
		
		return model;
	}
	
	
	
	public boolean checkForms(HttpServletRequest request){
		
		String name = (String) request.getParameter("name");
		String type = (String) request.getParameter("type");
		
		ArrayList<String> list = new ArrayList<String>();
		list.add(name);
		list.add(type);
		
		for (String item : list) {
		    if(item == "" || item == null){
		    	return false;
		    }
		  }
		return true;
	}
	
	public void createPlayerInDB(HttpServletRequest request){
		HttpSession session = request.getSession(true);
		User user = (User) session.getAttribute("user");
		
		String name = (String) request.getParameter("name");
		String type = (String) request.getParameter("type");
		long userId = user.getUserId();
		
		Player player = new Player(name, type, userId, DEFAULT_STR, DEFAULT_HP);
		
		try{
		playerDAO.addPlayer(player);
		} catch (Exception e){
			System.out.println("bybyby");
		}
	}
	
}
