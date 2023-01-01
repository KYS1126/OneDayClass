<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<%@ include file="header.jsp"%>

	<div class="div_index">
		<div class="main">
			<c:forEach var="list" items="${list}" varStatus="status">
				<div class="studio_div">
					<div>
						<a href="./main?classNumber=${list.classNumber}"> <img  class = "index_img" src="./${list.classNumber}.jpg">
						</a>
					</div>
					<div class="index_name">
						<a href="./main?classNumber=${list.classNumber}">${list.className}</a>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>

	<%@ include file="footer.jsp"%>
</body>
</html>
