package com.example.mybatis.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@ToString
@Getter
@Setter
public class Student {
    public int id;
    public String name;
    public int age;
}
