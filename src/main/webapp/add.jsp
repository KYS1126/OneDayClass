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
		<table>
			<tr>
				<th>클래스 이름:${oneClass.className}${oneClass.classNumber}</th>
				<td><input type="hidden" name=classNumber value="${oneClass.classNumber}"></td>
			</tr>
			<tr>
				<th>주민등록번호</th>
				<td><input type="text" name="jumin"></td>
			</tr>
			<tr>
				<td>
					<button class="btn" type="button"
						onclick="fn_add();">신청하기</button>
				</td>
			</tr>
		</table>
	</form>

	<%@include file="footer.jsp"%>
	<script type="text/javascript" src="./script.js"></script>
</body>
</html>