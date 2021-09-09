package com.example.mybatis.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@Getter
@Setter
public class Student implements Serializable {
    public int id;
    public String name;
    public int age;
}
