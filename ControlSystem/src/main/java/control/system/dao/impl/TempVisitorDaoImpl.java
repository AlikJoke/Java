package control.system.dao.impl;
 
import java.util.List;
 
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
 
import control.system.dao.TempDao;
import control.system.entity.TempVisitor;
import control.system.entity.Visitor;
 
public class TempVisitorDaoImpl implements TempDao {
    @Autowired
    private SessionFactory sessionFactory;
     
    @Override
    public void add(TempVisitor visitor) {
        sessionFactory.getCurrentSession().save(visitor);
    }
 
    @Override
    public void edit(TempVisitor visitor) {
        sessionFactory.getCurrentSession().update(visitor);
    }
 
    @Override
    public void delete(Integer visitorId) {
        sessionFactory.getCurrentSession().delete(get(visitorId));
    }
 
    @Override
    public TempVisitor get(Integer visitorId) {
        return(TempVisitor) sessionFactory.getCurrentSession().get(TempVisitor.class, visitorId);
    }
 
    @Override
    public List getTempVisitors() {
        return sessionFactory.getCurrentSession().createQuery("from TempVisitor where status<>'CLOSE'").list();
    }
 
    @Override
    public List getTempVisitorByAccount(String account) {
        return sessionFactory.getCurrentSession().createQuery("from TempVisitor where status<>'CLOSE'and account='" + account + "'").list();
    }
 
    @Override
    public List getTempVisitorByName(String name) {
        return sessionFactory.getCurrentSession().createQuery("from TempVisitor where status<>'CLOSE' and name='" + name + "'").list();
    }
     
    @Override
    public List getTempVisitorByNumber(String number) {
        return sessionFactory.getCurrentSession().createQuery("from TempVisitor where status<>'CLOSE' and number='" + number + "'").list();
    }
 
    @Override
    public List<?> deleteFromView() {
        return sessionFactory.getCurrentSession().createQuery("from TempVisitor where status<>'CLOSE'").list();
    }
 
    @Override
    public List getTempVisitorIsHere() {
        return sessionFactory.getCurrentSession().createQuery("from TempVisitor where status='Выпустить'").list();
    }
    
    @Override
    public List getTempVisitorIsNotHere() {
    	return sessionFactory.getCurrentSession().createQuery("from TempVisitor where status='Запустить'").list();
    }
 
    @Override
    public List getTempVisitorByNamePart(String name) {
        List visitorList = getTempVisitors();
        List visitorListResult = getTempVisitors();
        visitorListResult.removeAll(visitorList);
        for(int i = 0; i < visitorList.size(); i++) {
            if ( ((TempVisitor) visitorList.get(i)).getName().toLowerCase().contains(name)) visitorListResult.add(visitorList.get(i));
        }
        return visitorListResult;
    }
     
    @Override
    public List getTempVisitorByAccountPart(String account) {
        List visitorList = getTempVisitors();
        List visitorListResult = getTempVisitors();
        visitorListResult.removeAll(visitorList);
        for(int i = 0; i < visitorList.size(); i++) {
            if ( ((TempVisitor) visitorList.get(i)).getAccount().contains(account)) visitorListResult.add(visitorList.get(i));
        }
        return visitorListResult;
    }
     
    @Override
    public List getTempVisitorByPhoneNumberPart(String phoneNumber) {
        List visitorList = getTempVisitors();
        List visitorListResult = getTempVisitors();
        visitorListResult.removeAll(visitorList);
        for(int i = 0; i < visitorList.size(); i++) {
            if ( ((TempVisitor) visitorList.get(i)).getPhoneNumber().replaceAll(" ", "").replace(")", "").replace("(", "").contains(phoneNumber)) 
                visitorListResult.add(visitorList.get(i));
            if (((TempVisitor) visitorList.get(i)).getPhoneNumber2().toString().length() == 0 || ((TempVisitor) visitorList.get(i)).getPhoneNumber2() == null) {}
            else
            	if ( ((TempVisitor) visitorList.get(i)).getPhoneNumber2().replaceAll(" ", "").replace(")", "").replace("(", "").contains(phoneNumber)) 
            		visitorListResult.add(visitorList.get(i));
            if (((TempVisitor) visitorList.get(i)).getPhoneNumber3().toString().length() == 0 || ((TempVisitor) visitorList.get(i)).getPhoneNumber3() == null) {}
            else
            	if ( ((TempVisitor) visitorList.get(i)).getPhoneNumber3().replaceAll(" ", "").replace(")", "").replace("(", "").contains(phoneNumber))
            		visitorListResult.add(visitorList.get(i));
        }
        return visitorListResult;
    }
 
    @Override
    public List getTempVisitorByNumberAndStatusIn(String numb) {
        return sessionFactory.getCurrentSession().createQuery("from TempVisitor where status='Запустить' and number='" + numb + "'").list();
    }
 
    @Override
    public List getTempVisitorByNumberAndStatusOut(String numb) {
        return sessionFactory.getCurrentSession().createQuery("from TempVisitor where status='Выпустить' and number='" + numb + "'").list();
    }
}