<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style.css">
<title>용용의 원데이 클래스 - 회원가입</title>
</head>
<body>
	<%@include file="header.jsp"%>

	<form name="frm" method="post" action="signup">
		<table class="studentadd_table">
			<tr>
				<th class="studentadd_th" >주민등록번호</th>
				<td><input maxlength="14" type="text" name="jumin" placeholder="ex) 971126-1111111"></td>
			</tr>
			<tr>
				<th class="studentadd_th">이름</th>
				<td><input maxlength="3" type="text" name="studentName" placeholder="ex) 김용수"></td>
			</tr>
			<tr>
				<th class="studentadd_th">휴대폰번호</th>
				<td><input maxlength="13" oninput="autoHyphen2(this)" type="text" name="phone" placeholder="-를 빼고 입력해 주세요"></td>
			</tr>
		</table>
		<div class="studentadd_btn">
			<button class="btnadd" type="button" onclick="fn_submit();">신청하기</button>
		</div>
	</form>

	<script type="text/javascript" src="./script.js"></script>
	<%@include file="footer.jsp"%>
</body>
</html>