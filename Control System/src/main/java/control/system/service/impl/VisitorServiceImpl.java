package control.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import control.system.dao.VisitorDao;
import control.system.entity.Visitor;
import control.system.service.VisitorService;

@Service
@Transactional
public class VisitorServiceImpl implements VisitorService {
	@Autowired
	private VisitorDao visitorDao;
	
	@Transactional
	public void add(Visitor visitor) {
		visitorDao.add(visitor);
	}

	@Transactional
	public void edit(Visitor visitor) {
		visitorDao.edit(visitor);
	}

	@Transactional
	public boolean delete(String account, String name) {
		return visitorDao.delete(account, name);
	}

	@Transactional
	public Visitor get(Integer visitorId) {
		return visitorDao.get(visitorId);
	}

	@Transactional
	public List getVisitors() {
		return visitorDao.getVisitors();
	}

	@Transactional
	public List getVisitorByAccount(String account) {
		return visitorDao.getVisitorByAccount(account);
	}

	@Transactional
	public List getVisitorByName(String name) {
		return visitorDao.getVisitorByName(name);
	}
	
	@Transactional
	public List getVisitorByNumber(String number) {
		return visitorDao.getVisitorByNumber(number);
	}
	
	@Transactional
	public List getVisitorByAccountAndName(String account, String name) {
		return visitorDao.getVisitorByAccountAndName(account, name);
	}

	@Transactional
	public boolean deleteFromView(String account, String name) {
		return visitorDao.deleteFromView(account, name);
	}

	@Transactional
	public List getVisitorByAccountPart(String account) {
		return visitorDao.getVisitorByAccountPart(account);
	}

	@Transactional
	public List getVisitorByNamePart(String name) {
		return visitorDao.getVisitorByNamePart(name);
	}

	@Transactional
	public List getVisitorByPhoneNumberPart(String phoneNumber) {
		return visitorDao.getVisitorByPhoneNumberPart(phoneNumber);
	}
	
	@Transactional
	public List getVisitorsAll() {
		return visitorDao.getVisitorsAll();
	}

	@Override
	public boolean deleteCar(Integer visitorId) {
		return visitorDao.deleteCar(visitorId);
	}
}
