package archive.system.dao;

import java.util.List;

import archive.system.entity.Account;
import archive.system.entity.AccountList;

public interface AccountListDao {
	public void add(AccountList account);
	public void delete(Integer accountId);
	public AccountList get(Integer accountId);
	public List<?> getAccounts();
	public void edit(AccountList account);
}
