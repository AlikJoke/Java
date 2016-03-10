package control.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import control.system.dao.TempDao;
import control.system.entity.TempVisitor;
import control.system.service.TempVisitorService;

@Service
@Transactional
public class TempVisitorServiceImpl implements TempVisitorService {
	@Autowired
	private TempDao tempDao;
	
	@Transactional
	public void add(TempVisitor visitor) {
		tempDao.add(visitor);
	}

	@Transactional
	public void edit(TempVisitor visitor) {
		tempDao.edit(visitor);
	}

	@Transactional
	public void delete(Integer visitorId) {
		tempDao.delete(visitorId);
	}

	@Transactional
	public TempVisitor get(Integer visitorId) {
		return tempDao.get(visitorId);
	}

	@Transactional
	public List getTempVisitors() {
		return tempDao.getTempVisitors();
	}

	@Transactional
	public List getTempVisitorByAccount(String account) {
		return tempDao.getTempVisitorByAccount(account);
	}

	@Transactional
	public List getTempVisitorByName(String name) {
		return tempDao.getTempVisitorByName(name);
	}
	
	@Transactional
	public List getTempVisitorByNumber(String number) {
		return tempDao.getTempVisitorByNumber(number);
	}

	@Transactional
	public List<?> deleteFromView() {
		return tempDao.deleteFromView();
	}

	@Transactional
	public List getTempVisitorIsHere() {
		return tempDao.getTempVisitorIsHere();
	}
	
	@Transactional
	public List getTempVisitorByAccountPart(String account) {
		return tempDao.getTempVisitorByAccountPart(account);
	}
	
	@Transactional
	public List getTempVisitorByNamePart(String name) {
		return tempDao.getTempVisitorByNamePart(name);
	}
	
	@Transactional
	public List getTempVisitorByPhoneNumberPart(String name) {
		return tempDao.getTempVisitorByPhoneNumberPart(name);
	}

	@Transactional
	public List getTempVisitorByNumberAndStatusIn(String numb) {
		return tempDao.getTempVisitorByNumberAndStatusIn(numb);
	}

	@Transactional
	public List getTempVisitorByNumberAndStatusOut(String numb) {
		return tempDao.getTempVisitorByNumberAndStatusOut(numb);
	}
	
	@Transactional
	public List getTempVisitorIsNotHere() {
		return tempDao.getTempVisitorIsNotHere();
	}
}
