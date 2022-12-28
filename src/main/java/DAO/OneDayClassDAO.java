package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import DTO.*;

public class OneDayClassDAO {

	
	final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	
	
	public Connection open() {
		Connection conn = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn=DriverManager.getConnection(JDBC_URL, "test", "test1234");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public ArrayList<OneDayClass> getOneClass() throws Exception {
		Connection conn = open();
		ArrayList<OneDayClass> classList = new ArrayList<OneDayClass>();
		
		String sql = "select classnumber,classname from OneDayClass";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		try (conn; pstmt; rs) {
			while (rs.next()) {
				OneDayClass o = new OneDayClass();
				o.setClassNumber(rs.getInt(1));
				o.setClassName(rs.getString(2));
				
				classList.add(o);
			}
			return classList;
		}
		
	}
	
	public OneDayClass getView(int classNumber) throws Exception {
		Connection conn = open();
		
		OneDayClass d = new OneDayClass();
		String sql = "select classnumber, classname, price, day, time, maxstudent, place from OneDayClass where classnumber= ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		//where 문을 사용해서 어딜 바꿔야 할지 지정해줘야함.
		//다른 방법으로 쿼리문 맨 끝에 classNumber 를 따로 써주는 방법도 있음
		pstmt.setInt(1, classNumber);
		ResultSet rs = pstmt.executeQuery();
		
		rs.next();
		
		try(conn; pstmt; rs) {
			d.setClassNumber(rs.getInt(1));
			d.setClassName(rs.getString(2));
			d.setPrice(rs.getInt(3));
			d.setDay(rs.getDate(4));
			d.setTime(rs.getString(5));
			d.setMaxStudent(rs.getInt(6));
			d.setPlace(rs.getString(7));
			
			pstmt.executeQuery();
			return d;
		}
	
	}
	
	public ArrayList<OneDayStudent> getStudent (HttpServletRequest request) throws Exception {
		
		//add input에서 가져온 애
		
		String inputJumin = request.getParameter("jumin");
		String inputStudentName = request.getParameter("studentName");

		Connection conn = open();
		ArrayList<OneDayStudent> studentList = new ArrayList<OneDayStudent>();
		
		String sql = "select studentnumber,jumin,studentname,phone from OneDayStudent";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		try(conn; pstmt; rs) {
			while(rs.next()) {
				OneDayStudent s = new OneDayStudent();
				s.setStudentNumber(rs.getInt(1));
				s.setJumin(rs.getString(2));
				s.setStudentName(rs.getString(3));
				s.setPhone(rs.getString(4));
				
				studentList.add(s);
				
			}
			return studentList;
		} 
		
	}
	
}
