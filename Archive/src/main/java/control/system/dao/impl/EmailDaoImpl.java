package control.system.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import control.system.dao.EmailDao;
import control.system.entity.Email;

public class EmailDaoImpl implements EmailDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void add(Email email) {
		sessionFactory.getCurrentSession().save(email);
	}
	
	@Override
	public void delete(Integer emailId) {
		sessionFactory.getCurrentSession().delete(get(emailId));
	}
	
	@Override
	public Email get(Integer emailId) {
		return (Email) sessionFactory.getCurrentSession().get(Email.class, emailId);
	}

	@Override
	public List<?> getEmails() {
		return sessionFactory.getCurrentSession().createQuery("from Email").list();
	}
	
	@Override
	public void edit(Email email) {
		sessionFactory.getCurrentSession().update(email);
	}
}
