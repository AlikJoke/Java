package archive.system.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import archive.system.dao.AccountListDao;
import archive.system.entity.AccountList;

@Repository
public class AccountListDaoImpl implements AccountListDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void add(AccountList account) {
		sessionFactory.getCurrentSession().save(account);
	}
	
	public void delete(Integer accountId) {
		sessionFactory.getCurrentSession().delete(get(accountId));
	}
	
	public AccountList get(Integer accountId) {
		return (AccountList) sessionFactory.getCurrentSession().get(AccountList.class, accountId);
	}

	public List<?> getAccounts() {
		return sessionFactory.getCurrentSession().createQuery("from AccountList").list();
	}
	
	public void edit(AccountList account) {
		sessionFactory.getCurrentSession().update(account);
	}
}
