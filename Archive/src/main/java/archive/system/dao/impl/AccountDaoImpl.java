package archive.system.dao.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import archive.system.dao.AccountDao;
import archive.system.entity.Account;
import archive.system.entity.Citizen;

@Repository
public class AccountDaoImpl implements AccountDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void add(Citizen citizen, List owners) {
		Iterator iterator = citizen.getAccounts().iterator();
		Iterator iteratorOwner = owners.iterator();
		int i = 0;
		while (iterator.hasNext() && i != citizen.getAccounts().size()) {
			
			Account account = new Account();			
			account.setCitizen(citizen);
			account.setAccount(iterator.next().toString());
			account.setIsOwner(owners.get(i).toString());				
			i++;
			sessionFactory.getCurrentSession().save(account);
		}
	}
	
	
	public void delete(Integer id) {
		List deleteList = sessionFactory.getCurrentSession().createQuery("from Account where citizen_id='" + id +"'").list();
		Iterator iterator = deleteList.iterator();
		while (iterator.hasNext()) {
			sessionFactory.getCurrentSession().delete( (Account) iterator.next());
		}
	}
	
	public Account get(Integer accountId) {
		return (Account) sessionFactory.getCurrentSession().get(Account.class, accountId);
	}

	public List<?> getAccounts(Integer id) {
		return sessionFactory.getCurrentSession().createQuery("from Account where citizen_id='" + id +"'").list();
	}
	
	public void edit(Account account) {
		sessionFactory.getCurrentSession().update(account);
	}
}
