package com.repository.factories;


import com.main.model.User;
import com.main.model.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class GetUserQuery {

    @Autowired
    private DataSource dataSource;

    private SimpleJdbcCall jdbcCall;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public GetUserQuery(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public User GetUser(String username) {

        try {

            SqlParameterSource param = new MapSqlParameterSource()
                    .addValue("email", username);

            this.jdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("usp_Get_User_By_Email").returningResultSet("user", BeanPropertyRowMapper.newInstance(User.class));

            var result   = (List<User>)this.jdbcCall.execute(param).get("user");

            if(result == null || result.size() <= 0) return  null;

            return result.get(0);

        } catch (Exception e) {
            System.err.println(e);
            throw (e);
        }
    }

}
