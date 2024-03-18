package com.project.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public class Bean_SpringSecurityTest {

    private final DriverManagerDataSource dataSource;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public Bean_SpringSecurityTest(DriverManagerDataSource dataSource, JdbcTemplate jdbcTemplate) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
    }

    public void testSpringSecurity() {
        // Spring Security의 PasswordEncoder 테스트
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String rawPassword = "password123";
        String encodedPassword = passwordEncoder.encode(rawPassword);
        System.out.println("Encoded Password: " + encodedPassword);
        boolean matches = passwordEncoder.matches(rawPassword, encodedPassword);
        System.out.println("Password Matches: " + matches);
    }

    public void testSpringJDBC() {
        // SQL 쿼리는 각각 개별적으로 실행되어야 합니다. drop과 create를 함께 사용하면 에러가 발생할 수 있습니다.
        // 테이블 삭제 SQL 문
        String dropTableSQL = "DROP TABLE IF EXISTS tbl_test;";
        // 테이블 생성 SQL 문
        String createTableSQL = "CREATE TABLE IF NOT EXISTS tbl_test (" +
                                "id INT AUTO_INCREMENT PRIMARY KEY," +
                                "username VARCHAR(50) NOT NULL," +
                                "password VARCHAR(255) NOT NULL)";

        try {
            // 테이블 생성
            jdbcTemplate.execute(dropTableSQL);
            jdbcTemplate.execute(createTableSQL);
            System.out.println("Table 'users' created successfully.");
        } catch (Exception e) {
            System.err.println("Error creating table: " + e.getMessage());
        }
    }
}
