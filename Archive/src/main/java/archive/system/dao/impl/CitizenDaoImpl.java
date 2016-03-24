package archive.system.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import archive.system.dao.CitizenDao;
import archive.system.entity.Account;
import archive.system.entity.Citizen;
import archive.system.entity.PhoneNumber;

@Repository
public class CitizenDaoImpl implements CitizenDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void add(Citizen citizen) {
		sessionFactory.getCurrentSession().save(citizen);
	}
	

	public void delete(Integer id) {
		sessionFactory.getCurrentSession().delete(get(id));
	}
	

	public Citizen get(Integer id) {
		return (Citizen) sessionFactory.getCurrentSession().get(Citizen.class, id);
	}


	public List<?> getCitizens() {
		return sessionFactory.getCurrentSession().createQuery("from Citizen").list();
	}
	
	
	public void edit(Citizen citizen) {
		sessionFactory.getCurrentSession().update(citizen);
	}


	public List getCitizenByAccountPart(String account) {
		List visitorList = sessionFactory.getCurrentSession().createQuery("from Account").list();
        List visitorListResult = sessionFactory.getCurrentSession().createQuery("from Account").list();
        visitorListResult.removeAll(visitorList);
        for(int i = 0; i < visitorList.size(); i++) 
            if ( ((Account) visitorList.get(i)).getAccount().toString().toLowerCase().contains(account) || ((Account) visitorList.get(i)).getAccount().toLowerCase().toString().equals(account)) 
            	visitorListResult.add(visitorList.get(i));
        List citizenList = new ArrayList();
        for (int i = 0; i < visitorListResult.size(); i++)
        	citizenList.add(((Account) visitorListResult.get(i)).getCitizen());
		return citizenList;
	}


	public List getCitizenByPhoneNumberPart(String phoneNumber) {
		List visitorList = sessionFactory.getCurrentSession().createQuery("from PhoneNumber").list();
        List visitorListResult = sessionFactory.getCurrentSession().createQuery("from PhoneNumber").list();
        visitorListResult.removeAll(visitorList);
        for(int i = 0; i < visitorList.size(); i++) 
            if ( ((PhoneNumber) visitorList.get(i)).getPhoneNumber().toString().replaceAll(" ", "").replace(")", "").replace("(", "").contains(phoneNumber) || ((PhoneNumber) visitorList.get(i)).getPhoneNumber().toString().replaceAll(" ", "").replace(")", "").replace("(", "").equals(phoneNumber)) 
            	visitorListResult.add(visitorList.get(i));
        List citizenList = new ArrayList();
        for (int i = 0; i < visitorListResult.size(); i++)
        	citizenList.add(((PhoneNumber) visitorListResult.get(i)).getCitizen());
		return citizenList;
	}


	public List getCitizenByNamePart(String name) {
		List visitorList = sessionFactory.getCurrentSession().createQuery("from Citizen").list();
        List visitorListResult = sessionFactory.getCurrentSession().createQuery("from Citizen").list();
        visitorListResult.removeAll(visitorList);
        for(int i = 0; i < visitorList.size(); i++) 
            if ( ((Citizen) visitorList.get(i)).getName().toString().toLowerCase().contains(name) || ((Citizen) visitorList.get(i)).getName().toString().toLowerCase().equals(name)) 
            	visitorListResult.add(visitorList.get(i));
        return visitorListResult;
	}
}