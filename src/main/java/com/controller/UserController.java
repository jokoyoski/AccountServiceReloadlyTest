package com.controller;

import com.main.contract.IAuthService;
import com.main.model.ServerResponse;
import com.main.model.request.UserRegistrationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;



    @RequestMapping("/api")
    @RestController

    public class UserController {


        @Autowired
        private IAuthService _authAservice;


        @PostMapping("/user/add-user")
        public ResponseEntity<?> AddUser(@RequestBody UserRegistrationRequest user) throws Exception {
            user.setPassword(user.getEmail());
            user.setConfirmPassword(user.getEmail());
            ServerResponse<String> serverResponse = _authAservice.InsertUser(user);
            if(serverResponse==null ){
                ServerResponse<String> serverResponses=new ServerResponse<String>();
                serverResponses.setDescription("An error occurred, try again later");
                return new ResponseEntity<Object>(serverResponses, HttpStatus.EXPECTATION_FAILED);
            }
            if(!serverResponse.getCode().equals("201") ){
                return new ResponseEntity<Object>(serverResponse, HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<Object>(serverResponse, HttpStatus.CREATED);
        }


        @PostMapping("update-user")
        public ResponseEntity<?> UpdateUser(@RequestBody UserRegistrationRequest user) throws Exception {
            ServerResponse<String> serverResponse = _authAservice.UpdateUser(user);
            if(serverResponse==null ){
                ServerResponse<String> serverResponses=new ServerResponse<String>();
                serverResponses.setDescription("An error occurred, try again later");
                return new ResponseEntity<Object>(serverResponses, HttpStatus.EXPECTATION_FAILED);
            }
            if(!serverResponse.getCode().equals("201") ){
                return new ResponseEntity<Object>(serverResponse, HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<Object>(serverResponse, HttpStatus.CREATED);
        }


        @GetMapping("/user/{email}")
        public ResponseEntity<?> GetUser( @PathVariable String email ) throws Exception {

            var user=_authAservice.GetUserByEmail(email);
            return new ResponseEntity<Object>(user, HttpStatus.OK);
        }





    }


