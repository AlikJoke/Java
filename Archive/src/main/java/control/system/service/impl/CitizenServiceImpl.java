package control.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import control.system.dao.CitizenDao;
import control.system.entity.Account;
import control.system.entity.Citizen;
import control.system.service.CitizenService;

@Service
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
}