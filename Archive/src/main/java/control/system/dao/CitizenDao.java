package control.system.dao;

import java.util.List;

import control.system.entity.Citizen;

public interface CitizenDao {
	public void add(Citizen citizen);
	public void delete(Integer citizenId);
	public Citizen get(Integer citizenId);
	public List<?> getCitizens();
	public void edit(Citizen citizen);
}
