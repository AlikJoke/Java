package archive.system.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import archive.system.dao.EmailDao;
import archive.system.entity.Email;
import archive.system.entity.Citizen;

@Repository
public class EmailDaoImpl implements EmailDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void add(Citizen citizen) {
		Iterator iterator = citizen.getEmails().iterator();
		while (iterator.hasNext()) {
			Email email = new Email();
			email.setCitizen(citizen);
			email.setEmail(iterator.next().toString());
			sessionFactory.getCurrentSession().save(email);
		}
	}
	
	public void delete(Integer id) {
		List deleteList = sessionFactory.getCurrentSession().createQuery("from Email where citizen_id='" + id +"'").list();
		Iterator iterator = deleteList.iterator();
		while (iterator.hasNext()) {
			sessionFactory.getCurrentSession().delete( (Email) iterator.next());
		}
	}
	
	public Email get(Integer emailId) {
		return (Email) sessionFactory.getCurrentSession().get(Email.class, emailId);
	}

	public List<?> getEmails(Integer id) {
		return sessionFactory.getCurrentSession().createQuery("from Email where citizen_id='" + id +"'").list();
	}
	
	public void edit(Email email) {
		sessionFactory.getCurrentSession().update(email);
	}
}
