package com.main.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class User implements UserDetails {
    private String FirstName ;
    private String LastName;
    private String Email;

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    private String ImageUrl;
    private String TotalItems;

    public Integer isActive() {
        return IsActive;
    }

    public void setActive(Integer active) {
        IsActive = active;
    }

    private Integer IsActive;
    public String getJobType() {
        return JobType;
    }

    public void setJobType(String jobType) {
        JobType = jobType;
    }

    private String JobType;

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    private boolean isLocked;


    public String getPositionName() {
        return PositionName;
    }


    public void setPositionName(String positionName) {
        PositionName = positionName;
    }

    private String PositionName;

    public Integer getPositionId() {
        return PositionId;
    }


    public void setPositionId(Integer positionId) {
        PositionId = positionId;
    }

    private Integer PositionId;

    public Integer getUserTypeId() {
        return UserTypeId;
    }

    public void setUserTypeId(Integer userTypeId) {
        UserTypeId = userTypeId;
    }

    private Integer UserTypeId;

    public void setId(Integer id) {
        Id = id;
    }

    private Integer Id;

    public String getUserTypeName() {
        return UserTypeName;
    }

    public void setUserTypeName(String userTypeName) {
        UserTypeName = userTypeName;
    }

    private String UserTypeName ;

    public String getTotalItems() {
        return TotalItems;
    }

    public void setTotalItems(String totalItems) {
        TotalItems = totalItems;
    }

    public String getTotalPages() {
        return TotalPages;
    }

    public void setTotalPages(String totalPages) {
        TotalPages = totalPages;
    }

    private String TotalPages;

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

    public String getUserType() {
        return UserType;
    }

    public void setUserType(String userType) {
        UserType = userType;
    }

    private String UserType;


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

    public void setPassword(String password) {
        Password = password;
    }

    private String Password;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
        return Password;
    }

    private String username;

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }




}
