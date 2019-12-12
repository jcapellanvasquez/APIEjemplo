package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Timestamp;
import java.util.*;

@Service
public class SQLService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Map executeQueryAsMap(String query) {

        try {
            return jdbcTemplate.queryForMap(query);
        } catch (Exception e) {
            e.printStackTrace();
            return new HashMap<Object, Object>();
        }
    }

    public DataSource getDataSource() {
        return this.jdbcTemplate.getDataSource();
    }

    public List<Map<String, Object>> executeQueryAsList(String query) {

        try {
            return jdbcTemplate.queryForList(query);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

   public void executeQueryInsertUpdate(String query) {
        jdbcTemplate.update(query);
    }

    public Date getCurrentDateFormBD() {
        return jdbcTemplate.queryForObject("select now()",Date.class);
    }

    public Timestamp getCurrentTimestampFormBD() {
        return jdbcTemplate.queryForObject("select now()", Timestamp.class);
    }

}
