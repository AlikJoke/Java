package archive.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import archive.system.dao.PhoneNumberDao;
import archive.system.entity.PhoneNumber;
import archive.system.entity.Citizen;
import archive.system.service.PhoneNumberService;

@Service("phoneNumberService")
@Transactional
public class PhoneNumberServiceImpl implements PhoneNumberService {
	@Autowired
	private PhoneNumberDao phoneNumberDao;

	@Transactional
	public void add(Citizen citizen) {
		phoneNumberDao.add(citizen);
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
	public List getPhoneNumbers(Integer id) {
		return phoneNumberDao.getPhoneNumbers(id);
	}

	@Transactional
	public void edit(PhoneNumber phoneNumber) {
		phoneNumberDao.edit(phoneNumber);		
	}
}
