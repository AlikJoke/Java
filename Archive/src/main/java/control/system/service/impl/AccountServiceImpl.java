package control.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import control.system.dao.AccountDao;
import control.system.entity.Account;
import control.system.service.AccountService;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountDao accountDao;
	
	@Transactional
	public void add(Account account) {
		accountDao.add(account);
	}

	@Transactional
	public void delete(Integer accountId) {
		accountDao.delete(accountId);
	}

	@Transactional
	public Account get(Integer accountId) {
		return accountDao.get(accountId);
	}

	@Transactional
	public List getAccounts() {
		return accountDao.getAccounts();
	}

	@Transactional
	public void edit(Account account) {
		accountDao.edit(account);		
	}
}
