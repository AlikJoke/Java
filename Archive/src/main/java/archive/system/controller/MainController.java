package archive.system.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import archive.system.entity.Account;
import archive.system.entity.AccountList;
import archive.system.entity.Citizen;
import archive.system.service.AccountListService;
import archive.system.service.AccountService;
import archive.system.service.CitizenService;
import archive.system.service.EmailService;
import archive.system.service.PhoneNumberService;

@Controller
public class MainController {
	@Autowired
    private CitizenService citizenService;
	
	@Autowired
    private AccountService accountService;
    
	@Autowired
    private AccountListService accountListService;
	
	@Autowired
    private PhoneNumberService phoneNumberService;
     
	@Autowired
    private EmailService emailService;
    
	Integer id;
	String searchGlobal;
	
    @RequestMapping({"/index", "/"})
    public String setupForm(Map<String, Object> map) {
    	map.put("accountList", accountListService.getAccounts());
        return "permanentVisitor";
    }
    
    @RequestMapping(value="/AccountAdd", method=RequestMethod.POST)
    public String AddAction(@ModelAttribute AccountList account, @RequestParam String action, @RequestParam("account") String accountNumber, @RequestParam("id") String accountId, Map<String, Object> map) {
        switch(action.toLowerCase()) {
            case "добавить л/с":
                if (accountNumber.equals("") || accountNumber.length() > 10) {
                    map.put("accountList", accountListService.getAccounts());
                } else {
                    account.setAccount(accountNumber);
                    accountListService.add(account);
                }
                break;
                  
            case "редактировать":
                if (accountNumber.equals("") || accountNumber.length() > 10 || accountId.equals("")) {
                    map.put("accountList", accountListService.getAccounts());
                } else {
                    account.setAccountId(Integer.parseInt(accountId));
                    account.setAccount(accountNumber); 
                    accountListService.edit(account); 
                }
                break;
            case "удалить":
                if (accountId.equals("")) {
                    map.put("accountList", accountListService.getAccounts());
                } else { 
                    if (accountListService.get(Integer.parseInt(accountId)) != null)
                        accountListService.delete(Integer.parseInt(accountId)); 
                }
                break;
        }
        map.put("accountList", accountListService.getAccounts());
        return "permanentVisitor";
    }
    
    @RequestMapping(value="/AddPermanent", method=RequestMethod.POST)
    public String doActions(@ModelAttribute Citizen citizen, @RequestParam("name") String name, @RequestParam("select") List account,
            @RequestParam String action, @RequestParam("isChecked") List isChecked, @RequestParam("addressTSJNumbHome") String addressTSJNumbHome,
            @RequestParam("addressReal") String addressReal, @RequestParam("addressTSJNumbKorp") String addressTSJNumbKorp, @RequestParam("addressTSJNumbRoom") String addressTSJNumbRoom, @RequestParam("myphone[]") List phoneNumber,
            @RequestParam("myemail[]") List email, Map<String, Object> map) {
    	 
    	map.put("accList", accountListService.getAccounts());
    	//System.out.println((((AccountList) accountListService.getAccounts().get(4)).getAccount()));
    	if (action.toLowerCase().equals("+")) {
    		citizen.setName(name);
	        citizen.setAddressReal(addressReal);
	        citizen.setAddressTSJ("ул. Весенняя, дом" + addressTSJNumbHome + ", корп." + addressTSJNumbKorp + ", кв." + addressTSJNumbRoom);

    		phoneNumber.remove("");
    		phoneNumber.remove("");
    		phoneNumber.remove("");
    		phoneNumber.remove("");
    		phoneNumber.remove("");
    		phoneNumber.remove("");
    		phoneNumber.remove("");
    		account.remove("");
    		account.remove("");
    		account.remove("");
    		account.remove("");
    		account.remove("");
    		account.remove("");
    		account.remove("");
    		email.remove("");
    		email.remove("");
    		email.remove("");
    		email.remove("");
    		email.remove("");
    		email.remove("");
    		email.remove("");
	        
	        Iterator iterator = phoneNumber.iterator();
	        List phones = new ArrayList();
	        
	        while (iterator.hasNext()) {
	        	String temp = iterator.next().toString();
	        	phones.add(temp.substring(0, 1) + " (" + temp.substring(1, 4) + ") " + temp.substring(4, 7) + " " + temp.substring(7, 9) + " " + temp.substring(9, 11));
	        }
	        
	        Set phoneNumbers = new HashSet();   
	        phoneNumbers.addAll(phones);
	        citizen.setPhoneNumbers(phoneNumbers);
	        
	        Set emails = new HashSet();
	        emails.addAll(email);
	        citizen.setEmails(emails);
	        
	        Set accounts = new HashSet();
	        accounts.addAll(account);
	        citizen.setAccounts(accounts);
	        
	        if (isChecked.contains("member")) 
	        	citizen.setIsMember("1");
	        else
	        	citizen.setIsMember("0");
	        
	        if (isChecked.contains("responsible"))
	        	citizen.setIsResponsible("1");
	        else
	        	citizen.setIsResponsible("0");
	        
	        isChecked.remove("checked");
	        isChecked.remove("member");
	        isChecked.remove("responsible");
	        List list = new ArrayList();
	        for (int i = 0; i < isChecked.size(); i++)
	        	list.add(isChecked.get(i).toString().substring(5));
	        
	        List listOwners = new ArrayList();
	        for (int i = 0; i < account.size(); i++) {
	        	listOwners.add("0");
	        }
	        
	        for (int i = 0; i < list.size(); i++) {
	        	listOwners.add(Integer.parseInt(list.get(i).toString()) - 1, "1");
	        }
	       
	        System.out.println(listOwners);
	        citizenService.add(citizen);
	        accountService.add(citizen, listOwners);
	        phoneNumberService.add(citizen);
	        emailService.add(citizen);
    		
	    }
    	else if (action.toLowerCase().equals("закрыть"))
    		return "permanentVisitor";
        return "addPermanent";
    }
    
    @RequestMapping(value="/GetCitizen", method=RequestMethod.POST)
    public String doActionGet(@ModelAttribute Citizen citizen, @RequestParam("search") String search, @RequestParam String action, Map<String, Object> map) {
    	if (action.toLowerCase().equals("найти")) {
    		searchGlobal = search.toLowerCase();
    		if (search.equals("")) return "permanentVisitor";
    		else if (search.matches("[0-9]*")) {
	    		List list = citizenService.getCitizenByAccountPart(search);
	            list.addAll(citizenService.getCitizenByPhoneNumberPart(search));
	           
	            map.put("citizenList", list);
	            return "permanentVisitor";
	        }
	        else if (search.toLowerCase().matches("[а-я]*")) {          
	            map.put("citizenList", citizenService.getCitizenByNamePart(search.toLowerCase()));
	            return "permanentVisitor";
	        }
	        else {            
	            map.put("citizenList", citizenService.getCitizenByAccountPart(search.toLowerCase()));
	            return "permanentVisitor";
	        }
    	}
    	else if (action.toLowerCase().equals("добавить нового жильца")) {
    		Iterator iterator = accountListService.getAccounts().iterator();
    		List accountList = new ArrayList();
    		while (iterator.hasNext()) {
    			accountList.add(((AccountList) iterator.next()).getAccount());
    		}
    		Collections.sort(accountList, Collections.reverseOrder());
    		map.put("accList", accountList);
        	System.out.println((((AccountList) accountListService.getAccounts().get(4)).getAccount()));
    		return "addPermanent";
    	}
    	else if (action.toLowerCase().contains("show")) {
    		id = Integer.parseInt(action.toLowerCase().substring(0, action.toLowerCase().indexOf(".")));
    		if (citizenService.get(id).getIsMember().equals("1")) 
    			map.put("member", "Да");
    		else
    			map.put("member", "Нет");
    		
    		if (citizenService.get(id).getIsResponsible().equals("1")) 
    			map.put("responsible", "Да");
    		else
    			map.put("responsible", "Нет");
    		
    		List list = new ArrayList();
    		
    		int i = accountService.getAccounts(id).size() - 1;
    		while (i >= 0) {
    			if (((Account) accountService.getAccounts(id).get(i)).getIsOwner().equals("1"))
    				list.add("Собственник: [" + ((Account) accountService.getAccounts(id).get(i)).getAccount() + "]");
    			else 
    				list.add("Жилец: [" + ((Account) accountService.getAccounts(id).get(i)).getAccount() + "]");   			
    			
    			i--;
    		}
    		map.put("accountOwner", list);
    		
    		map.put("citizen", citizenService.get(id));
    		return "info";
    	}
    	else if (action.toLowerCase().contains("-")) {
    		Integer deleteId = Integer.parseInt(action.toLowerCase().substring(0, action.toLowerCase().indexOf(".")));
    		emailService.delete(deleteId);
    		phoneNumberService.delete(deleteId);
    		accountService.delete(deleteId);
    		citizenService.delete(deleteId);
    		
    		if (searchGlobal.equals("")) return "permanentVisitor";
    		else if (searchGlobal.matches("[0-9]*")) {
	    		List list = citizenService.getCitizenByAccountPart(searchGlobal);
	            list.addAll(citizenService.getCitizenByPhoneNumberPart(searchGlobal));
	           
	            map.put("citizenList", list);
	            return "permanentVisitor";
	        }
	        else if (searchGlobal.toLowerCase().matches("[а-я]*")) {          
	            map.put("citizenList", citizenService.getCitizenByNamePart(searchGlobal.toLowerCase()));
	            return "permanentVisitor";
	        }
	        else {            
	            map.put("citizenList", citizenService.getCitizenByAccountPart(searchGlobal.toLowerCase()));
	            return "permanentVisitor";
	        }
    	}
    	return "permanentVisitor";
    }
    
    @RequestMapping(value="/Back", method=RequestMethod.POST)
    public String doActionBack(@ModelAttribute Citizen citizen, @RequestParam String action, Map<String, Object> map) {
    	if (action.toLowerCase().equals("закрыть"))
    		return "permanentVisitor";
    	else if (action.toLowerCase().equals("редактировать")) {
    		String str = ((Citizen) citizenService.get(id)).getAddressTSJ().substring(14, ((Citizen) citizenService.get(id)).getAddressTSJ().length());
    		map.put("numbHome", str.toCharArray()[3]);
    		
    		map.put("accList", accountListService.getAccounts());
    		map.put("numbKorp", str.substring(str.indexOf("п") + 2).toCharArray()[0]);
    		map.put("numbRoom", str.substring(str.indexOf("в") + 2));
    		//System.out.println(str.toCharArray()[3] + " " + str.substring(str.indexOf("п") + 2).toCharArray()[0] + " " + str.substring(str.indexOf("в")));
    		map.put("citizen", citizenService.get(id));
    		return "editCitizen";
    	}
    	return "permanentVisitor";
    }
    
    @RequestMapping(value="/EditCitizen", method=RequestMethod.POST)
    public String doActionEdit(@ModelAttribute Citizen citizenModel, @RequestParam("name") String name, @RequestParam("select") List account, @RequestParam("isChecked") List isChecked,
            @RequestParam String action, @RequestParam("addressTSJNumbHome") String addressTSJNumbHome, @RequestParam("addressTSJNumbKorp") String addressTSJNumbKorp,
            @RequestParam("addressReal") String addressReal, @RequestParam("addressTSJNumbRoom") String addressTSJNumbRoom, @RequestParam("myphone[]") List phoneNumber,
            @RequestParam("myemail[]") List email, Map<String, Object> map) {
    	
    	if (action.toLowerCase().equals("закрыть"))
    		return "permanentVisitor";
    	else if (action.toLowerCase().equals("редактировать")) {
    		Citizen citizen = citizenService.get(id);
    		citizen.setName(name);
	        citizen.setAddressReal(addressReal);
	        citizen.setAddressTSJ("ул. Весенняя, дом" + addressTSJNumbHome + ", корп." + addressTSJNumbKorp + ", кв." + addressTSJNumbHome);
	        
	        account.remove("");
    		account.remove("");
    		email.remove("");
    		email.remove("");
    		phoneNumber.remove("");
    		phoneNumber.remove("");
    		
    		Iterator iterator = phoneNumber.iterator();
	        List phones = new ArrayList();
	        
	        while (iterator.hasNext()) {
	        	String temp = iterator.next().toString();
	        	phones.add(temp.substring(0, 1) + " (" + temp.substring(1, 4) + ") " + temp.substring(4, 7) + " " + temp.substring(7, 9) + " " + temp.substring(9, 11));
	        }
	        
	        Set phoneNumbers = new HashSet();   
	        phoneNumbers.addAll(phoneNumber);
	        citizen.setPhoneNumbers(phoneNumbers);
	        
	        Set emails = new HashSet();
	        emails.addAll(email);
	        citizen.setEmails(emails);
	        
	        Set accounts = new HashSet();
	        accounts.addAll(account);
	        citizen.setAccounts(accounts);
    		
	        if (isChecked.contains("member")) 
	        	citizen.setIsMember("1");
	        else
	        	citizen.setIsMember("0");
	        
	        if (isChecked.contains("responsible"))
	        	citizen.setIsResponsible("1");
	        else
	        	citizen.setIsResponsible("0");
	        
	        isChecked.remove("checked");
	        isChecked.remove("member");
	        isChecked.remove("responsible");
	        List list = new ArrayList();
	        for (int i = 0; i < isChecked.size(); i++)
	        	list.add(isChecked.get(i).toString().substring(5));
	        
	        List listOwners = new ArrayList();
	        for (int i = 0; i < account.size(); i++) {
	        	listOwners.add("0");
	        }
	        
	        for (int i = 0; i < list.size(); i++) {
	        	listOwners.add(Integer.parseInt(list.get(i).toString()) - 1, "1");
	        }
	        
	        citizenService.edit(citizen);
	        
	        accountService.delete(id);
	        accountService.add(citizen, listOwners);
	        
	        phoneNumberService.delete(id);
	        phoneNumberService.add(citizen);
	        
	        emailService.delete(id);
	        emailService.add(citizen);
	        
	        /*List accountsEdit = accountService.getAccounts(id);
	        Iterator iterator = accountsEdit.iterator();
	        while (iterator.hasNext())
	        	accountService.edit((Account) iterator.next());*/
	        
    		return "permanentVisitor";
    	}
    	return "permanentVisitor";
    }
}