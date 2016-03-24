package archive.system.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import archive.system.dao.AccountDao;
import archive.system.entity.Account;
import archive.system.entity.Citizen;
import archive.system.service.AccountService;

@Service("accountService")
@Transactional
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountDao accountDao;

	@Transactional
	public void add(Citizen citizen, List owners) {
		accountDao.add(citizen, owners);
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
	public List getAccounts(Integer id) {
		return accountDao.getAccounts(id);
	}

	@Transactional
	public void edit(Account account) {
		accountDao.edit(account);		
	}
}
