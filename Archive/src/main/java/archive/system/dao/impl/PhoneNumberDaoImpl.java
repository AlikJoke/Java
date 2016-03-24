package archive.system.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import archive.system.dao.PhoneNumberDao;
import archive.system.entity.PhoneNumber;
import archive.system.entity.Citizen;

@Repository
public class PhoneNumberDaoImpl implements PhoneNumberDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void add(Citizen citizen) {
		Iterator iterator = citizen.getPhoneNumbers().iterator();
		while (iterator.hasNext()) {
			PhoneNumber phoneNumber = new PhoneNumber();
			phoneNumber.setCitizen(citizen);
			phoneNumber.setPhoneNumber(iterator.next().toString());
			sessionFactory.getCurrentSession().save(phoneNumber);
		}
	}
	
	public void delete(Integer id) {
		List deleteList = sessionFactory.getCurrentSession().createQuery("from PhoneNumber where citizen_id='" + id +"'").list();
		Iterator iterator = deleteList.iterator();
		while (iterator.hasNext()) {
			sessionFactory.getCurrentSession().delete((PhoneNumber) iterator.next());
		}
	}
	
	public PhoneNumber get(Integer phoneId) {
		return (PhoneNumber) sessionFactory.getCurrentSession().get(PhoneNumber.class, phoneId);
	}

	public List<?> getPhoneNumbers(Integer id) {
		return sessionFactory.getCurrentSession().createQuery("from PhoneNumber where citizen_id='" + id + "'").list();
	}
	
	public void edit(PhoneNumber phoneNumber) {
		sessionFactory.getCurrentSession().update(phoneNumber);
	}
}
