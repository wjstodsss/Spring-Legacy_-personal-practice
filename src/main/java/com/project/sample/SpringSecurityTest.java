package com.project.sample;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class SpringSecurityTest {

    public static void main(String[] args) {
        testSpringSecurity();
        testSpringJDBC();
    }

    private static void testSpringSecurity() {
        // Spring Security의 PasswordEncoder 테스트
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String rawPassword = "password123";
        String encodedPassword = passwordEncoder.encode(rawPassword);
        System.out.println("Encoded Password: " + encodedPassword);
        boolean matches = passwordEncoder.matches(rawPassword, encodedPassword);
        System.out.println("Password Matches: " + matches);
    }

    private static void testSpringJDBC() {
        // Spring JDBC 테스트
        // 여기에 Spring JDBC를 사용하여 데이터베이스와 연결하는 코드를 추가할 수 있습니다.
        // 연결이 성공적으로 이루어지면 해당 데이터베이스와 연결된 것으로 간주합니다.
    	
    	DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/db_test"); // 여기에 데이터베이스명을 설정해주세요.
        dataSource.setUsername("user_test"); // 여기에 데이터베이스 사용자명을 설정해주세요.
        dataSource.setPassword("1234"); // 여기에 데이터베이스 암호를 설정해주세요.

        // JdbcTemplate을 사용하여 데이터베이스와 연결
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        // SQL 쿼리는 각각 개별적으로 실행되어야 합니다.drop과 create를 함꼐 사용하면 에러 발생
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
            System.out.println("Table 'tbl_test' created successfully.");
        } catch (Exception e) {
            System.err.println("Error creating table: " + e.getMessage());
        }
    }
}
