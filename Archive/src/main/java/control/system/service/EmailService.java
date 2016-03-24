package control.system.service;

import java.util.List;

import control.system.entity.Email;

public interface EmailService {
	public void add(Email email);
	public void delete(Integer emailId);
	public Email get(Integer emailId);
	public List<?> getEmails();
	public void edit(Email email);
}
