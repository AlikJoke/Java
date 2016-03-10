package control.system.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import control.system.dao.AccountDao;
import control.system.entity.Account;
import control.system.entity.Visitor;

public class AccountDaoImpl implements AccountDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void add(Account account) {
		sessionFactory.getCurrentSession().save(account);
	}
	
	@Override
	public void delete(Integer accountId) {
		sessionFactory.getCurrentSession().delete(get(accountId));
	}
	
	@Override
	public Account get(Integer accountId) {
		return (Account) sessionFactory.getCurrentSession().get(Account.class, accountId);
	}

	@Override
	public List<?> getAccounts() {
		return sessionFactory.getCurrentSession().createQuery("from Account").list();
	}
	
	@Override
	public void edit(Account account) {
		sessionFactory.getCurrentSession().update(account);
	}
}
