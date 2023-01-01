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
	
	public void deletDb (Reservation b) throws Exception {
		Connection conn = open();
		
		String sql = "delete from reservation where studentnumber = ? and classnumber = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		try (conn; pstmt) {
			pstmt.setInt(1, b.getStudentNumber());
			pstmt.setInt(2, b.getClassNumber());
			pstmt.executeUpdate();
		}
		
	}
	
	//클래스 넘버를 받아서 예약디비에 조회 후에 스튜던트 객체를 리턴해줘야함
	public ArrayList<OneDayStudent> getPersonnelList(int classNumber) throws Exception {
		Connection conn = open();
		
		ArrayList<OneDayStudent> o = new ArrayList<OneDayStudent>();
		String sql = "select T1.studentnumber, T1.jumin, T1.studentname, T1.phone from onedaystudent T1 join reservation T2 on (t1.studentnumber = t2.studentnumber) where t2.classnumber = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, classNumber);
		ResultSet rs = pstmt.executeQuery();
//		rs.next();
		
		try(conn; pstmt; rs) {
			while (rs.next()) {
				OneDayStudent s = new OneDayStudent();
				s.setStudentNumber(rs.getInt(1));
				s.setJumin(rs.getString(2));
				s.setStudentName(rs.getString(3));
				s.setPhone(rs.getString(4));
				
				o.add(s);
			}
			
			return o;
		}
	
	}

	
	//회원가입
	public void signUp (OneDayStudent s) throws Exception {
		Connection conn = open();
		String sql = "insert into OneDayStudent (STUDENTNUMBER, JUMIN, STUDENTNAME, PHONE) VALUES (STUDENT_SEQ.NEXTVAL,?,?,?)";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		try (conn; pstmt) {
			pstmt.setString(1, s.getJumin());
			pstmt.setString(2, s.getStudentName());
			pstmt.setString(3, s.getPhone());
			pstmt.executeUpdate();
		} 
	}
	
	public String juminCheck(OneDayStudent s) throws Exception {
	int b = 0;
	Connection conn = open();
//	String sql = "SELECT COUNT(*) FROM OneDayStudent WHERE JUMIN = ?";
	String sql = "SELECT jumin FROM OneDayStudent WHERE JUMIN = ?";
	
	//쿼리문 준비
	PreparedStatement pstmt = conn.prepareStatement(sql);
	
	//?에 값을 넣어주기
	pstmt.setString(1, s.getJumin());
	
	//실행한 쿼리문을 rs객체에 담아준다.
	ResultSet rs = pstmt.executeQuery();
	
	//다음 컬럼이 있느냐 없느냐를 확인해주는 메소드
	try (conn; pstmt; rs) {	
		if (rs.next()) {			
			return "0";
//			return "중복된 주민등록 번호가 있습니다";  
		}
		else {
			return "1";
//			return "중복된 주민등록 번호가 없습니다";  
		}
		
	}
	
	}
	
	
	
	//db에 입력해주기
	public void addDbUp (Reservation r, int result) throws Exception {
		Connection conn = open();
		String sql = "insert into reservation (reservationnumber, classnumber, studentnumber) VALUES (reservation_SEQ.nextval,?,?)";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		try (conn; pstmt) {
			pstmt.setInt(1, r.getClassNumber());
			pstmt.setInt(2, result);
			pstmt.executeUpdate();
		}
	}
	
	//회원번호 찾기
	public int getStudentNumber (String inputJumin) throws Exception {
		Connection conn = open();
		OneDayStudent student = new OneDayStudent();
		String sql = "select STUDENTNUMBER, JUMIN, STUDENTNAME, PHONE FROM onedaystudent WHERE JUMIN = ?";
		int result = 0;
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, inputJumin);  //sql문 ? 에 세팅해주기
		ResultSet rs = pstmt.executeQuery();
		
		try(conn; pstmt) {
			while (rs.next()) {
				student.setStudentNumber(rs.getInt(1));
				student.setJumin(rs.getString(2));
				student.setStudentName(rs.getString(3));
				student.setPhone(rs.getString(4));
				
				result = student.getStudentNumber();
			}
			return result;
		}
		
	}
	
	
	
	
}
