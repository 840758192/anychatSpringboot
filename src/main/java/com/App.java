package com;

import com.anychat.org.util.SpringUtil;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        ConfigurableApplicationContext run = SpringApplication.run(App.class);
        SpringUtil.setApplicationContext(run);
        SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) SpringUtil.getBean("sqlSessionFactory");
        MybatisManager.setSqlSessionFactory(sqlSessionFactory);
    }
}
