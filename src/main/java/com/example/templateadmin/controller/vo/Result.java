package com.example.templateadmin.controller.vo;

import lombok.Data;

@Data
public class Result<T> {

    private int code;

    private String msg;

    private int count;

    private T data;


}
