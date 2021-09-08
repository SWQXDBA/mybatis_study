package com.example.mybatis;

import com.example.mybatis.dao.StudentDao;
import com.example.mybatis.model.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Configuration
public class SqlsessionGetter {
    @Bean(name = "SqlSessionFactory")
    public SqlSessionFactory get(){
        String resource = "mybatisConfig.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            return factory;
        } catch (IOException e) {      //
            e.printStackTrace();
        }
        return null;
    }
}
