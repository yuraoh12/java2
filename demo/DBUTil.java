package com.sbs.example.demo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DBUTil {

	// 자동임포트 : 컨트로 + (좌)쉬프트 + O
	Connection conn = null; // DB 접속 관리
	Statement stmt = null; // sql query 처리
	ResultSet rs = null; // 결과 처리

	String url = "jdbc:mysql://localhost:3306/board?serverTimezone=UTC";
	String user = "root";
	String pass = "";

	public DBUTil() {
		init();
	}
	// ==========================================================================================
	// 초기화 함수
	public void init() {
		try {
			// 1. 드라이버 세팅
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 2. Connection 획득
			conn = DriverManager.getConnection(url, user, pass);

			// 3. Statement 생성
			stmt = conn.createStatement();

			// 4. SQL 처리하고 결과 ResultSet에 받아오기

			

		} catch (Exception e) {
			System.out.println("접속 시도중 문제 발생!!");
		}
	}
	
	// ==========================================================================================
	// 리스트 가져오기
	public ArrayList<Article> selectArticles() {
		
		String sql = "SELECT * FROM article";
		ArrayList<Article> articleList = new ArrayList<>();
		
		try {
			
			rs = stmt.executeQuery(sql);
	
			while (rs.next()) {
				String title = rs.getString("title");
				String body = rs.getString("body");
				
				Article a = new Article(title, body);
				articleList.add(a);
			}
			
		} catch(Exception e) {
			System.out.println("데이터를 가져오다가 문제 발생");
			
		} finally {
			close();
		}
		
		return articleList;
	}
	
	// ==========================================================================================
	// 수정
	public void updateArticle(String title) {
		
		try {
			stmt = conn.createStatement();
			
			String sql = "UPDATE article\r\n" + 
					"SET title = '" + title + "'\r\n" + 
					"WHERE body = 'bbb'";
			
			stmt.executeUpdate(sql);
			
		} catch(Exception e) {
			System.out.println("데이터를 반영하다가 문제 발생");
		} finally {
			close();
		}
	}
	
	// ==========================================================================================
	// 삭제
	public void deleteArticle(String title) {
		
		try {
			stmt = conn.createStatement();
			
			String sql = "DELETE FROM article WHERE title = " + title;
			
			stmt.executeUpdate(sql);
			
		} catch(Exception e) {
			System.out.println("데이터를 반영하다가 문제 발생");
		} finally {
			close();
		}
	}
	
	// ==========================================================================================
	// 삽입
	public void insertAddress(String name, String address, String phone) {
		
		try {
			stmt = conn.createStatement();
			
			String sql = "INSERT INTO t_address \r\n" + 
					"SET `name` = '" + name + "',\r\n" + 
					"`address` = '"  + address + "',\r\n" + 
					"`phone` = '" + phone + "',\r\n" + 
					"regDate = NOW()";  
			
			stmt.executeUpdate(sql);
			
		} catch(Exception e) {
			System.out.println("데이터를 반영하다가 문제 발생");
		} finally {
			close();
		}
	}
	// ==========================================================================================
	// 자원 해제	
	private void close() {
		try {
			if(stmt != null) {
				stmt.close();		
			}
			if(rs != null) {
				rs.close();		
			}
			
		} catch(Exception e) {
			System.out.println("자원 해제중 문제 발생");
		}
	}
}