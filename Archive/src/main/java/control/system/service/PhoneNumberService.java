package control.system.service;

import java.util.List;

import control.system.entity.PhoneNumber;

public interface PhoneNumberService {
	public void add(PhoneNumber phoneNumber);
	public void delete(Integer phoneId);
	public PhoneNumber get(Integer phoneId);
	public List<?> getPhoneNumbers();
	public void edit(PhoneNumber phoneNumber);
}
