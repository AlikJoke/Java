package control.system.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tempVisitors")
public class TempVisitor {
	private static final long serialVersionUID = -5527566248002296042L;
	  
	public TempVisitor() {}

	@Id
	@Column(name = "visitorId") 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer visitorId;
		  
	@Column(name = "date")
	private String date;
		  
	@Column(name = "dateTo")
	private String dateTo;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "nameInf")
	private String nameInf;
		  
	@Column(name = "account")
	private String account;
	
	@Column(name = "carNumber")
	private String carNumber;
	
	@Column(name = "number")
	private String number;
	
	@Column(name = "realNumber")
	private String realNumber;
	
	@Column(name = "brand")
	private String brand;
	
	@Column(name = "phoneNumber")
	private String phoneNumber;
	
	@Column(name = "phoneNumber2")
	private String phoneNumber2;
	
	@Column(name = "phoneNumber3")
	private String phoneNumber3;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "aim")
	private String aim;
	
	@Column(name = "isHere")
	private String isHere;
	
	@Column(name = "status")
	private String status;
	
	public String getAddress() {
		return address;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public String getRealNumber() {
		return realNumber;
	}
	
	public Integer getVisitorId() {
		return visitorId;
	}
		 
	public String getDate() {
		return date;
	}
	
	public String getDateTo() {
		return dateTo;
	}

	public String getName() {
		return name;
	}
	
	public String getNameInf() {
		return nameInf;
	}
	
	public String getAccount() {
		return account;
	}
	
	public String getCarNumber() {
		return carNumber;
	}
	
	public String getNumber() {
		return number;
	}
		
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public String getPhoneNumber2() {
		return phoneNumber2;
	}
	
	public String getPhoneNumber3() {
		return phoneNumber3;
	}
	
	public String getAim() {
		return aim;
	}
	
	public String getIsHere() {
		return isHere;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setNameInf(String nameInf) {
		this.nameInf = nameInf;
	}
	
	public void setVisitorId(Integer visitorId) {
		this.visitorId = visitorId;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}
		 
	public void setName(String name) {
		this.name = name;
	}
		 
	public void setAccount(String account) {
		this.account = account;
	}
	
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public void setPhoneNumber2(String phoneNumber2) {
		this.phoneNumber2 = phoneNumber2;
	}
	
	public void setPhoneNumber3(String phoneNumber3) {
		this.phoneNumber3 = phoneNumber3;
	}
	
	public void setAim(String aim) {
		this.aim = aim;
	}
	
	public void setIsHere(String isHere) {
		this.isHere = isHere;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public void setRealNumber(String realNumber) {
		this.realNumber = realNumber;
	}
}
