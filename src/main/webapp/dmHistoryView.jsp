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
			<form action="updateDmList.do" method="post">
				<table border="1">
					<tr>
						<th>�߼۹�ȣ[���� �Ұ�]</th>
						<td><input type="text" value="<%= dl.getDmno() %>" name="DMNO" readOnly="readOnly"/></td>
					</tr>
					<tr>
						<th>��ID</th>
						<td><input type="text" value="<%= dl.getCustid() %>" name="CUSTID"/></td>
					</tr>
					<tr>
						<th>����</th>
						<td><input type="text" value="<%= dl.getAuthor() %>" name="AUTHOR"/></td>
					</tr>
					<tr>
						<th>�߼���</th>
						<td><input type="text" value="<%= dl.getDate() %>" name="DATE"/></td>
					</tr>
					<tr>
						<th>����</th>
						<td><input type="text" value="<%= dl.getContents() %>" name="CONTENTS"/></td>
					</tr>
					<tr>
						<th>ķ���� ����</th>
						<td><input type="text" value="<%= dl.getCampain() %>" name="CAMPAIN"/></td>
					</tr>
				</table><br/>
				<input type="submit" value="�߼� ���� �����ϱ�"/>
			</form>
		</div>
	</section>
	<%@ include file="footer.jsp" %>
</body>
</html>