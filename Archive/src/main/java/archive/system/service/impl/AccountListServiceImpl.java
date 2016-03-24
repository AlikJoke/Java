package archive.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import archive.system.dao.AccountListDao;
import archive.system.entity.Account;
import archive.system.entity.AccountList;
import archive.system.service.AccountListService;

@Service("accountListService")
@Transactional
public class AccountListServiceImpl implements AccountListService {
	@Autowired
	private AccountListDao accountDao;
	
	@Transactional
	public void add(AccountList account) {
		accountDao.add(account);
	}

	@Transactional
	public void delete(Integer accountId) {
		accountDao.delete(accountId);
	}

	@Transactional
	public AccountList get(Integer accountId) {
		return accountDao.get(accountId);
	}

	@Transactional
	public List getAccounts() {
		return accountDao.getAccounts();
	}

	@Transactional
	public void edit(AccountList account) {
		accountDao.edit(account);		
	}
}
