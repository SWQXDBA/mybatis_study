package com.example.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;

@Configuration
public class SqlsessionGetter {
    @Bean(name = "SqlSessionFactory")
    public SqlSessionFactory get(){
        String resource = "mybatisConfig.xml";
        InputStream inputStream ;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            return new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {      //
            e.printStackTrace();
        }
        return null;
    }
}
