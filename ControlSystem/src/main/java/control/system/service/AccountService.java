package control.system.service;

import java.util.List;

import control.system.entity.Account;

public interface AccountService {
	public void add(Account account);
	public void delete(Integer accountId);
	public Account get(Integer accountId);
	public List<?> getAccounts();
	public void edit(Account account);
}
