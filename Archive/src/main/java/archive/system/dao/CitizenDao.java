package archive.system.dao;

import java.util.List;

import archive.system.entity.Citizen;

public interface CitizenDao {
	public void add(Citizen citizen);
	public void delete(Integer citizenId);
	public Citizen get(Integer citizenId);
	public List<?> getCitizens();
	public void edit(Citizen citizen);
	public List getCitizenByAccountPart(String account);
	public List getCitizenByPhoneNumberPart(String phoneNumber);
	public List getCitizenByNamePart(String name);
}