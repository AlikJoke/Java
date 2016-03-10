package control.system.dao;

import java.util.List;

import control.system.entity.Account;
import control.system.entity.Visitor;

public interface AccountDao {
	public void add(Account account);
	public void delete(Integer accountId);
	public Account get(Integer accountId);
	public List<?> getAccounts();
	public void edit(Account account);
}
