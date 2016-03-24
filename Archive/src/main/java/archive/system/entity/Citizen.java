package archive.system.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@Column(name = "isResponsible")
	private String isResponsible;
	
	@Column(name = "addressTSJ")
	private String addressTSJ;
	
	@Column(name = "addressReal")
	private String addressReal;
	
	@OneToMany(targetEntity=Account.class, fetch = FetchType.EAGER, mappedBy = "citizen")
	private Set<Account> accounts = new HashSet<Account>() ;
	
	@OneToMany(targetEntity=PhoneNumber.class, fetch = FetchType.EAGER, mappedBy = "citizen")
	private Set<PhoneNumber> phoneNumbers;
	
	@OneToMany(targetEntity=Email.class, fetch = FetchType.EAGER, mappedBy = "citizen")
	private Set<Email> emails;

	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}
	
	public Set<Account> getAccounts() {
		return accounts;
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
	
	public String getIsMember() {
		return isMember;
	}
	
	public String getIsResponsible() {
		return isResponsible;
	}
	
	public String getAddressTSJ() {
		return addressTSJ;
	}
	
	public String getAddressReal() {
		return addressReal;
	}
	
	public Set<PhoneNumber> getPhoneNumbers() {
		return phoneNumbers;
	}
	
	public Set<Email> getEmails() {
		return emails;
	}
}
