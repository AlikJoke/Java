package control.system.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import control.system.dao.PhoneNumberDao;
import control.system.entity.Account;
import control.system.entity.PhoneNumber;

public class PhoneNumberDaoImpl implements PhoneNumberDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void add(PhoneNumber phoneNumber) {
		sessionFactory.getCurrentSession().save(phoneNumber);
	}
	
	@Override
	public void delete(Integer phoneId) {
		sessionFactory.getCurrentSession().delete(get(phoneId));
	}
	
	@Override
	public PhoneNumber get(Integer phoneId) {
		return (PhoneNumber) sessionFactory.getCurrentSession().get(Account.class, phoneId);
	}

	@Override
	public List<?> getPhoneNumbers() {
		return sessionFactory.getCurrentSession().createQuery("from PhoneNumber").list();
	}
	
	@Override
	public void edit(PhoneNumber phoneNumber) {
		sessionFactory.getCurrentSession().update(phoneNumber);
	}
}
