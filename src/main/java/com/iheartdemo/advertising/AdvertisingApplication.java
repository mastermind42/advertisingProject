package com.iheartdemo.advertising;

import com.iheartdemo.advertising.repository.AdvertiserRepository;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.io.Reader;

@SpringBootApplication
public class AdvertisingApplication {

    private static SqlSessionFactory factory = null;

    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        Reader reader = null;

        reader = Resources.getResourceAsReader(resource);
        factory = new SqlSessionFactoryBuilder().build(reader);
        factory.getConfiguration().addMapper(AdvertiserRepository.class);
        reader.close();

        try (SqlSession session = factory.openSession()) {
            System.out.println("open!");
            SpringApplication.run(AdvertisingApplication.class, args);
        }

    }



}
