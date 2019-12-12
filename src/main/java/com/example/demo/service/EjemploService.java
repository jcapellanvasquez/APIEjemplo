package com.example.demo.service;

import com.example.demo.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
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

}
