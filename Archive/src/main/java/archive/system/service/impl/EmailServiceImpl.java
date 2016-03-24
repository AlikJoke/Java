package archive.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import archive.system.dao.EmailDao;
import archive.system.entity.Citizen;
import archive.system.entity.Email;
import archive.system.service.EmailService;

@Service("emailService")
@Transactional
public class EmailServiceImpl implements EmailService {
	@Autowired
	private EmailDao emailDao;

	@Transactional
	public void add(Citizen citizen) {
		emailDao.add(citizen);
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
	public List getEmails(Integer id) {
		return emailDao.getEmails(id);
	}

	@Transactional
	public void edit(Email email) {
		emailDao.edit(email);		
	}
}
