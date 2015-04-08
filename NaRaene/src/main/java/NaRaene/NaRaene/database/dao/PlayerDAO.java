package NaRaene.NaRaene.database.dao;

import java.util.List;

import NaRaene.NaRaene.domain.Player;
import NaRaene.NaRaene.domain.User;

public interface PlayerDAO {

	 public void addPlayer (Player player);

	    public List<Player> listPlayer();

	    public void removePlayer(long id);
	    
	    public Player getById(Long id);
	    
	    public Player getByName(String name);
	}