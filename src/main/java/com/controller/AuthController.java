package com.controller;

import com.main.contract.IAuthService;
import com.main.helpers.JwtTokenUtil;
import com.main.model.User;
import com.main.model.request.LoginRequest;
import com.main.model.response.BaseResponse;
import com.main.model.response.LoginResponse;
import com.main.model.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

    @RestController
    @RequestMapping(path = "api/v1/auth")
    public class AuthController {

        @Autowired
        private AuthenticationManager authenticationManager;

        @Autowired
        private JwtTokenUtil jwtTokenUtil;

        @Autowired
        private IAuthService authService;

        @PostMapping("login")
        public ResponseEntity<BaseResponse<LoginResponse>> login(@RequestBody LoginRequest request) {

            var response = new BaseResponse<LoginResponse>();

            try {

                Authentication authenticate = authenticationManager
                        .authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

                User user = (User) authenticate.getPrincipal();

                if(user.getUserTypeName().equals("jjj")){
                    response.setResponseCode(HttpStatus.UNAUTHORIZED);
                    response.setResponseDescription(String.format("User Locked",""));

                    return new ResponseEntity<BaseResponse<LoginResponse>>(response, response.getResponseCode());
                }

                var logInResp = new LoginResponse();

                logInResp.setId(Integer.parseInt(user.getId()));
                logInResp.setFirstName(user.getFirstName());
                logInResp.setLastName(user.getLastName());
                logInResp.setEmail(user.getEmail());

                logInResp.setToken(jwtTokenUtil.generateAccessToken(user));
                logInResp.setPhoneNumber(user.getPhoneNumber());
                response.setResponse(logInResp);
                response.setResponseCode(HttpStatus.OK);
                response.setResponseDescription("SUCCESSFUL");
                return new ResponseEntity<BaseResponse<LoginResponse>>(response, response.getResponseCode());

            } catch (Exception ex) {

                response.setResponseCode(HttpStatus.UNAUTHORIZED);
                response.setResponseDescription(String.format("Bad Credentials!!", ex.getMessage()));

                return new ResponseEntity<BaseResponse<LoginResponse>>(response, response.getResponseCode());
            }
        }





    }

