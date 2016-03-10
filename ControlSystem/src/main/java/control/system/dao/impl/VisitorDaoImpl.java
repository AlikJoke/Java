package control.system.dao.impl;
 
import java.util.Iterator;
import java.util.List;
 
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
 
import control.system.dao.VisitorDao;
import control.system.entity.Visitor;
 
@Repository
public class VisitorDaoImpl implements VisitorDao {
 
    @Autowired
    private SessionFactory sessionFactory;
     
    @Override
    public void add(Visitor visitor) {
        sessionFactory.getCurrentSession().save(visitor);
    }
 
    @Override
    public void edit(Visitor visitor) {
        sessionFactory.getCurrentSession().update(visitor);
    }
 
    @Override
    public boolean delete(String account, String name) {
        List list = sessionFactory.getCurrentSession().createQuery("from Visitor where deleted=null and account='" + account +
                "' and name='" + name + "'").list();
        Iterator iterator = list.iterator();
        while(iterator.hasNext())
            ((Visitor) iterator.next()).setDeletedStatus("deleted");
        return true;
    }
 
    @Override
    public Visitor get(Integer visitorId) {
        return(Visitor) sessionFactory.getCurrentSession().get(Visitor.class, visitorId);
    }
 
    @Override
    public List getVisitors() {
        return sessionFactory.getCurrentSession().createQuery("from Visitor where deleted=null and carNumber=null").list();
    }
 
    @Override
    public List<Visitor> getVisitorByAccount(String account) {
        return sessionFactory.getCurrentSession().createQuery("from Visitor where deleted=null and account='" + account + "'").list();
    }
 
    @Override
    public List getVisitorByName(String name) {
        return sessionFactory.getCurrentSession().createQuery("from Visitor where deleted=null and name='" + name + "'").list();
    }
     
    @Override
    public List getVisitorByNumber(String number) {
        return sessionFactory.getCurrentSession().createQuery("from Visitor where deleted=null and number='" + number + "'").list();
    }
     
    @Override
    public List getVisitorsAll() {
        return sessionFactory.getCurrentSession().createQuery("from Visitor where deleted=null").list();
    }
     
    @Override
    public List getVisitorByAccountPart(String account) {
        List visitorList = getVisitors();
        List visitorListResult = getVisitors();
        visitorListResult.removeAll(visitorList);
        for(int i = 0; i < visitorList.size(); i++) {
            if ( ((Visitor) visitorList.get(i)).getAccount().toString().contains(account) || ((Visitor) visitorList.get(i)).getAccount().toString().equals(account)) visitorListResult.add(visitorList.get(i));
        }
         
        return visitorListResult;
    }
     
    @Override
    public List getVisitorByAccountAndName(String account, String name) {
        return sessionFactory.getCurrentSession().createQuery("from Visitor where carNumber<>null and brand<>null and deleted=null and "
                + "account='" + account + "' and name='" + name + "'").list();
    }
 
    @Override
    public List getVisitorByNamePart(String name) {
        List visitorList = getVisitors();
        List visitorListResult = getVisitors();
        visitorListResult.removeAll(visitorList);
        for(int i = 0; i < visitorList.size(); i++) {
            if ( ((Visitor) visitorList.get(i)).getName().toLowerCase().contains(name)) visitorListResult.add(visitorList.get(i));
        }
        return visitorListResult;
    }
     
    @Override
    public boolean deleteFromView(String account, String name) {
        if (getVisitorByAccountAndName(account, name) != null)  {
            return true;
        }
        else
            return false;
    }
 
    @Override
    public List getVisitorByPhoneNumberPart(String phoneNumber) {
        List visitorList = getVisitors();
        List visitorListResult = getVisitors();
        visitorListResult.removeAll(visitorList);
        for(int i = 0; i < visitorList.size(); i++) {
            if ( ((Visitor) visitorList.get(i)).getPhoneNumber().replaceAll(" ", "").replace(")", "").replace("(", "").toLowerCase().contains(phoneNumber)) 
                visitorListResult.add(visitorList.get(i));
            if (((Visitor) visitorList.get(i)).getPhoneNumber2().toString().length() == 0 || ((Visitor) visitorList.get(i)).getPhoneNumber2() == null) {}
            else
            	if ( ((Visitor) visitorList.get(i)).getPhoneNumber2().replaceAll(" ", "").replace(")", "").replace("(", "").toLowerCase().contains(phoneNumber)) 
            		visitorListResult.add(visitorList.get(i));
            if (((Visitor) visitorList.get(i)).getPhoneNumber3().toString().length() == 0 || ((Visitor) visitorList.get(i)).getPhoneNumber3() == null) {}
            else
            	if ( ((Visitor) visitorList.get(i)).getPhoneNumber3().replaceAll(" ", "").replace(")", "").replace("(", "").toLowerCase().contains(phoneNumber)) 
            		visitorListResult.add(visitorList.get(i));
        }
        return visitorListResult;
    }
 
    @Override
    public boolean deleteCar(Integer visitorId) {
        sessionFactory.getCurrentSession().delete(get(visitorId));
        return false;
    }
}