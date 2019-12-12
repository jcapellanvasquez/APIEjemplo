package com.example.demo.model;

public class Response<T>  {
    private Integer statusCode;
    private T data;

    public Response(Integer statusCode, T data) {
        this.statusCode = statusCode;
        this.data = data;
    }

    public Response() {}

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
