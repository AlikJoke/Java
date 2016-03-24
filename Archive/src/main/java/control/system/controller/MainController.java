package control.system.controller;
 
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import control.system.entity.Account;
import control.system.entity.Citizen;
import control.system.entity.Email;
import control.system.entity.PhoneNumber;
import control.system.service.AccountService;
import control.system.service.CitizenService;
import control.system.service.EmailService;
import control.system.service.PhoneNumberService;
 
@Controller
public class MainController {
    @Autowired
    private CitizenService myCitizenService;
     
    @Autowired
    private PhoneNumberService myPhoneNumberService;
    
    @Autowired
    private AccountService myAccountService;
    
    @Autowired
    private EmailService myEmailService;
    
    @RequestMapping({"/index", "/"})
    public String setupForm(Map<String, Object> map) {
       
        
        return "addPermanent";
    }
     
    
    @RequestMapping(value="/AddPermanent", method=RequestMethod.POST)
    public String doActions(@ModelAttribute Citizen citizen, @RequestParam("name") String name,
            @RequestParam String action, @RequestParam("account1") String account1, @RequestParam("account2") String account2, @RequestParam("phoneNumber1") String phoneNumber1,
            @RequestParam("phoneNumber2") String phoneNumber2, @RequestParam("email") String email, @RequestParam("addressReal") String addressReal, Map<String, Object> map) {
        
        citizen.setName(name);
        citizen.setIsMember("s");
        citizen.setIsOwner("q");
        citizen.setIsResponsible("fd");
        citizen.setAddressReal(addressReal);
        citizen.setAddressTSJ("dfsdfs");
        Set phoneNumbers = new HashSet();
        phoneNumbers.add(phoneNumber1);
        phoneNumbers.add(phoneNumber2);
        citizen.setPhoneNumbers(phoneNumbers);
        Set emails = new HashSet();
        emails.add(email);
        citizen.setEmails(emails);
        
        Set accounts = new HashSet();
        accounts.add(account1);
        accounts.add(account2);
        citizen.setAccounts(accounts);
        myCitizenService.add(citizen);
        
        return "addPermanent";
    }
}