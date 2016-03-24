package control.system.service;

import java.util.List;

import control.system.entity.Visitor;

public interface VisitorService {
	public void add(Visitor visitor);
	public void edit(Visitor visitor);
	public boolean delete(String account, String name);
	public Visitor get(Integer visitorId);
	public List getVisitorByAccount(String account);
	public List getVisitorByName(String name);
	public List getVisitorByNumber(String number);
	public List getVisitorByAccountAndName(String account, String name);
	public List<?> getVisitors();
	public boolean deleteFromView(String account, String name);
	public List getVisitorByAccountPart(String account);
	public List getVisitorByNamePart(String name);
	public List getVisitorByPhoneNumberPart(String name);
	public List<?> getVisitorsAll();
	public boolean deleteCar(Integer visitorId);
}
