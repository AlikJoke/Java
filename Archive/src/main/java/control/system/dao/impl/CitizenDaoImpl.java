package control.system.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import control.system.dao.CitizenDao;
import control.system.entity.Citizen;

@Repository
public class CitizenDaoImpl implements CitizenDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void add(Citizen citizen) {
		sessionFactory.getCurrentSession().save(citizen);
	}
	
	@Override
	public void delete(Integer id) {
		sessionFactory.getCurrentSession().delete(get(id));
	}
	
	@Override
	public Citizen get(Integer id) {
		return (Citizen) sessionFactory.getCurrentSession().get(Citizen.class, id);
	}

	@Override
	public List<?> getCitizens() {
		return sessionFactory.getCurrentSession().createQuery("from Citizen").list();
	}
	
	@Override
	public void edit(Citizen citizen) {
		sessionFactory.getCurrentSession().update(citizen);
	}
}
