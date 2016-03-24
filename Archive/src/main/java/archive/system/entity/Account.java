package archive.system.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "accounts")
public class Account {
	
	@Id
	@Column(name = "accountId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer accountId;
	
	@Column(name = "account")
	private String account;
	
	@Column(name = "isOwner")
	private String isOwner;
	
	@ManyToOne
	@JoinColumn(name = "citizen_id")
	@ForeignKey(name = "citizen_id")
	private Citizen citizen;
	
	public void setCitizen(Citizen citizen) {
		this.citizen = citizen;
	}
	
	public String getIsOwner() {
		return isOwner;
	}
	
	public void setIsOwner(String isOwner) {
		this.isOwner = isOwner;
	}
	
	public Citizen getCitizen() {
		return citizen;
	}
	
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
