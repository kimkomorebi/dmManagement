<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		DmList dl = (DmList)request.getAttribute("DL");
	%>
		<%@ include file="header.jsp" %>
	<section>
		<div align="center">
			<form action="">
				<table border="1">
					<tr>
						<th>�߼۹�ȣ</th>
						<td><%= dl.getDmno() %></td>
					</tr>
					<tr>
						<th>��ID</th>
						<td><%= dl.getCustid() %></td>
					</tr>
					<tr>
						<th>����</th>
						<td><%= dl.getAuthor() %></td>
					</tr>
					<tr>
						<th>�߼���</th>
						<td><%= dl.getDate() %></td>
					</tr>
					<tr>
						<th>����</th>
						<td><%= dl.getContents() %></td>
					</tr>
					<tr>
						<th>ķ���� ����</th>
						<td><%= dl.getCampain() %></td>
					</tr>
				</table><br/>
				<input type="submit" value="�߼� ���� �����ϱ�"/>
			</form>
		</div>
	</section>
	<%@ include file="footer.jsp" %>
</body>
</html>