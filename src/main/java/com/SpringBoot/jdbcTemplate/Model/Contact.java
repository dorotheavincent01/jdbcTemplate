package com.SpringBoot.jdbcTemplate.Model;

public class Contact {
    private int id;
    private String name;
    private String country;
    private int contact_no;

    public Contact() {
    }

    public Contact(int id, String name, String country, int contact_no) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.contact_no = contact_no;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getContactno() {
        return contact_no;
    }

    public void setContactno(int email) {
        this.contact_no = email;
    }

}
