package control.system.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "citizens")
public class Citizen {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "isMember")
	private String isMember;
	
	@Column(name = "isOwner")
	private String isOwner;
	
	@Column(name = "isResponsible")
	private String isResponsible;
	
	@Column(name = "addressTJS")
	private String addressTSJ;
	
	@Column(name = "addressReal")
	private String addressReal;

	@OneToMany(targetEntity = Account.class, mappedBy = "citizen",
			cascade  = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Account> accounts;
	
	@OneToMany(targetEntity = PhoneNumber.class, mappedBy = "citizen",
			cascade  = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<PhoneNumber> phoneNumbers;
	
	@OneToMany(targetEntity = Email.class, mappedBy = "citizen",
			cascade  = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Email> emails;
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setIsOwner(String isOwner) {
		this.isOwner = isOwner;
	}
	
	public void setIsResponsible(String isResponsible) {
		this.isResponsible = isResponsible;
	}
	
	public void setIsMember(String isMember) {
		this.isMember = isMember;
	}
	
	public void setAddressTSJ(String addressTSJ) {
		this.addressTSJ = addressTSJ;
	}
	
	public void setAddressReal(String addressReal) {
		this.addressReal = addressReal;
	}
	
	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}
	
	public void setPhoneNumbers(Set<PhoneNumber> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	
	public void setEmails(Set<Email> emails) {
		this.emails = emails;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getIsOwner() {
		return isOwner;
	}
	
	public String getIsMember() {
		return isMember;
	}
	
	public String getIsResponsible() {
		return isResponsible;
	}
	
	public String getAddressTJS() {
		return addressTSJ;
	}
	
	public String getAddressReal() {
		return addressReal;
	}
	
	public Set<Account> getAccounts() {
		return accounts;
	}
	
	
	public Set<PhoneNumber> getPhoneNumbers() {
		return phoneNumbers;
	}
	
	public Set<Email> getEmails() {
		return emails;
	}
}
