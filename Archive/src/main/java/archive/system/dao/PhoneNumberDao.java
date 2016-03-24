package archive.system.dao;

import java.util.List;

import archive.system.entity.Citizen;
import archive.system.entity.PhoneNumber;

public interface PhoneNumberDao {
	public void add(Citizen citizen);
	public void delete(Integer phoneId);
	public PhoneNumber get(Integer phoneId);
	public List<?> getPhoneNumbers(Integer id);
	public void edit(PhoneNumber phoneNumber);
}
