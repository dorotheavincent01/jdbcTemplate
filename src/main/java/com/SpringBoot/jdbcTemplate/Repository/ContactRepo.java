package com.SpringBoot.jdbcTemplate.Repository;

import com.SpringBoot.jdbcTemplate.Model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContactRepo {

    @Autowired
    JdbcTemplate template;

    /*Adding contact into database table*/
    public int addContact(int id, String name, String country, int contact_no){
        String query = "INSERT INTO contact VALUES(?,?,?,?)";
        return template.update(query,id,name,country,contact_no);
    }

    /*Update contact in database*/
    public int updateContact(String name, String country, int contact_no, int id){
        String query = "UPDATE contact SET name =?, country =?, contact_no =? WHERE id =?";
        return template.update(query,name,country,contact_no,id);
    }

    /*Delete contact from database*/
    public int deleteContact(int id){
        String query = "DELETE FROM contact WHERE id =?";
        return template.update(query,id);
    }

    /*Getting all contact from table*/
    public List<Contact> getAllContact(){
        List<Contact> items = template.query("SELECT id, name, country, contact_no FROM contact",(result,rowNum)->new Contact(result.getInt("id"),
                result.getString("name"),result.getString("country"), result.getInt("contact_no")));
        return items;
    }

    /*Getting selected contact from table*/
    public Contact getContact(int id){
        String query = "SELECT * FROM contact WHERE ID=?";
        Contact contact = template.queryForObject(query,new Object[]{id},new BeanPropertyRowMapper<>(Contact.class));
        return contact;
    }


}
