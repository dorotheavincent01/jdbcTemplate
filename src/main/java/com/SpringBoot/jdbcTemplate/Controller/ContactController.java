package com.SpringBoot.jdbcTemplate.Controller;

import java.util.List;

import com.SpringBoot.jdbcTemplate.Repository.ContactRepo;
import com.SpringBoot.jdbcTemplate.Model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ContactController {
    @Autowired
    ContactRepo contactRepo;

    //Add Contact
    @RequestMapping("/addContact")
    //@RequestMapping(value = "/addContact", method = RequestMethod.POST)
    @ResponseBody
    public String addContact(@RequestParam("id") int id, @RequestParam("name") String name,
                             @RequestParam("country") String country, @RequestParam("contact_no") int contact_no){
        if(contactRepo.addContact(id, name, country, contact_no) >= 1){
            return "Contact Added Successfully";
        }else{
            return "Add Failed.";
        }
    }

    //Update Contact
    @RequestMapping("/updateContact")
    //@RequestMapping(value = "/updateContact", method = RequestMethod.PUT)

    @ResponseBody
    public String updateContact(@RequestParam("id") int id, @RequestParam("name") String name,
                                @RequestParam("country") String country, @RequestParam("contact_no") int contact_no){
        if(contactRepo.updateContact(name,country,contact_no,id) >= 1){
            //return template.update(query,id,name,country,contact_no)
            return "Contact updated Successfully";
        }else{
            return "Update failed.";
        }
    }

    //Delete Contact
    @RequestMapping("/deleteContact")
    //@RequestMapping(value = "/deleteContact", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteContact(@RequestParam("id") int id){
        if(contactRepo.deleteContact(id) >= 1){
            return "Contact Deleted Successfully";
        }else{
            return "Delete Failed !";
        }
    }

    //Display all Contacts
    @RequestMapping("/getAllContact")
    //@RequestMapping(value = "/getAllContact", method = RequestMethod.GET)

    @ResponseBody
    public List<Contact> getAllContact(){
        return contactRepo.getAllContact();
    }

    //Display selected Contact
    @RequestMapping("/getContact")
    //@RequestMapping(value = "/getContact", method = RequestMethod.GET)

    @ResponseBody
    public Contact getContact(@RequestParam("id") int id){
        return contactRepo.getContact(id);
    }
}
