<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="header.jsp"%>
	<div class="main_div">
		<div class="main_name">공방이름 / 인원현황</div>
		<div class="main_img">공방대표이미지</div>

		<div class="">
			<div>정원00명</div>
			<table>
				<tr>
					<th>회원넘버</th>
					<th>주민등록번호 앞자리</th>
					<th>이름</th>
					<th>전화번호</th>
				</tr>
				<c:forEach var="studentList" items="${oneClassStudent}" varStatus="status">
					<tr>
						<td>${studentList.studentNumber}</td>
						<td>${studentList.jumin}</td>
						<td>${studentList.studentName}</td>
						<td>${studentList.phone}</td>
					</tr>
				</c:forEach>
			</table>
		</div>



		<%@include file="footer.jsp"%>
</body>
</html>