package control.system.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "accountList")
public class Account {
	
	@Id
	@Column(name = "accountId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer accountId;
	
	@Column(name = "account")
	private String account;
	
	public void setAccount(String account) {
		this.account = account;
	}
	
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	
	public String getAccount() {
		return account;
	}
	
	public Integer getAccountId() {
		return accountId;
	}
}
