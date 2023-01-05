<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<%@include file="header.jsp"%>
	<div class="ps_name">${oneClass.className} 인원현황</div>
	<div class="main_imgg"><img class="main_img_img" src="./${oneClass.classNumber}-${oneClass.classNumber}.jpg"></div>
	<div class="ps_main">
		<div class="ps_student">정원 ${oneClass.maxStudent} 명</div>
		<table>
			<tr>
				<th>회원넘버</th>
				<th>주민등록번호 앞자리</th>
				<th>이름</th>
				<th>전화번호</th>
			</tr>
			<c:forEach var="studentList" items="${oneClassStudent}"
				varStatus="status">
				<tr>
					<td>${studentList.studentNumber}</td>
					<td>${studentList.jumin}</td>
					<td>${studentList.studentName}</td>
					<td>${studentList.phone}</td>
					<td>		
					<form name="fo" action="delete">
						<input type="hidden" name="studentNumber" value="${studentList.studentNumber}">
						<input type="hidden" name="classNumber" value="${oneClass.classNumber}">
						<button class="btn" type="button" onclick="conf()" >삭제하기</button>
						<!-- <button class="btn" type="submit" >삭제하기</button> -->
					</form>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>


<script type="text/javascript" src="./script.js"></script>
	<%@include file="footer.jsp"%>
</body>
</html>