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
	<div>${oneClass.className}</div>
	<form name="frm" action="ch">
		<table>
			<tr>
				<th>클래스이름${oneClass.classNumber}</th>
				<td><input type="text" name="className"></td>
			</tr>
			<tr>
				<th>주민등록번호</th>
				<td><input type="text" name="jumin"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="studentName"></td>
			</tr>
			<tr>
				<td>
					<button class="btn" type="button"
						onclick="fn_submit();">신청하기</button>
				</td>
			</tr>
		</table>
	</form>

	<%@include file="footer.jsp"%>
</body>
</html>