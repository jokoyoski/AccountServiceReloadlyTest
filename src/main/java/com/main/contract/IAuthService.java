package com.main.contract;

import com.main.helpers.PaginatedListResponse;
import com.main.model.ServerResponse;
import com.main.model.User;
import com.main.model.request.UserRegistrationRequest;
import com.main.model.response.UserResponse;

import java.util.List;
import java.util.Optional;

public interface IAuthService {

    ServerResponse<String> InsertUser(UserRegistrationRequest userRegistrationRequest);

    ServerResponse<String> UpdateUser(UserRegistrationRequest userRegistrationRequest);

    PaginatedListResponse<UserResponse> GetUsers(String pageNumber);

    User GetUserByEmail(String email);

    Optional<User> getUserByUsername(String username);
}
