package com.example.demo.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Table(name = "todo", schema = "public")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String description;

    @Column(name = "is_done")
    private Boolean isDone = false;

    @Column(name = "created_date")
    private Timestamp createdDate;

    @Column(name = "programated_date")
    private Timestamp programatedDate;

    @Column(name="done_date")
    private Timestamp doneDate;

    public Todo() {}


    public Todo(Integer id, String title, String description, Boolean isDone, Timestamp createdDate, Timestamp programatedDate, Timestamp doneDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.isDone = isDone;
        this.createdDate = createdDate;
        this.programatedDate = programatedDate;
        this.doneDate = doneDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDone() {
        return isDone;
    }

    public void setDone(Boolean done) {
        isDone = done;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getProgramatedDate() {
        return programatedDate;
    }

    public void setProgramatedDate(Timestamp programatedDate) {
        this.programatedDate = programatedDate;
    }

    public Timestamp getDoneDate() {
        return doneDate;
    }

    public void setDoneDate(Timestamp doneDate) {
        this.doneDate = doneDate;
    }
}
