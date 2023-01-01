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
	<%@include file="header.jsp" %>
	<div class="main_div">
		<div class ="main_name">${oneClass.className}</div>
		<div class ="main_imgg" ><img class="main_img_img" src="./${oneClass.classNumber}-${oneClass.classNumber}.jpg"></div>
		<div class ="main_list">
			<div>정원 : ${oneClass.maxStudent} 명</div>
			<div>공방주소:${oneClass.place}</div> 
			<div> 개강일자:${oneClass.day}</div>
		</div>
		<div class="main_list">
			<div>가격 : ${oneClass.price}원 </div>
			<div>소요시간:${oneClass.time}</div>
			<div><a href="./personnel?classNumber=${oneClass.classNumber}">수강인원현황</a></div>
		</div>
		<div class="main_submit">
			<div><a href="./add?classNumber=${oneClass.classNumber}">클래스 신청하기</a></div>
		</div>
	</div>
	
	
	
	<%@include file="footer.jsp" %>
</body>
</html>