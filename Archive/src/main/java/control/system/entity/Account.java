package control.system.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "accounts")
public class Account {
	
	@Id
	@Column(name = "accountId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer accountId;
	
	@Column(name = "account")
	private String account;
	
	private Citizen citizen;
	
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
	
	@ManyToOne
	@JoinColumn(name = "id")
	public Citizen getCitizen() {
		return citizen;
	}
	
	public void setCitizen(Citizen citizen) {
		this.citizen = citizen;
	}
}
