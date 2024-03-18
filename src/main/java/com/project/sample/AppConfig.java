package com.project.sample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class AppConfig {

    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/db_test"); // 여기에 데이터베이스명을 설정해주세요.
        dataSource.setUsername("user_test"); // 여기에 데이터베이스 사용자명을 설정해주세요.
        dataSource.setPassword("1234"); // 여기에 데이터베이스 암호를 설정해주세요.
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DriverManagerDataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public Bean_SpringSecurityTest bean_SpringSecurityTest(DriverManagerDataSource dataSource, JdbcTemplate jdbcTemplate) {
        return new Bean_SpringSecurityTest(dataSource, jdbcTemplate);
    }
}
