package control.system.controller;
 
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import control.system.entity.Account;
import control.system.entity.TempVisitor;
import control.system.entity.Visitor;
import control.system.service.AccountService;
import control.system.service.TempVisitorService;
import control.system.service.VisitorService;
 
@Controller
public class MainController {
    @Autowired
    private VisitorService visitorService;
     
    @Autowired
    private TempVisitorService tempVisitorService;
     
    @Autowired
    private AccountService accountService;
     
    int size;
     
    List visitorList = new ArrayList();
    Visitor visitorResultForTemp = new Visitor();
    Integer id;
    Integer idDeleted;
    String searchExist;
    
    @RequestMapping({"/index", "/"})
    public String setupForm(Map<String, Object> map) {
        Visitor permanentVisitor = new Visitor();
        TempVisitor tempVisitor = new TempVisitor();
        String month;
        Date dateC = new Date();
        String day;
        String today = dateC.getYear() + "";
        if (dateC.getMonth() < 10) 
            month = "0" + (dateC.getMonth() + 1);
        else
            month = "" + dateC.getMonth() + 1;
        if (dateC.getDate() < 10) 
            day = "0" + dateC.getDate();
        else
            day = "" + dateC.getDate();
        today = month + "/" + day + "/20" + today.substring(1,3);
        Iterator iterator = tempVisitorService.getTempVisitorIsNotHere().iterator();
        while (iterator.hasNext()) {
        	TempVisitor tV = (TempVisitor) iterator.next();
        	if (tV.getDateTo() == null) {}
        	else {
        		
	        	String dateToMonth = tV.getDateTo().substring(3, 5);
	    		String dateToDay = tV.getDateTo().substring(0, 2);
	    		String dateToYear =tV.getDateTo().substring(6, 10);
	    		
	    		if (Integer.parseInt(dateToYear) >= Integer.parseInt(today.substring(6, 10)))
	    			if (Integer.parseInt(dateToMonth) >= Integer.parseInt(month))
	    				if (Integer.parseInt(dateToDay) >= Integer.parseInt(day)) {}
	    				else {
	    					tV.setStatus("CLOSE");
	    					tV.setIsHere("вы");;
        		            tempVisitorService.edit(tV);
        		            tempVisitorService.deleteFromView();
        				}
        			else {
        				tV.setStatus("CLOSE");
    					tV.setIsHere("вы");;
    		            tempVisitorService.edit(tV);
    		            tempVisitorService.deleteFromView();
        			}
        		else {
        			tV.setStatus("CLOSE");
					tV.setIsHere("вы");;
		            tempVisitorService.edit(tV);
		            tempVisitorService.deleteFromView();
        		}
        	}
        }	
        map.put("permanentVisitor", permanentVisitor);
        map.put("permanentVisitorList2", visitorService.getVisitors());
        map.put("tempVisitor", tempVisitor);
        map.put("tempVisitorList2", tempVisitorService.getTempVisitors());
     
        map.put("today", today);
        map.put("accountList", accountService.getAccounts());
        return "permanentVisitor";
    }
     
    
    @RequestMapping(value="/VisitorAction", method=RequestMethod.POST)
    public String doActions(@ModelAttribute Account account, @ModelAttribute Visitor visitor, @RequestParam("search") String search,
            @RequestParam String action, Map<String, Object> map) {
         
        String month;
        Date dateC = new Date();
        String day;
        String today = dateC.getYear() + "";
        if (dateC.getMonth() < 10) 
            month = "0" + (dateC.getMonth() + 1);
        else
            month = "" + dateC.getMonth() + 1;
        if (dateC.getDate() < 10) 
            day = "0" + dateC.getDate();
        else
            day = "" + dateC.getDate();
        today = month + "/" + day + "/20" + today.substring(1,3);
        map.put("today", today);
        search = search.toLowerCase();
        
        if (action.toLowerCase().equals("найти")) {
            visitorList.clear();
            if (search.equals("")) return "permanentVisitor";
            else if (search.matches("[0-9]*")) {
            	System.out.println(search);
                searchExist = search;
                visitorList.addAll(visitorService.getVisitorByAccountPart(search.toLowerCase()));
                map.put("permanentVisitorList", visitorService.getVisitorByAccountPart(search.toLowerCase()));
                return "permanentVisitor";
            }
            else if (search.matches("[а-я]*")){
                visitorList.clear();
                search = search.toLowerCase();
                visitorList.addAll(visitorService.getVisitorByNamePart(search.toLowerCase()));
                searchExist = search.toLowerCase();
                map.put("permanentVisitorList", visitorService.getVisitorByNamePart(search.toLowerCase()));
                return "permanentVisitor";
            }
            else  {
                searchExist = search;
                System.out.println(search);
                visitorList.addAll(visitorService.getVisitorByAccountPart(search.toLowerCase()));
                visitorList.addAll(visitorService.getVisitorByNamePart(search.toLowerCase()));
                
                map.put("permanentVisitorList", visitorService.getVisitorByAccountPart(search.toLowerCase()));
                return "permanentVisitor";
            }
             
        }
        else if (action.toLowerCase().contains("show")) {
            Visitor permVisitor = visitorService.get(Integer.parseInt(action.substring(0, action.toString().indexOf("."))));
            id = permVisitor.getVisitorId();
            String name = permVisitor.getName().substring(0, permVisitor.getName().indexOf(" ")) + 
                    permVisitor.getName().substring(permVisitor.getName().indexOf(" "), permVisitor.getName().indexOf(" ") + 2) + ".";
            map.put("accVisitor", permVisitor.getAccount());
            map.put("today", today);
            map.put("nameVisitor", name);
            map.put("permanentVisitorList", visitorList);
            List temp = visitorService.getVisitorByAccountAndName(permVisitor.getAccount(), permVisitor.getName());
            System.out.println(temp.size());
            if (temp.size() != 0) map.put("carList", temp);
            else {
                map.put("accVisitor", permVisitor.getAccount());
                map.put("today", today);
                map.put("nameVisitor", name);
                map.put("permanentVisitorList", visitorList);
                return "noCars";
            }
            return "getCars";
        }
        else if (action.toLowerCase().contains("edit")) {
        	Visitor permVisitor = visitorService.get(Integer.parseInt(action.substring(0, action.toString().indexOf("."))));
        	map.put("accList", accountService.getAccounts());
        	map.put("editVisitor", permVisitor);
        	return "edit";
        }
        else if (action.toLowerCase().equals("добавить нового жильца")) {
            map.put("accList", accountService.getAccounts());
            map.put("today", today);
            return "addPermanent";
        }
        else if (action.toLowerCase().equals("добавить постоянный пропуск")) {
            Visitor permVisitor = visitorService.get(id);
            String name = permVisitor.getName().substring(0, permVisitor.getName().indexOf(" ")) + 
                    permVisitor.getName().substring(permVisitor.getName().indexOf(" "), permVisitor.getName().indexOf(" ") + 2) + ".";
            map.put("accVisitor", permVisitor.getAccount());
            map.put("today", today);
            map.put("nameVisitor", name);
            return "addCars";
        }
        else if (action.toLowerCase().contains("-")) {
            idDeleted = Integer.parseInt(action.substring(0, action.toString().indexOf(".")));
            map.put("permanentVisitorList", visitorList);
            return "delete";
        }
        else if (action.toLowerCase().equals("да")) {
            visitorService.delete(visitorService.get(idDeleted).getAccount(), visitorService.get(idDeleted).getName());
            visitorList.clear();
            if (searchExist.matches("[0-9]*")) {
                visitorList.addAll(visitorService.getVisitorByAccountPart(searchExist.toLowerCase()));
                map.put("permanentVisitorList", visitorService.getVisitorByAccountPart(searchExist.toLowerCase()));
                return "permanentVisitor";
            }
            else if (searchExist.matches("[0-9]*[а-я]*")) {
                visitorList.addAll(visitorService.getVisitorByAccountPart(searchExist));
                map.put("permanentVisitorList", visitorService.getVisitorByAccountPart(searchExist.toLowerCase()));
                return "permanentVisitor";
            }
            else {
                visitorList.clear();
                visitorList.addAll(visitorService.getVisitorByNamePart(searchExist.toLowerCase()));
                map.put("permanentVisitorList", visitorService.getVisitorByNamePart(searchExist.toLowerCase()));
                return "permanentVisitor";
            }
        }
        else if (action.toLowerCase().equals("нет")) {
            map.put("permanentVisitorList", visitorList);
            return "permanentVisitor";
        }
        else if (action.toLowerCase().equals("автомобили на территории")) {
            map.put("tempVisitorList", tempVisitorService.getTempVisitorIsHere());
            return "carIn";
        }
        else if (action.toLowerCase().equals("добавить пропуск")) {
            return "tempAdmin";
        }
        else if (action.toLowerCase().equals("заказанные пропуска")) {
        	map.put("tempVisitorList", tempVisitorService.getTempVisitorIsNotHere());
        	return "tempVisitors";
        }
        else if (action.toLowerCase().contains("удалить")) {
            Visitor visitorCar = visitorService.get(Integer.parseInt(action.substring(0, action.toString().indexOf("."))));
            System.out.println(visitorCar.getCarNumber());
            visitorCar.setDeletedStatus("deleted");
            visitorService.edit(visitorCar);
            Visitor permVisitor = visitorService.get(id);
            String name = permVisitor.getName().substring(0, permVisitor.getName().indexOf(" ")) + 
                    permVisitor.getName().substring(permVisitor.getName().indexOf(" "), permVisitor.getName().indexOf(" ") + 2) + ".";
            map.put("accVisitor", permVisitor.getAccount());
            map.put("permanentVisitorList", visitorList);
            List temp = visitorService.getVisitorByAccountAndName(permVisitor.getAccount(), permVisitor.getName());
            System.out.println(temp.size());
            map.put("carList", temp);
            map.put("today", today);
            map.put("nameVisitor", name);
            return "getCars";
        }
        return "permanentVisitor";
    }
     
    @RequestMapping(value="/DeleteTemp", method=RequestMethod.POST)
    public String doDelete(@ModelAttribute Visitor visitor, @RequestParam String action, Map<String, Object> map) {
        TempVisitor tempVis = tempVisitorService.get(Integer.parseInt(action.substring(0, action.toString().indexOf("."))));
        tempVis.setStatus("CLOSE");
        tempVisitorService.delete(Integer.parseInt(action.substring(0, action.toString().indexOf("."))));
        map.put("tempVisitorList", tempVisitorService.getTempVisitorIsNotHere());
    	return "tempVisitors";
    }
    
    @RequestMapping(value="/EditPermanent", method=RequestMethod.POST)
    public String doEditCarActions(@ModelAttribute Visitor visitor, @RequestParam("id") String visId, @RequestParam("select") String selectAccount, @RequestParam("phoneNumber") String phoneNumber, 
            @RequestParam("name") String name, @RequestParam("address") String address, @RequestParam String action, Map<String, Object> map,
            @RequestParam("phoneNumber2") String phoneNumber2, @RequestParam("phoneNumber3") String phoneNumber3) {
    	Visitor permVisitor = visitorService.get(Integer.parseInt(visId));
    	List editList = visitorService.getVisitorByAccountAndName(permVisitor.getAccount(), permVisitor.getName());
    	Iterator iterator = editList.iterator();
    	for (int i = 0; i < editList.size(); i++) {
    		((Visitor) editList.get(i)).setAccount(selectAccount);
    		((Visitor) editList.get(i)).setName(name);
    		((Visitor) editList.get(i)).setAddress(address);
    		((Visitor) editList.get(i)).setPhoneNumber(phoneNumber);
    		((Visitor) editList.get(i)).setPhoneNumber2(phoneNumber2);
    		((Visitor) editList.get(i)).setPhoneNumber3(phoneNumber3);
    		visitorService.edit(((Visitor) editList.get(i)));
    	}
    	permVisitor.setAccount(selectAccount);
    	permVisitor.setAddress(address);
    	permVisitor.setPhoneNumber2(phoneNumber2);
    	permVisitor.setPhoneNumber3(phoneNumber3); 
    	permVisitor.setName(name);
    	permVisitor.setPhoneNumber(phoneNumber);
    	
    	visitorService.edit(permVisitor);
    	return "permanentVisitor";
    }
    
    @RequestMapping(value="/AddCar", method=RequestMethod.POST)
    public String doAddCarActions(@ModelAttribute Visitor visitor, @RequestParam("date") String date, @RequestParam("number2") String number2,
            @RequestParam("number") String number, @RequestParam("brand") String brand, @RequestParam("number3") String number3,
            @RequestParam("number4") String number4, @RequestParam String action, @RequestParam("color") String color, Map<String, Object> map) {
        String month;
        Date dateC = new Date();
        String day;
        String today = dateC.getYear() + "";
        if (dateC.getMonth() < 10) 
            month = "0" + (dateC.getMonth() + 1);
        else
            month = "" + dateC.getMonth() + 1;
        if (dateC.getDate() < 10) 
            day = "0" + dateC.getDate();
        else
            day = "" + dateC.getDate();
        today = month + "/" + day + "/20" + today.substring(1,3);
        map.put("today", today);
         
        if (action.toLowerCase().equals("+")) {
            map.put("today", today);
            if (number.equals("") || number2.equals("") || number3.equals("") || brand.equals("") || color.equals("")) {
                Visitor permVisitor = visitorService.get(id);
                String name = permVisitor.getName().substring(0, permVisitor.getName().indexOf(" ")) + 
                        permVisitor.getName().substring(permVisitor.getName().indexOf(" "), permVisitor.getName().indexOf(" ") + 2) + ".";
                map.put("accVisitor", permVisitor.getAccount());
                map.put("today", today);
                map.put("nameVisitor", name);
                return "addCars";
            }
            else {
                Visitor permVisitor = visitorService.get(id);
                String name = permVisitor.getName().substring(0, permVisitor.getName().indexOf(" ")) + 
                        permVisitor.getName().substring(permVisitor.getName().indexOf(" "), permVisitor.getName().indexOf(" ") + 2) + ".";
                map.put("accVisitor", permVisitor.getAccount());
                map.put("today", today);
                map.put("nameVisitor", name);
                 
                visitor.setAccount(permVisitor.getAccount());
                visitor.setName(permVisitor.getName());
                visitor.setPhoneNumber(permVisitor.getPhoneNumber());
                visitor.setPhoneNumber2(permVisitor.getPhoneNumber2());
                visitor.setPhoneNumber3(permVisitor.getPhoneNumber3());
                visitor.setAddress(permVisitor.getAddress());
                visitor.setBrand(brand);
                visitor.setColor(color);
                //System.out.println(date.substring(3, 5) + "/" + date.substring(0, 2) + "/" + date.substring(6, 10));
                visitor.setDate(date.substring(3, 5) + "/" + date.substring(0, 2) + "/" + date.substring(6, 10));
                visitor.setCarNumber(number + " " + number2 + " " + number3 + " " + number4);
                visitor.setNumber(number2);
                visitorService.add(visitor);
            }
        }
        return "addCars";
    }
     
    @RequestMapping(value="/AddPermanent", method=RequestMethod.POST)
    public String doAddAction(@ModelAttribute Account account, @ModelAttribute Visitor visitor, @RequestParam("date") String date, @RequestParam("phoneNumber3") String phoneNumber3,
            @RequestParam("select") String selectAccount, @RequestParam("phoneNumber") String phoneNumber, @RequestParam("phoneNumber2") String phoneNumber2,
            @RequestParam("name") String name, @RequestParam("address") String address, @RequestParam String action, Map<String, Object> map) {
        String month;
        map.put("accList", accountService.getAccounts());
        Date dateC = new Date();
        String day;
        String today = dateC.getYear() + "";
        if (dateC.getMonth() < 10) 
            month = "0" + (dateC.getMonth() + 1);
        else
            month = "" + dateC.getMonth() + 1;
        if (dateC.getDate() < 10) 
            day = "0" + dateC.getDate();
        else
            day = "" + dateC.getDate();
        today = month + "/" + day + "/20" + today.substring(1,3);
        System.out.println(today);
        map.put("today", today);
         
        if (action.toLowerCase().equals("+")) {
            if (selectAccount.equals("") ||  name.equals("") || phoneNumber.equals("") || address.equals("") || visitor.getDate().equals("")) {
                System.out.println(today);
                map.put("today", today);
                return "addPermanent";
            }
            else {
                visitor.setName(name);
                visitor.setAccount(selectAccount);
                visitor.setAddress(address);
                visitor.setDate(date.substring(3, 5) + "/" + date.substring(0, 2) + "/" + date.substring(6, 10)); 
                System.out.println(date);
                visitor.setPhoneNumber(phoneNumber.substring(0, 1) +
                        " " + "(" + phoneNumber.substring(1, 4) + ")" + " " + phoneNumber.substring(4, 7) + " " + 
                        phoneNumber.substring(7, 9) + " " + phoneNumber.substring(9, 11));
                if (phoneNumber2.equals("")) {}
                else 
                	visitor.setPhoneNumber2(phoneNumber2.substring(0, 1) +
                        " " + "(" + phoneNumber2.substring(1, 4) + ")" + " " + phoneNumber2.substring(4, 7) + " " + 
                        phoneNumber2.substring(7, 9) + " " + phoneNumber2.substring(9, 11));
                if (phoneNumber3.equals("")) {}
                else
                	visitor.setPhoneNumber3(phoneNumber3.substring(0, 1) +
	                        " " + "(" + phoneNumber3.substring(1, 4) + ")" + " " + phoneNumber3.substring(4, 7) + " " + 
	                        phoneNumber3.substring(7, 9) + " " + phoneNumber3.substring(9, 11));
                visitorService.add(visitor);
            }
        }
        return "addPermanent";
    }
         
    @RequestMapping(value="/AccountAdd", method=RequestMethod.POST)
    public String AddAction(@ModelAttribute Account account, @RequestParam String action, @RequestParam("account") String accountNumber, @RequestParam("id") String accountId, Map<String, Object> map) {
        switch(action.toLowerCase()) {
            case "добавить л/с":
                if (accountNumber.equals("") || accountNumber.length() > 10) {
                    map.put("accountList", accountService.getAccounts());
                } else {
                    account.setAccount(accountNumber);
                    accountService.add(account);
                }
                break;
                 
            case "редактировать":
                if (accountNumber.equals("") || accountNumber.length() > 10 || accountId.equals("")) {
                    map.put("accountList", accountService.getAccounts());
                } else {
                    account.setAccountId(Integer.parseInt(accountId));
                    account.setAccount(accountNumber); 
                    accountService.edit(account); 
                }
                break;
            case "удалить":
                if (accountId.equals("")) {
                    map.put("accountList", accountService.getAccounts());
                } else { 
                    if (accountService.get(Integer.parseInt(accountId)) != null)
                        accountService.delete(Integer.parseInt(accountId)); 
                }
                break;
        }
        map.put("accountList", accountService.getAccounts());
        return "permanentVisitor";
    }
     
    @RequestMapping(value="/VisitorGetAdmin", method=RequestMethod.POST)
    public String doActionGetAdmin(@ModelAttribute Visitor visitor, @RequestParam String action, @RequestParam("search") String search, Map<String, Object> map) {
        Visitor permanentVisitor = new Visitor();
        Visitor account = new Visitor();
         
        String month;
        Date dateC = new Date();
        String day;
        String today = dateC.getYear() + "";
        if (dateC.getMonth() < 10) 
            month = "0" + (dateC.getMonth() + 1);
        else
            month = "" + dateC.getMonth() + 1;
        if (dateC.getDate() < 10) 
            day = "0" + dateC.getDate();
        else
            day = "" + dateC.getDate();
        today = month + "/" + day + "/20" + today.substring(1,3);
        Iterator iterator = tempVisitorService.getTempVisitorIsNotHere().iterator();
        while (iterator.hasNext()) {
        	TempVisitor tV = (TempVisitor) iterator.next();
        	if (tV.getDateTo() == null) {}
        	else {
        		
	        	String dateToMonth = tV.getDateTo().substring(3, 5);
	    		String dateToDay = tV.getDateTo().substring(0, 2);
	    		String dateToYear =tV.getDateTo().substring(6, 10);
	    		
	    		if (Integer.parseInt(dateToYear) >= Integer.parseInt(today.substring(6, 10)))
	    			if (Integer.parseInt(dateToMonth) >= Integer.parseInt(month))
	    				if (Integer.parseInt(dateToDay) >= Integer.parseInt(day)) {}
	    				else {
	    					tV.setStatus("CLOSE");
	    					tV.setIsHere("вы");;
        		            tempVisitorService.edit(tV);
        		            tempVisitorService.deleteFromView();
        				}
        			else {
        				tV.setStatus("CLOSE");
    					tV.setIsHere("вы");;
    		            tempVisitorService.edit(tV);
    		            tempVisitorService.deleteFromView();
        			}
        		else {
        			tV.setStatus("CLOSE");
					tV.setIsHere("вы");;
		            tempVisitorService.edit(tV);
		            tempVisitorService.deleteFromView();
        		}
        	}
        }	
        map.put("today", today);
        search = search.toLowerCase();
        if (action.toLowerCase().contains("+v")) {
            Visitor permVisitor = visitorService.get(Integer.parseInt(action.substring(0, action.toString().indexOf("."))));
            String name = permVisitor.getName().substring(0, permVisitor.getName().indexOf(" ")) + 
                    permVisitor.getName().substring(permVisitor.getName().indexOf(" "), permVisitor.getName().indexOf(" ") + 2) + ".";
            map.put("accVisitor", permVisitor.getAccount());
            map.put("today", today);
            map.put("nameVisitor", name);
            visitorResultForTemp = permVisitor;
            return "addTemp";
        } else if (action.toLowerCase().contains("+t")) {
            TempVisitor permVisitor = tempVisitorService.get(Integer.parseInt(action.substring(0, action.toString().indexOf("."))));
             
            String name = permVisitor.getName().substring(0, permVisitor.getName().indexOf(" ")) + 
                    permVisitor.getName().substring(permVisitor.getName().indexOf(" "), permVisitor.getName().indexOf(" ") + 2) + ".";
            map.put("accVisitor", permVisitor.getAccount());
            map.put("nameVisitor", name);
            map.put("today", today);
            System.out.println(permVisitor.getName());
            List list = visitorService.getVisitorByAccount(permVisitor.getAccount());
            for (int i = 0; i < list.size(); i++)
                if (((Visitor) list.get(i)).getName().equals(permVisitor.getName()))
                    visitorResultForTemp = (Visitor) list.get(i);
            System.out.println(visitorResultForTemp.getAccount() + visitorResultForTemp.getName());
            return "addTemp";
        }
         
        if (action.toLowerCase().equals("найти")) { 
            if (search.equals("")) 
                return "permanentVisitor";
            else if (search.matches("[0-9]*")) {
             
                map.put("permanentVisitor", permanentVisitor);
                map.put("accountList", accountService.getAccounts());
 
                List list = visitorService.getVisitorByAccountPart(search);
                list.addAll(visitorService.getVisitorByPhoneNumberPart(search));
                 
                List listTemp = tempVisitorService.getTempVisitorByAccountPart(search);
                listTemp.addAll(tempVisitorService.getTempVisitorByPhoneNumberPart(search));
                 
                map.put("permanentVisitorList", list);
                map.put("today", today);
                map.put("tempVisitorList", listTemp);
                return "tempAdmin";
            }
            else if (search.matches("[а-я]*")) {
                System.out.println("sdfdsfsd");
                List list = visitorService.getVisitorByNamePart(search.toLowerCase());
                List listTemp = tempVisitorService.getTempVisitorByNamePart(search.toLowerCase());
                 
                map.put("permanentVisitorList", list);
                map.put("today", today);
                map.put("tempVisitorList", listTemp);
                return "tempAdmin";
            }
            else {
                map.put("permanentVisitor", permanentVisitor);
                map.put("accountList", accountService.getAccounts());
 
                List list = visitorService.getVisitorByAccountPart(search);
                 
                List listTemp = tempVisitorService.getTempVisitorByAccountPart(search);
                 
                map.put("permanentVisitorList", list);
                map.put("today", today);
                map.put("tempVisitorList", listTemp);
                return "tempAdmin";
            }
        }
        else if (action.toLowerCase().equals("заказанные пропуска")) {
        	map.put("tempVisitorList", tempVisitorService.getTempVisitorIsNotHere());
        	return "tempVisitors";
        }
        else if (action.toLowerCase().equals("закрыть")) {
            return "permanentVisitor";
        }
        else
            return "tempAdmin";
    }
     
    @RequestMapping(value="/VisitorGet", method=RequestMethod.POST)
    public String doActionGet(@ModelAttribute Visitor visitor, @RequestParam String action, @RequestParam("search") String search, Map<String, Object> map) {
        Visitor permanentVisitor = new Visitor();
        Visitor account = new Visitor();
         
        String month;
        Date dateC = new Date();
        String day;
        String today = dateC.getYear() + "";
        if (dateC.getMonth() < 10) 
            month = "0" + (dateC.getMonth() + 1);
        else
            month = "" + dateC.getMonth() + 1;
        if (dateC.getDate() < 10) 
            day = "0" + dateC.getDate();
        else
            day = "" + dateC.getDate();
        today = month + "/" + day + "/20" + today.substring(1,3);
        Iterator iterator = tempVisitorService.getTempVisitorIsNotHere().iterator();
        while (iterator.hasNext()) {
        	TempVisitor tV = (TempVisitor) iterator.next();
        	if (tV.getDateTo() == null) {}
        	else {
        		
	        	String dateToMonth = tV.getDateTo().substring(3, 5);
	    		String dateToDay = tV.getDateTo().substring(0, 2);
	    		String dateToYear =tV.getDateTo().substring(6, 10);
	    		
	    		if (Integer.parseInt(dateToYear) >= Integer.parseInt(today.substring(6, 10)))
	    			if (Integer.parseInt(dateToMonth) >= Integer.parseInt(month))
	    				if (Integer.parseInt(dateToDay) >= Integer.parseInt(day)) {}
	    				else {
	    					tV.setStatus("CLOSE");
	    					tV.setIsHere("вы");;
        		            tempVisitorService.edit(tV);
        		            tempVisitorService.deleteFromView();
        				}
        			else {
        				tV.setStatus("CLOSE");
    					tV.setIsHere("вы");;
    		            tempVisitorService.edit(tV);
    		            tempVisitorService.deleteFromView();
        			}
        		else {
        			tV.setStatus("CLOSE");
					tV.setIsHere("вы");;
		            tempVisitorService.edit(tV);
		            tempVisitorService.deleteFromView();
        		}
        	}
        }	
        map.put("today", today);
        search = search.toLowerCase();
        if (action.toLowerCase().contains("+v")) {
            Visitor permVisitor = visitorService.get(Integer.parseInt(action.substring(0, action.toString().indexOf("."))));
            String name = permVisitor.getName().substring(0, permVisitor.getName().indexOf(" ")) + 
                    permVisitor.getName().substring(permVisitor.getName().indexOf(" "), permVisitor.getName().indexOf(" ") + 2) + ".";
            map.put("accVisitor", permVisitor.getAccount());
            map.put("today", today);
            map.put("nameVisitor", name);
            visitorResultForTemp = permVisitor;
            return "addTemp";
        } else if (action.toLowerCase().contains("+t")) {
            TempVisitor permVisitor = tempVisitorService.get(Integer.parseInt(action.substring(0, action.toString().indexOf("."))));
             
            String name = permVisitor.getName().substring(0, permVisitor.getName().indexOf(" ")) + 
                    permVisitor.getName().substring(permVisitor.getName().indexOf(" "), permVisitor.getName().indexOf(" ") + 2) + ".";
            map.put("accVisitor", permVisitor.getAccount());
            map.put("nameVisitor", name);
            map.put("today", today);
            System.out.println(permVisitor.getName());
            List list = visitorService.getVisitorByAccount(permVisitor.getAccount());
            for (int i = 0; i < list.size(); i++)
                if (((Visitor) list.get(i)).getName().equals(permVisitor.getName()))
                    visitorResultForTemp = (Visitor) list.get(i);
            System.out.println(visitorResultForTemp.getAccount() + visitorResultForTemp.getName());
            return "addTemp";
        }
         
        if (action.toLowerCase().equals("найти")) { 
            if (search.equals("")) 
                return "permanentVisitor";
            else if (search.matches("[а-я]*")) {
                List list = visitorService.getVisitorByNamePart(search.toLowerCase());
                List listTemp = tempVisitorService.getTempVisitorByNamePart(search.toLowerCase());
                 
                map.put("permanentVisitorList", list);
                map.put("today", today);
                map.put("tempVisitorList", listTemp);
                return "permanentVisitor";
            }
            else if (search.matches("[0-9]*")) {
                map.put("permanentVisitor", permanentVisitor);
                map.put("accountList", accountService.getAccounts());
 
                List list = visitorService.getVisitorByAccountPart(search);
                list.addAll(visitorService.getVisitorByPhoneNumberPart(search));
                 
                List listTemp = tempVisitorService.getTempVisitorByAccountPart(search);
                listTemp.addAll(tempVisitorService.getTempVisitorByPhoneNumberPart(search));
                List list2 = list;
                                 
                map.put("permanentVisitorList", list);
                map.put("today", today);
                map.put("tempVisitorList", listTemp);
                return "permanentVisitor";
            }
            else {
                map.put("permanentVisitor", permanentVisitor);
                map.put("accountList", accountService.getAccounts());
 
                List list = visitorService.getVisitorByAccountPart(search);
                 
                List listTemp = tempVisitorService.getTempVisitorByAccountPart(search);
                 
                map.put("permanentVisitorList", list);
                map.put("today", today);
                map.put("tempVisitorList", listTemp);
                return "permanentVisitor";
            }
        }
        else if (action.toLowerCase().equals("заказанные пропуска")) {
        	map.put("tempVisitorList", tempVisitorService.getTempVisitorIsNotHere());
        	return "tempVisitors";
        }
        else if (action.toLowerCase().equals("закрыть")) {
            return "permanentVisitor";
        }
        else
            return "permanentVisitor";
    }
     
    @RequestMapping(value="/AddTemp", method=RequestMethod.POST)
    public String ActionAddTemp(@ModelAttribute TempVisitor tempVisitor, @ModelAttribute Visitor visitor, @RequestParam("number4") String number4,
            @RequestParam("date") String date, @RequestParam("number") String number, @RequestParam("number2") String number2, @RequestParam("aim") String aim, 
                @RequestParam String action, @RequestParam("number3") String number3, @RequestParam("brand") String brand, Map<String, Object> map) {
        String month;
        Date dateC = new Date();
        String day;
        String today = dateC.getYear() + "";
        if (dateC.getMonth() < 10) 
            month = "0" + (dateC.getMonth() + 1);
        else
            month = "" + dateC.getMonth() + 1;
        if (dateC.getDate() < 10) 
            day = "0" + dateC.getDate();
        else
            day = "" + dateC.getDate();
        today = month + "/" + day + "/20" + today.substring(1,3);
         
        map.put("today", today);
        if (action.toLowerCase().equals("+")) {
            map.put("today", today);
            if (number.equals("") || number2.equals("") || number3.equals("") || brand.equals("")) {
                String name = visitorResultForTemp.getName().substring(0, visitorResultForTemp.getName().indexOf(" ")) + 
                        visitorResultForTemp.getName().substring(visitorResultForTemp.getName().indexOf(" "), 
                                visitorResultForTemp.getName().indexOf(" ") + 2) + ".";
                map.put("accVisitor", visitorResultForTemp.getAccount());
                map.put("today", today);
                map.put("nameVisitor", name);
                return "addTemp";
            }
            else {
                TempVisitor tempVisitorResult = new TempVisitor();
                System.out.println(visitorResultForTemp.getName());
                tempVisitor.setAccount(visitorResultForTemp.getAccount());
                tempVisitor.setName(visitorResultForTemp.getName());
                tempVisitor.setPhoneNumber(visitorResultForTemp.getPhoneNumber());
                tempVisitor.setPhoneNumber2(visitorResultForTemp.getPhoneNumber2());
                tempVisitor.setPhoneNumber3(visitorResultForTemp.getPhoneNumber3());
                tempVisitor.setAddress(visitorResultForTemp.getAddress());
                tempVisitor.setDate(date.substring(3, 5) + "/" + date.substring(0, 2) + "/" + date.substring(6, 10));
                tempVisitor.setBrand(brand);
                tempVisitor.setNumber(number2);
                tempVisitor.setCarNumber(number + " " + number2 + " " + number3 + " " + number4);    
                tempVisitor.setAim(aim);
                tempVisitor.setNameInf(visitorResultForTemp.getName().substring(visitorResultForTemp.getName().indexOf(" ")));
                tempVisitor.setStatus("Запустить");
                tempVisitorService.add(tempVisitor); 
                tempVisitorResult = tempVisitor;
            }
            String name = visitorResultForTemp.getName().substring(0, visitorResultForTemp.getName().indexOf(" ")) + 
                    visitorResultForTemp.getName().substring(visitorResultForTemp.getName().indexOf(" "), 
                            visitorResultForTemp.getName().indexOf(" ") + 2) + ".";
            map.put("accVisitor", visitorResultForTemp.getAccount());
            map.put("today", today);
            map.put("nameVisitor", name);
        }
        else if (action.toLowerCase().equals("разовый пропуск")) {
        	String name = visitorResultForTemp.getName().substring(0, visitorResultForTemp.getName().indexOf(" ")) + 
                    visitorResultForTemp.getName().substring(visitorResultForTemp.getName().indexOf(" "), 
                            visitorResultForTemp.getName().indexOf(" ") + 2) + ".";
        	map.put("accVisitor", visitorResultForTemp.getAccount());
            map.put("today", today);
            map.put("nameVisitor", name);
        	return "addTemp";
        }
        else if (action.toLowerCase().equals("временный пропуск")) {
        	String name = visitorResultForTemp.getName().substring(0, visitorResultForTemp.getName().indexOf(" ")) + 
                    visitorResultForTemp.getName().substring(visitorResultForTemp.getName().indexOf(" "), 
                            visitorResultForTemp.getName().indexOf(" ") + 2) + ".";
        	map.put("accVisitor", visitorResultForTemp.getAccount());
            map.put("today", today);
            map.put("nameVisitor", name);
        	return "addTempTime";
        }
            return "addTemp";
    }
     
    @RequestMapping(value="/AddTempTime", method=RequestMethod.POST)
    public String ActionAddTempTime(@ModelAttribute TempVisitor tempVisitor, @ModelAttribute Visitor visitor, @RequestParam("number4") String number4,
            @RequestParam("date") String date, @RequestParam("number") String number, @RequestParam("number2") String number2, @RequestParam("aim") String aim, 
            @RequestParam String action, @RequestParam("number3") String number3, @RequestParam("dateTo") String dateTo, 
            @RequestParam("brand") String brand, Map<String, Object> map) {
        String month;
        Date dateC = new Date();
        String day;
        String today = dateC.getYear() + "";
        if (dateC.getMonth() < 10) 
            month = "0" + (dateC.getMonth() + 1);
        else
            month = "" + dateC.getMonth() + 1;
        if (dateC.getDate() < 10) 
            day = "0" + dateC.getDate();
        else
            day = "" + dateC.getDate();
        today = month + "/" + day + "/20" + today.substring(1,3);
         
        map.put("today", today);
        if (action.toLowerCase().equals("+")) {
            map.put("today", today);
            if (number.equals("") || number2.equals("") || number3.equals("") || brand.equals("")) {
                String name = visitorResultForTemp.getName().substring(0, visitorResultForTemp.getName().indexOf(" ")) + 
                        visitorResultForTemp.getName().substring(visitorResultForTemp.getName().indexOf(" "), 
                                visitorResultForTemp.getName().indexOf(" ") + 2) + ".";
                map.put("accVisitor", visitorResultForTemp.getAccount());
                map.put("today", today);
                map.put("nameVisitor", name);
                return "addTempTime";
            }
            else {
                TempVisitor tempVisitorResult = new TempVisitor();
                System.out.println(visitorResultForTemp.getName());
                tempVisitor.setAccount(visitorResultForTemp.getAccount());
                tempVisitor.setName(visitorResultForTemp.getName());
                tempVisitor.setPhoneNumber(visitorResultForTemp.getPhoneNumber());
                tempVisitor.setPhoneNumber2(visitorResultForTemp.getPhoneNumber2());
                tempVisitor.setPhoneNumber3(visitorResultForTemp.getPhoneNumber3());
                tempVisitor.setAddress(visitorResultForTemp.getAddress());
                tempVisitor.setDate(date.substring(3, 5) + "/" + date.substring(0, 2) + "/" + date.substring(6, 10));
                tempVisitor.setDateTo(dateTo.substring(3, 5) + "/" + dateTo.substring(0, 2) + "/" + dateTo.substring(6, 10));
                tempVisitor.setBrand(brand);
                tempVisitor.setNumber(number2);
                tempVisitor.setCarNumber(number + " " + number2 + " " + number3 + " " + number4);  
                tempVisitor.setAim(aim);
                tempVisitor.setNameInf(visitorResultForTemp.getName().substring(visitorResultForTemp.getName().indexOf(" ")));
                tempVisitor.setStatus("Запустить");
                tempVisitorService.add(tempVisitor); 
                tempVisitorResult = tempVisitor;
            }
            String name = visitorResultForTemp.getName().substring(0, visitorResultForTemp.getName().indexOf(" ")) + 
                    visitorResultForTemp.getName().substring(visitorResultForTemp.getName().indexOf(" "), 
                            visitorResultForTemp.getName().indexOf(" ") + 2) + ".";
            map.put("accVisitor", visitorResultForTemp.getAccount());
            map.put("today", today);
            map.put("nameVisitor", name);
            return "addTempTime";
        }
        else if (action.toLowerCase().equals("разовый пропуск")) {
        	String name = visitorResultForTemp.getName().substring(0, visitorResultForTemp.getName().indexOf(" ")) + 
                    visitorResultForTemp.getName().substring(visitorResultForTemp.getName().indexOf(" "), 
                            visitorResultForTemp.getName().indexOf(" ") + 2) + ".";
        	map.put("accVisitor", visitorResultForTemp.getAccount());
            map.put("today", today);
            map.put("nameVisitor", name);
        	return "addTemp";
        }
        else if (action.toLowerCase().equals("временный пропуск")) {
        	String name = visitorResultForTemp.getName().substring(0, visitorResultForTemp.getName().indexOf(" ")) + 
                    visitorResultForTemp.getName().substring(visitorResultForTemp.getName().indexOf(" "), 
                            visitorResultForTemp.getName().indexOf(" ") + 2) + ".";
        	map.put("accVisitor", visitorResultForTemp.getAccount());
            map.put("today", today);
            map.put("nameVisitor", name);
        	return "addTempTime";
        }
            return "addTempTime";
    }
    
    @RequestMapping(value="/BackToPermanent", method=RequestMethod.POST)
    public String ActionBackToPerm(@ModelAttribute TempVisitor tempVisitor, @ModelAttribute Visitor visitor, 
                @RequestParam String action, Map<String, Object> map) {
    	map.put("permanentVisitor", visitor);
        map.put("permanentVisitorList", visitorService.getVisitors());
        map.put("accountList", accountService.getAccounts());
         
        return "getPermanentVisitor";
    }
     
    @RequestMapping(value="/BackToAdd", method=RequestMethod.POST)
    public String ActionBackToAdd(@ModelAttribute TempVisitor tempVisitor, @ModelAttribute Visitor visitor, 
                @RequestParam String action, Map<String, Object> map) {
        return "permanentVisitor";
    }
     
    @RequestMapping(value="/ShowData", method=RequestMethod.POST)
    public String ActionShowData(@ModelAttribute("tempVisitor") TempVisitor tempVisitor, @RequestParam String action, @RequestParam("numb") String numb, Map<String, Object> map) {
     
        Visitor permanentVisitor = new Visitor();
        if (action.toLowerCase().equals("найти")) {
            if (numb.equals(""))
                return "permanentVisitor";
            else if (numb.matches("[0-9]*")) {
                if (tempVisitorService.getTempVisitorByNumber(numb).size() == 0 && visitorService.getVisitorByNumber(numb).size() == 0) 
                    return "permanentVisitor";
                else if (visitorService.getVisitorByNumber(numb).size() != 0 && tempVisitorService.getTempVisitorByNumber(numb).size() == 0) {
                    map.put("permanentVisitor", permanentVisitor);
                    map.put("permanentVisitorList", visitorService.getVisitorByNumber(numb));
                    return "onlyPerm";
                }
                else if (tempVisitorService.getTempVisitorByNumber(numb).size() != 0) {
                    map.put("permanentVisitor", permanentVisitor);
                    map.put("permanentVisitorList", visitorService.getVisitorByNumber(numb));
                    map.put("tempVisitorListIn", tempVisitorService.getTempVisitorByNumberAndStatusIn(numb));
                    map.put("tempVisitorListOut", tempVisitorService.getTempVisitorByNumberAndStatusOut(numb));
                    System.out.println(tempVisitorService.getTempVisitorByNumberAndStatusOut(numb).size());
                    System.out.println(tempVisitorService.getTempVisitorByNumberAndStatusIn(numb).size());
                    return "nullGuard";
                }
            }
             
        }
        else if (action.toLowerCase().substring(action.indexOf(".") + 1).equals("запустить")) {
            TempVisitor tempVisitorResult = tempVisitorService.get(Integer.parseInt(action.substring(0, action.toString().indexOf("."))));
            if (tempVisitorResult.getIsHere() == null) {
                tempVisitorResult.setStatus("Выпустить");
                System.out.println(tempVisitor.getRealNumber());
                if (tempVisitor.getRealNumber().replaceAll(",", "").equals("") || tempVisitor.getRealNumber() == null)
                    tempVisitorResult.setRealNumber(tempVisitorResult.getCarNumber());
                else {
                    tempVisitorResult.setRealNumber(tempVisitor.getRealNumber().replaceAll(",", ""));
                }
                tempVisitorResult.setIsHere("Въ");
                tempVisitorService.edit(tempVisitorResult);
                return "permanentVisitor";
            }
        }
        else if (action.toLowerCase().substring(action.indexOf(".") + 1).equals("выпустить")) {
            
        	TempVisitor tempVisitorResult = tempVisitorService.get(Integer.parseInt(action.substring(0, action.toString().indexOf("."))));
        	if (tempVisitorResult.getDateTo() == null) {
	            tempVisitorResult.setStatus("CLOSE");
	            tempVisitorResult.setIsHere(tempVisitorResult.getIsHere() + " выехал " + new Date().toString());;
	            tempVisitorService.edit(tempVisitorResult);
	            tempVisitorService.deleteFromView();
	            return "permanentVisitor";
        	}
        	else {
        		String month;
                Date dateC = new Date();
                String day;
                String today = dateC.getYear() + "";
                if (dateC.getMonth() < 10) 
                    month = "0" + (dateC.getMonth() + 1);
                else
                    month = "" + dateC.getMonth() + 1;
                if (dateC.getDate() < 10) 
                    day = "0" + dateC.getDate();
                else
                    day = "" + dateC.getDate();
                today = month + "/" + day + "/20" + today.substring(1,3);
                
        		String dateToMonth = tempVisitorResult.getDateTo().substring(3, 5);
        		String dateToDay = tempVisitorResult.getDateTo().substring(0, 2);
        		String dateToYear = tempVisitorResult.getDateTo().substring(6, 10);
        		System.out.println(dateToMonth);
        		System.out.println(dateToDay);
        		System.out.println(dateToYear);
        		if (Integer.parseInt(dateToYear) >= Integer.parseInt(today.substring(6, 10)))
        			if (Integer.parseInt(dateToMonth) >= Integer.parseInt(month))
        				if (Integer.parseInt(dateToDay) >= Integer.parseInt(day)) {
        					
        					tempVisitorResult.setStatus("Запустить");
        		            tempVisitorResult.setIsHere(null);
        		            tempVisitorService.edit(tempVisitorResult);
        				}
        				else {
        					tempVisitorResult.setStatus("CLOSE");
        		            tempVisitorResult.setIsHere("вы");;
        		            tempVisitorService.edit(tempVisitorResult);
        		            tempVisitorService.deleteFromView();
        				}
        			else {
        				tempVisitorResult.setStatus("CLOSE");
    		            tempVisitorResult.setIsHere("вы");;
    		            tempVisitorService.edit(tempVisitorResult);
    		            tempVisitorService.deleteFromView();
        			}
        		else {
        			tempVisitorResult.setStatus("CLOSE");
		            tempVisitorResult.setIsHere("вы");;
		            tempVisitorService.edit(tempVisitorResult);
		            tempVisitorService.deleteFromView();
        		}
        	}
        }
        else if (action.toLowerCase().equals("автомобили на территории")) {
            map.put("tempVisitorList", tempVisitorService.getTempVisitorIsHere());
            return "carIn";
        }
         
        return "permanentVisitor";
    }
}