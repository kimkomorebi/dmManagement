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
						<th>�� ���̵�</th>
						<td><input type="text" name="ID"/></td>
					</tr>
					<tr>
						<th>����</th>
						<td><input type="text" name="NAME"/></td>
					</tr>
					<tr>
						<th>���� ��ǰ</th>
						<td><input type="text" name="GOODS"/></td>
					</tr>
					<tr>
						<th>��ȭ��ȣ</th>
						<td><input type="text" name="PHONE"/></td>
					</tr>
					<tr>
						<th>�̸���</th>
						<td><input type="text" name="EMAIL"/></td>
					</tr>
					<tr>
						<th>���� ����</th>
						<td><input type="text" name="AREA"/></td>
					</tr>
				</table><br/>
				<div align="center"><input type="submit" value="�� ���� ���"/></div>
			</form>
		</div>
	</section>
	<%@ include file="footer.jsp" %>
</body>
</html>