<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style.css">
<title>Insert title here</title>
</head>
<body>
	<%@include file="header.jsp"%>
	
		<form name="frm" method="post" action="signup">
		<table class="studentadd_table">
			<tr>
				<th class="studentadd_th">주민등록번호</th>
				<td><input type="text" name="jumin"></td>
			</tr>
			<tr>
				<th class="studentadd_th">이름</th>
				<td><input type="text" name="studentName"></td>
			</tr>
			<tr>
				<th class="studentadd_th">휴대폰번호</th>
				<td><input type="text" name="phone"></td>
			</tr>
			<tr>
				<td class="studentadd_btn">
					<button class="btn" type="button"
						onclick="fn_submit();">신청하기</button>
				</td>
			</tr>
		</table>
	</form>

<script type="text/javascript" src="./script.js"></script>
	<%@include file="footer.jsp"%>
</body>
</html>