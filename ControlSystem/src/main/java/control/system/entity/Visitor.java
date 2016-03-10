package control.system.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "permanentVisitors")
public class Visitor {
	private static final long serialVersionUID = -5527566248002296042L;
	  
	public Visitor() {}

	@Id
	@Column(name = "visitorId") 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer visitorId;
		  
	@Column(name = "date")
	private String date;
		  
	@Column(name = "name")
	private String name;
		  
	@Column(name = "account")
	private String account;
	
	@Column(name = "phoneNumber")
	private String phoneNumber;
	
	@Column(name = "color")
	private String color;
	
	@Column(name = "phoneNumber2")
	private String phoneNumber2;
	
	@Column(name = "phoneNumber3")
	private String phoneNumber3;
	
	@Column(name = "brand")
	private String brand;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "carNumber")
	private String carNumber;
	
	@Column(name = "number")
	private String number;
	
	@Column(name = "deleted")
	private String deletedStatus;
	
	public Integer getVisitorId() {
		return visitorId;
	}
		 
	public String getDate() {
		return date;
	}
	
	public String getNumber() {
		return number;
	}
	
	public String getColor() {
		return color;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getName() {
		return name;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public String getPhoneNumber2() {
		return phoneNumber2;
	}
	
	public String getPhoneNumber3() {
		return phoneNumber3;
	}
	
	public String getAccount() {
		return account;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public String getCarNumber() {
		return carNumber;
	}
		
	public String getDeletedStatus() {
		return deletedStatus;
	}
	
	public void setVisitorId(Integer visitorId) {
		this.visitorId = visitorId;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
		 
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public void setName(String name) {
		this.name = name;
	}
		 
	public void setPhoneNumber2(String phoneNumber2) {
		this.phoneNumber2 = phoneNumber2;
	}
	
	public void setPhoneNumber3(String phoneNumber3) {
		this.phoneNumber3 = phoneNumber3;
	}
	
	public void setAccount(String account) {
		this.account = account;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public void setDeletedStatus(String deletedStatus) {
		this.deletedStatus = deletedStatus;
	}
}
