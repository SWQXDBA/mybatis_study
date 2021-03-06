package com.example.mybatis;

import com.example.mybatis.dao.PStudentDao;
import com.example.mybatis.dao.StudentDao;
import com.example.mybatis.model.Student;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class MybatisApplicationTests {


    @Autowired
    SqlSessionFactory sqlSessionFactory;

    @Test
    void contextLoads() {
        SqlSession sqlsession = sqlSessionFactory.openSession();
        StudentDao mapper = sqlsession.getMapper(StudentDao.class);
        System.out.println(mapper.selectStudents());

        System.out.println(mapper.selectStudent(2));

    }
    @Test

    void contextLoads2() {
        try (SqlSession sqlsession = sqlSessionFactory.openSession()){
            StudentDao mapper = sqlsession.getMapper(StudentDao.class);
            for (int i = 0; i < 100; i++) {
                Student student = new Student();
                student.setAge(i);
                student.setName("name:"+i);
                mapper.insertStudent(student);
            }

            sqlsession.commit();

        }
    }

    @Test
    void contextLoads3() {
        try (SqlSession sqlsession = sqlSessionFactory.openSession()) {
            PStudentDao mapper = sqlsession.getMapper(PStudentDao.class);
            System.out.println(mapper.selectStudents());
        }
    }

    @Test
    void contextLoads4() {
        try (SqlSession sqlsession = sqlSessionFactory.openSession()) {

            StudentDao mapper = sqlsession.getMapper(StudentDao.class);
            Student student = new Student();
            student.setAge(15);
            student.setName("小黄");
            System.out.println(mapper.selectStudentWhere(student));


        }
    }

    @Test
    void contextLoads5() {
        try (SqlSession sqlsession = sqlSessionFactory.openSession()) {

            StudentDao mapper = sqlsession.getMapper(StudentDao.class);
            List<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(15);
            // select name,age from student WHERE id in ( ? ,? )
            //list不能为空 不然会where in
            //导致sql语句出错
            System.out.println(mapper.selectStudentIn(list));
        }
    }

    @Test
    void contextLoadCache() {
        try (SqlSession sqlsession = sqlSessionFactory.openSession();
        SqlSession sqlsession2 = sqlSessionFactory.openSession()
        ) {

            StudentDao mapper = sqlsession.getMapper(StudentDao.class);
            StudentDao mapper2 = sqlsession2.getMapper(StudentDao.class);

            Student student = mapper.selectStudent(1);
            sqlsession.close();//会话关闭后数据才会写入二级缓存
            Student student2 = mapper2.selectStudent(1);
            System.out.println(student2==student);

        }
    }

    @Test
    void contextLoadCacheInsert1() {
        try (SqlSession sqlsession = sqlSessionFactory.openSession();
             SqlSession sqlsession2 = sqlSessionFactory.openSession()
        ) {

            StudentDao mapper = sqlsession.getMapper(StudentDao.class);
            System.out.println(mapper.countStudent("-1"));

        }
    }
}
