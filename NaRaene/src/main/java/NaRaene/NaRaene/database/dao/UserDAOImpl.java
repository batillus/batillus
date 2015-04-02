package NaRaene.NaRaene.database.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import NaRaene.NaRaene.database.DBException;
import NaRaene.NaRaene.domain.User;

@Repository @Transactional
public class UserDAOImpl implements UserDAO {

    @Autowired
   private SessionFactory sessionFactory;
   
    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
    
    public void addUser(User user) {
		sessionFactory.getCurrentSession().save(user);
		
	}
    
    public User getById(Long id) {
        return (User) getCurrentSession().get(User.class, id);
    }
    
    @SuppressWarnings("unchecked")
    public List<User> listUser() {
		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}

    public void removeUser(long id) {
        User user = (User) sessionFactory.getCurrentSession().load(
                User.class, id);
        if (null != user) {
            sessionFactory.getCurrentSession().delete(user);
        }

    }

		
}
