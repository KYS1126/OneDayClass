<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<%@include file="header.jsp"%>
	<form name="frm" method="post"
		action="update">
		<div class="main_div">
			<div class="main_name">${oneClass.className}</div>
			<div class ="main_imgg" ><img class="main_img_img" src="./${oneClass.classNumber}-${oneClass.classNumber}.jpg"></div>
			<div class="main_list">
				<input type="hidden" name="classNumber"
					value="${oneClass.classNumber}">
				<div>
					<input type="text" name="className" value="${oneClass.className}">
					<label>클래스 이름</label>
				</div>
				<div>
					<input type="text" name="price" value="${oneClass.price}">
					<label>가격</label>
				</div>
				<div>
					<input type="text" name="day" value="${oneClass.day}"> <label>개강
						날짜</label>
				</div>
			</div>
			<div class="main_list">
				<div>
					<input type="text" name="time" value="${oneClass.time}"> <label>소요
						시간</label>
				</div>
				<div>
					<input type="text" name="maxStudent" value="${oneClass.maxStudent}">
					<label>최대 인원</label>
				</div>
				<div>
					<input type="text" name="place" value="${oneClass.place}">
					<label>주소</label>
				</div>
			</div>
		</div>
	</form>
	<div class="bt_wrap">
		<button class="btn" type="button" onclick="classup();">수정하기</button>
	</div>
	<%@include file="footer.jsp"%>
	<script type="text/javascript" src="./script.js"></script>
</body>
</html>