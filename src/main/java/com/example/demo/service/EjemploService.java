package com.example.demo.service;

import com.example.demo.model.Todo;
import com.example.demo.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
@Service
public class EjemploService {

    @Autowired
    SQLService SQL;

    public List<Map<String, Object>> getTodos() {
        return this.SQL.executeQueryAsList("select * from todo");
    }

    public void salvarUsuario(String usuario, String password) {
        this.SQL.executeQueryInsertUpdate("insert into usuario (usuario,password) VALUES('" + usuario + "','" + password + "')");
    }

    public Usuario getToken(String usuario, String password) throws Exception {
        try {
            String sql = "select *  from usuario where usuario='" + usuario + "' and password='" + password + "'";
            return this.SQL.jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Usuario.class));
        } catch (Exception e) {
            e.printStackTrace();
            throw  e;
        }
    }

}
