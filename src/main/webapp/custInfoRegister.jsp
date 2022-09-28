<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	<section>
		<div align="center">
			<form action="custInfoRegister.do" method="post">
				<table border="1">
					<tr>
						<th>고객 아이디</th>
						<td><input type="text" name="ID"/></td>
					</tr>
					<tr>
						<th>성명</th>
						<td><input type="text" name="NAME"/></td>
					</tr>
					<tr>
						<th>관심 상품</th>
						<td><input type="text" name="GOODS"/></td>
					</tr>
					<tr>
						<th>전화번호</th>
						<td><input type="text" name="PHONE"/></td>
					</tr>
					<tr>
						<th>이메일</th>
						<td><input type="text" name="EMAIL"/></td>
					</tr>
					<tr>
						<th>거주 지역</th>
						<td><input type="text" name="AREA"/></td>
					</tr>
				</table><br/>
				<div align="center"><input type="submit" value="고객 정보 등록"/></div>
			</form>
		</div>
	</section>
	<%@ include file="footer.jsp" %>
</body>
</html>