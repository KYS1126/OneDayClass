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
	<form name="frm" action="addup">
		<table class="add_table">
			<div class="add_div">
				<div class="add_diva">클래스 이름:${oneClass.className}${oneClass.classNumber}</div>
				<div class="add_divb">
					<input type="hidden" name=classNumber
						value="${oneClass.classNumber}">
				</div>
				<div class="add_divc">
					주민등록번호<input type="text" name="jumin" placeholder="ex) 971126-1111111">
				</div>
				<div class="studentadd_btn">
					<button class="btnadd" type="button" onclick="fn_add();">신청하기</button>
				</div>
			</div>

		</table>
	</form>

	<%@include file="footer.jsp"%>
	<script type="text/javascript" src="./script.js"></script>
</body>
</html>