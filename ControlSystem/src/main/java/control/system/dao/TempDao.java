package control.system.dao;

import java.util.List;

import control.system.entity.TempVisitor;

public interface TempDao {
	public void add(TempVisitor visitor);
	public void edit(TempVisitor visitor);
	public void delete(Integer visitorId);
	public TempVisitor get(Integer visitorId);
	public List getTempVisitorByAccount(String account);
	public List getTempVisitorByName(String name);
	public List<?> getTempVisitors();
	public List getTempVisitorByNumber(String number);
	public List<?> deleteFromView();
	public List getTempVisitorIsHere();
	public List getTempVisitorByAccountPart(String account);
	public List getTempVisitorByNamePart(String name);
	public List getTempVisitorByPhoneNumberPart(String name);
	public List getTempVisitorByNumberAndStatusIn(String numb);
	public List getTempVisitorByNumberAndStatusOut(String numb);
	public List getTempVisitorIsNotHere();
}
