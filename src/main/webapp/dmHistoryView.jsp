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
						<th>�߼۹�ȣ[���� �Ұ�]</th>
						<td><input type="text" value="<%= dl.getDmno() %>" name="" readOnly="readOnly"/></td>
					</tr>
					<tr>
						<th>��ID</th>
						<td><input type="text" value="<%= dl.getCustid() %>" name=""/></td>
					</tr>
					<tr>
						<th>����</th>
						<td><input type="text" value="<%= dl.getAuthor() %>" name=""/></td>
					</tr>
					<tr>
						<th>�߼���</th>
						<td><input type="text" value="<%= dl.getDate() %>" name=""/></td>
					</tr>
					<tr>
						<th>����</th>
						<td><input type="text" value="<%= dl.getContents() %>" name=""/></td>
					</tr>
					<tr>
						<th>ķ���� ����</th>
						<td><input type="text" value="<%= dl.getCampain() %>" name=""/></td>
					</tr>
				</table><br/>
				<input type="submit" value="�߼� ���� �����ϱ�"/>
			</form>
		</div>
	</section>
	<%@ include file="footer.jsp" %>
</body>
</html>