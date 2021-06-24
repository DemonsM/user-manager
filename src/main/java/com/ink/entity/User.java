package com.ink.entity;

import lombok.Data;

@Data
public class User {
    private Long id;

    private String name;

    private Integer age;

    private Double salary;

    private String phone;
}
