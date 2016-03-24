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
@Table(name = "phoneNumbers")
public class PhoneNumber {
	
	@Id
	@Column(name = "phoneId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer phoneId;
	
	@Column(name = "phoneNumber")
	private String phoneNumber;
	
	@ManyToOne
	@JoinColumn(name = "citizen_id")
	@ForeignKey(name = "citizen_id")
	private Citizen citizen;
	
	public void setCitizen(Citizen citizen) {
		this.citizen = citizen;
	}
	
	public Citizen getCitizen() {
		return citizen;
	}
	
	public void setPhoneNumber(String phoneNumber) {
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
}