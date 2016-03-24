package control.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import control.system.dao.PhoneNumberDao;
import control.system.entity.PhoneNumber;
import control.system.service.PhoneNumberService;

@Service
@Transactional
public class PhoneNumberServiceImpl implements PhoneNumberService {
	@Autowired
	private PhoneNumberDao phoneNumberDao;
	
	@Transactional
	public void add(PhoneNumber phoneNumber) {
		phoneNumberDao.add(phoneNumber);
	}

	@Transactional
	public void delete(Integer phoneNumberId) {
		phoneNumberDao.delete(phoneNumberId);
	}

	@Transactional
	public PhoneNumber get(Integer phoneNumberId) {
		return phoneNumberDao.get(phoneNumberId);
	}

	@Transactional
	public List getPhoneNumbers() {
		return phoneNumberDao.getPhoneNumbers();
	}

	@Transactional
	public void edit(PhoneNumber phoneNumber) {
		phoneNumberDao.edit(phoneNumber);		
	}
}