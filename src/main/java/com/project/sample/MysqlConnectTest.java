package com.project.sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnectTest {
	public static void main(String[] args) {
		// MySQL 연결 정보
		String url = "jdbc:mysql://localhost:3306/db_test";
		String username = "pm_finn";
		String password = "1234";

		// JDBC 드라이버 로드
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("MySQL JDBC 드라이버를 찾을 수 없습니다.");
			e.printStackTrace();
			return;
		}

		// MySQL 연결
		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			System.out.println("MySQL 데이터베이스에 성공적으로 연결되었습니다.");
		} catch (SQLException e) {
			System.out.println("MySQL 데이터베이스에 연결하는 중 오류가 발생했습니다.");
			e.printStackTrace();
		}
	}
}
