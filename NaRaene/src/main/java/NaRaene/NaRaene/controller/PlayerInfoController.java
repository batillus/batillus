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
public class PlayerInfoController {

	@Autowired
	private PlayerDAO playerDAO;

	@RequestMapping(value="playerinfo")
	public ModelAndView test(HttpServletRequest request, HttpServletResponse response) throws IOException{
		ModelAndView model = new ModelAndView();
		HttpSession session = request.getSession(true);
		
		String playerIdString = (String) request.getParameter("id");
		int playerId = Integer.parseInt(playerIdString);
		Player player = playerDAO.getById(playerId);
		//String playerName = player.getPlayerName();
						
		model.setViewName("playerinfo");
		model.addObject("model", player);
		
		return model;
	}
	
}
