package com.repository.factories;

import com.main.model.request.UserRegistrationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;
@Component
public class InsertUserQuery {





        @Autowired
        private JdbcTemplate jdbcTemplate;

        private SimpleJdbcCall simpleJdbcCall;

        // init SimpleJdbcCall
        @PostConstruct
        void init() {
            // o_name and O_NAME, same
            jdbcTemplate.setResultsMapCaseInsensitive(true);

            simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withProcedureName("usp_Insert_User")
                    .returningResultSet("result", new BeanPropertyRowMapper<>(String.class))
            ;
        }

        public String InsertUser(UserRegistrationRequest user, boolean isUpdate) {
            MapSqlParameterSource namedParameters = new MapSqlParameterSource();
            namedParameters.addValue("FirstName", user.getFirstName());
            namedParameters.addValue("LastName", user.getLastName());
            namedParameters.addValue("Email", user.getEmail());
            namedParameters.addValue("Password", user.getPassword());
            namedParameters.addValue("PhoneNumber", user.getPhoneNumber());
            namedParameters.addValue("DateCreated", user.getDateRegistered());
            namedParameters.addValue("ImageUrl", user.getImageUrl());


            namedParameters.addValue("IsActive", true);
            try {
                Map out = simpleJdbcCall.execute(namedParameters);
                if(!isUpdate){
                    if (out != null) {
                        var userId =   out.get("Id").toString();
                        return userId;
                    }
                }

            } catch (Exception e) {
                // ORA-01403: no data found, or any java.sql.SQLException
                System.err.println(e.getMessage());
                return  "null";
            }
            return "null";
        }




}
