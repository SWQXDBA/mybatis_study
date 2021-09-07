package com.example.mybatis.dao;

import com.example.mybatis.model.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface StudentDao {
    Student selectStudent(int id);
    List<Student> selectStudents();
    int insertStudent(Student student);
}
