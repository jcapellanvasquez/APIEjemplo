package com.example.demo.controller;

import com.example.demo.model.Response;
import com.example.demo.model.Todo;
import com.example.demo.model.Usuario;
import com.example.demo.service.EjemploService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/salvar_usuario", method = RequestMethod.POST)
    public Response<Map<String, Object>> setUsuario(@RequestBody Response<Map<String, Object>> response) {
        //Response<List<Map<String,Object>>> rs = new Response<>();
//        String usuario = response.getData().get("usuario").
//        this.service.salvarUsuario("usuario1", "password1");
//        response.setStatusCode(1);
        return response;
    }

//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public Response<Usuario> login(@RequestBody Response<Usuario> response) {
//        System.out.println(response.getData().getPassword());
//        System.out.println(response.getData().getUsuario());
//        response.setStatusCode(1);
//        return response;
//    }

//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public String login() {
//
//        return "hola";
//    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Response<Usuario> login(@RequestParam String usuario, @RequestParam String password) {
        Response<Usuario> rs = new Response<>();

        try {
            Usuario usuario1 = this.service.getToken(usuario,password);
            rs.setData(usuario1);
            rs.setStatusCode(1);
            return rs;
        }
        catch (Exception e) {
            rs.setStatusCode(-1);
            return rs;
        }


    }


}
