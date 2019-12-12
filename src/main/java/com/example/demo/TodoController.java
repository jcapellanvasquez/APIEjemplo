package com.example.demo;

import com.example.demo.model.Response;
import com.example.demo.model.Todo;
import com.example.demo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("todo")
public class TodoController {

    @Autowired
    public TodoRepository todoRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Response<List<Todo>> getTodos() {
        Response<List<Todo>> rs = new Response<>();
        rs.setData(this.todoRepository.findAll());
        rs.setStatusCode(1);
        return rs;
    }

    @RequestMapping(value = "/done", method = RequestMethod.POST)
    public Response<Todo> setDone(@RequestBody Todo todo) {
        Response<Todo> rs = new Response<>();
        try {
            Todo todo1 = this.todoRepository.findByIdCustom(todo.getId());
            rs.setStatusCode(1);
            todo1.setDone(todo.getDone());
            todo1.setDoneDate(todo.getDoneDate());
            rs.setData(this.todoRepository.save(todo1));
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            rs.setStatusCode(-1);
            rs.setData(null);
            return rs;
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Response<Todo> deleteTodo(@RequestBody Todo todo) {
        Response<Todo> rs = new Response<>();
        try {
            Todo todo1 = this.todoRepository.findByIdCustom(todo.getId());
            this.todoRepository.delete(todo1);
            rs.setData(null);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            rs.setStatusCode(-1);
            rs.setData(null);
            return rs;
        }
    }

    @RequestMapping(value="/save", method = RequestMethod.POST)
    public Response<Todo> setTodo(@RequestBody Response<Todo> rs) {
        try {
            Todo todo1 = new Todo();
            todo1.setTitle(rs.getData().getTitle());
            todo1.setCreatedDate(rs.getData().getCreatedDate());
            todo1.setDescription(rs.getData().getDescription());
            todo1.setProgramatedDate(rs.getData().getProgramatedDate());
            rs.setData(this.todoRepository.save(todo1));
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            rs.setStatusCode(-1);
            return rs;
        }
    }

}
