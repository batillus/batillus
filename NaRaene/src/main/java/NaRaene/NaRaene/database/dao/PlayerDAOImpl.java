package NaRaene.NaRaene.database.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import NaRaene.NaRaene.database.DBException;
import NaRaene.NaRaene.domain.Player;
import NaRaene.NaRaene.domain.User;


@Repository @Transactional
public class PlayerDAOImpl implements PlayerDAO {

    @Autowired
   private SessionFactory sessionFactory;
   
    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

	public void addPlayer(Player player) {
		sessionFactory.getCurrentSession().save(player);
		
	}

	public List<Player> listPlayer() {
		return sessionFactory.getCurrentSession().createQuery("from Player").list();
	}

	public void removePlayer(long id) {
		// TODO Auto-generated method stub
		
	}

	public Player getById(Long id) {
		 return (Player) getCurrentSession().get(User.class, id);
	}

	public Player getByName(String name) {
		 return (Player) getCurrentSession().createCriteria(User.class)
	                .add(Restrictions.eq("player_name", name)).uniqueResult();
	}
    
   

		
}