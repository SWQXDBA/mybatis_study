package com.example.mybatis.dao;

import com.example.mybatis.model.PStudent;

import java.util.List;

public interface PStudentDao {
    PStudent selectStudent(int id);
    List<PStudent> selectStudents();

}
