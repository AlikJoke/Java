package control.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import control.system.dao.EmailDao;
import control.system.entity.Email;
import control.system.service.EmailService;

@Service
@Transactional
public class EmailServiceImpl implements EmailService {
	@Autowired
	private EmailDao emailDao;
	
	@Transactional
	public void add(Email email) {
		emailDao.add(email);
	}

	@Transactional
	public void delete(Integer emailId) {
		emailDao.delete(emailId);
	}

	@Transactional
	public Email get(Integer emailId) {
		return emailDao.get(emailId);
	}

	@Transactional
	public List getEmails() {
		return emailDao.getEmails();
	}

	@Transactional
	public void edit(Email email) {
		emailDao.edit(email);		
	}
}