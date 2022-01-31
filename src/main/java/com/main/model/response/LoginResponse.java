package com.main.model.response;

import java.util.List;


    public class LoginResponse {

        private String firstName;

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        private String phoneNumber;

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        private String imageUrl;

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getFirstName() {
            return firstName;
        }

        private String lastName;

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        private Integer Id;

        public Integer getId() {
            return Id;
        }

        public void setId(Integer id) {
            Id = id;
        }

        private String email;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        private String token;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        private String userType;

        public String getUserType() {
            return userType;
        }

        public void setUserType(String userType) {
            this.userType = userType;
        }

        private String position;

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }


    }


