package com.example.mybatis.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@ToString
@Getter
@Setter
public class PStudent {
    public int stu_id;
    public String stu_name;
    public int stu_age;
}
