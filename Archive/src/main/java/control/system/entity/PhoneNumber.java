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
@Table(name = "phoneNumbers")
public class PhoneNumber {
	
	@Id
	@Column(name = "phoneId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer phoneId;
	
	@Column(name = "phoneNumber")
	private String phoneNumber;
	
	private Citizen citizen;
	
	public void setPhoneNumber(String aphoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public void setPhoneId(Integer phoneId) {
		this.phoneId = phoneId;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public Integer getPhoneId() {
		return phoneId;
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
