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
@Table(name = "Emails")
public class Email {
	
	@Id
	@Column(name = "emailId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer emailId;
	
	@Column(name = "email")
	private String email;
	
	private Citizen citizen;
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setEmailId(Integer emailId) {
		this.emailId = emailId;
	}
	
	public String getEmail() {
		return email;
	}
	
	public Integer getEmailId() {
		return emailId;
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
