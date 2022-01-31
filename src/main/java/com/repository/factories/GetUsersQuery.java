package com.repository.factories;

import com.main.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@Component
public class GetUsersQuery {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private SimpleJdbcCall simpleJdbcCall;

    // init SimpleJdbcCall
    @PostConstruct
    void init() {
        // o_name and O_NAME, same
        jdbcTemplate.setResultsMapCaseInsensitive(true);

        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("usp_users")
                .returningResultSet("result", new BeanPropertyRowMapper<>(User.class))
        ;

    }


    public List<User> GetUsers() {
        SqlParameterSource in = new MapSqlParameterSource();
        Optional result = Optional.empty();
        try {

            Map out = simpleJdbcCall.execute(in);

            if (out != null) {
                var record = ((List) out.get("result"));
                return (List<User>) record;
            }

        } catch (Exception e) {
            // ORA-01403: no data found, or any java.sql.SQLException
            System.err.println(e.getMessage());
        }

        return new ArrayList<>();
    }
}

