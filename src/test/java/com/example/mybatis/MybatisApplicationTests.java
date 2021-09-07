package com.example.mybatis;

import com.example.mybatis.dao.StudentDao;
import com.example.mybatis.model.Student;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybatisApplicationTests {


    @Autowired
    SqlSessionFactory sqlSessionFactory;
    @Test
    void contextLoads() {
        SqlSession sqlsession = sqlSessionFactory.openSession();
        StudentDao mapper= sqlsession.getMapper(StudentDao.class);
        System.out.println(mapper.selectStudents());

        System.out.println(mapper.selectStudent(2));

    }
    @Test

    void contextLoads2() {
        try (SqlSession sqlsession = sqlSessionFactory.openSession()){
            StudentDao mapper = sqlsession.getMapper(StudentDao.class);
            Student student = new Student();
            student.setAge(15);
            student.setName("小黄");
            System.out.println(mapper.insertStudent(student));
            sqlsession.commit();

        }


    }

}
