package com.example.demo.repository;

import com.example.demo.repository.model.RUserDetail;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RUserDetailMapper implements RowMapper<RUserDetail> {
    public RUserDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
        RUserDetail user = new RUserDetail(rs.getInt("user_id"), rs.getString("role"));
        return user;
    }
}

