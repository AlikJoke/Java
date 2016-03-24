package archive.system.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import archive.system.dao.CitizenDao;
import archive.system.entity.Citizen;
import archive.system.service.CitizenService;

@Service("citizenService")
@Transactional
public class CitizenServiceImpl implements CitizenService {
	@Autowired
	private CitizenDao citizenDao;
	
	@Transactional
	public void add(Citizen citizen) {
		citizenDao.add(citizen);
	}

	@Transactional
	public void delete(Integer citizenId) {
		citizenDao.delete(citizenId);
	}

	@Transactional
	public Citizen get(Integer citizenId) {
		return citizenDao.get(citizenId);
	}

	@Transactional
	public List getCitizens() {
		return citizenDao.getCitizens();
	}

	@Transactional
	public void edit(Citizen citizen) {
		citizenDao.edit(citizen);		
	}
	
	@Transactional
	public List getCitizenByAccountPart(String account) {
		return citizenDao.getCitizenByAccountPart(account);
	}

	@Transactional
	public List getCitizenByPhoneNumberPart(String phoneNumber) {
		return citizenDao.getCitizenByPhoneNumberPart(phoneNumber);
	}

	public List getCitizenByNamePart(String name) {
		return citizenDao.getCitizenByNamePart(name);
	}
}
