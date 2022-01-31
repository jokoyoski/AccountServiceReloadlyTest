package com.main.implementation;

import com.main.contract.IAuthService;
import com.main.helpers.Constants;
import com.main.helpers.PaginatedListResponse;
import com.main.model.ServerResponse;
import com.main.model.User;
import com.main.model.request.UserRegistrationRequest;
import com.main.model.response.BaseResponse;
import com.main.model.response.UserResponse;
import com.repository.factories.GetUserQuery;
import com.repository.factories.InsertUserQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
@Service
public class AuthService implements IAuthService {

    @Autowired
    private GetUserQuery getUserQuery;

    @Autowired
    private InsertUserQuery insertUserQuery;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Override
    public ServerResponse<String> InsertUser(UserRegistrationRequest userRegistrationRequest) {
        var resp = new BaseResponse<String>();
        var userRecord=getUserQuery.GetUser(userRegistrationRequest.getEmail());

        if(userRecord!=null)
        {
            ServerResponse<String> serverResponse=new ServerResponse<>();
            serverResponse.setCode("400");
            serverResponse.setDescription("User Already Exist");
            serverResponse.setValues("0");
            return serverResponse;
        }

        userRegistrationRequest.setPassword((userRegistrationRequest.getPassword() == null || userRegistrationRequest.getPassword().isBlank() || userRegistrationRequest.getPassword().isEmpty())?
                Constants.DEFAULT_PASSWORD : userRegistrationRequest.getPassword());

        String password=userRegistrationRequest.getPassword();
        String encodedPassword=passwordEncoder.encode(password);
        userRegistrationRequest.setPassword(encodedPassword);

        Date date = new Date();
        userRegistrationRequest.setDateRegistered(new Date(System.currentTimeMillis()));


        var userId= insertUserQuery.InsertUser(userRegistrationRequest,false);

        if (userId == "null") {
            return null;
        }

        ServerResponse<String> serverResponse=new ServerResponse<>();
        serverResponse.setCode("201");
        serverResponse.setDescription("User Added Successfully");
        serverResponse.setValues(userId);

        return serverResponse;
    }

    @Override
    public ServerResponse<String> UpdateUser(UserRegistrationRequest userRegistrationRequest) {
        ServerResponse<String> serverResponse=new ServerResponse<>();

        var userRecord=getUserQuery.GetUser(userRegistrationRequest.getEmail());

        if(userRecord == null){
            serverResponse.setCode(HttpStatus.BAD_REQUEST.toString());
            serverResponse.setDescription("User does not exist.");
            return  serverResponse;
        }

        Date date = new Date();
        userRegistrationRequest.setDateRegistered(new Date(System.currentTimeMillis()));
        var userId= insertUserQuery.InsertUser(userRegistrationRequest,true);
        serverResponse.setCode("201");
        serverResponse.setDescription("User Updated Successfully");
        serverResponse.setValues(userId);
        return serverResponse;
    }

    @Override
    public PaginatedListResponse<UserResponse> GetUsers(String pageNumber) {
        return null;
    }

    @Override
    public User GetUserByEmail(String email) {
        return null;
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        var result=  getUserQuery.GetUser(username);
        Optional<User> opt = Optional.ofNullable(result);
        return opt;
    }


    public static boolean isNull(String str) {
        return str == null ? true : false;
    }

    public static boolean isNullOrBlank(String param) {
        if (isNull(param) || param.trim().length() == 0) {
            return true;
        }
        return false;
    }
}
