package archive.system.dao;

import java.util.List;
import java.util.Set;

import archive.system.entity.Account;
import archive.system.entity.Citizen;

public interface AccountDao {
	public void add(Citizen citizen, List owners);
	public void delete(Integer accountId);
	public Account get(Integer accountId);
	public List<?> getAccounts(Integer id);
	public void edit(Account account);
}