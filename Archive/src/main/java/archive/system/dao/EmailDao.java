package archive.system.dao;

import java.util.List;

import archive.system.entity.Citizen;
import archive.system.entity.Email;

public interface EmailDao {
	public void add(Citizen citizen);
	public void delete(Integer emailId);
	public Email get(Integer emailId);
	public List<?> getEmails(Integer id);
	public void edit(Email email);
}
