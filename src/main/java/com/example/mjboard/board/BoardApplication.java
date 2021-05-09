package com.example.mjboard.board;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@SpringBootApplication
public class BoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoardApplication.class, args);
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath*:/mapper/*.xml");
        sessionFactoryBean.setMapperLocations(res);
        return sessionFactoryBean.getObject();
    }

    /**
     * @SpringBootApplication
     * 해당 어노테이션으로 해당 스프링에 시작하는 클래스를 알려준다.
     * @Configuration, @EnableAutoConfiguration 그리고 @ComponentScan를 포함하고 있습니다.
     */

}
