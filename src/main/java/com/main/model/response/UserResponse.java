package com.main.model.response;

import java.util.Date;

public class UserResponse {

    private String FirstName ;
    private String LastName;
    private String Email;





    public void setId(Integer id) {
        Id = id;
    }

    private Integer Id;

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public Date getDateRegistered() {
        return DateRegistered;
    }

    public void setDateRegistered(Date dateRegistered) {
        DateRegistered = dateRegistered;
    }

    private Date DateRegistered;

    private String PhoneNumber;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String id;

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
