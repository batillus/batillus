package NaRaene.NaRaene.database.dao;

import java.util.List;

import NaRaene.NaRaene.domain.User;

public interface UserDAO {

	 public void addUser(User user);

	    public List<User> listUser();

	    public void removeUser(long id);
	    
	    public User getById(Long id);
	}