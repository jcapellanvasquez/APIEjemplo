package com.example.demo.controller;

import com.example.demo.model.Response;
import com.example.demo.model.Todo;
import com.example.demo.service.EjemploService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("ejemplo")
public class EjemploController {

    @Autowired
    EjemploService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Response<List<Map<String,Object>>> getTodos() {
        Response<List<Map<String,Object>>> rs = new Response<>();
        rs.setData(service.getTodos());
        rs.setStatusCode(1);
        return rs;
    }
}
