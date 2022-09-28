<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*" %>
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
		<%
			ArrayList<String> list = (ArrayList<String>)request.getAttribute("LIST");
			//String max = (String)request.getAttribute("MAX");
			String max = request.getParameter("MAX");
			ArrayList<String> grade = (ArrayList<String>)request.getAttribute("GRADE");
			ArrayList<String> campain = (ArrayList<String>)request.getAttribute("CAMPAIN");
		
		%>
		<form action="dmListRegister.do" method="post">
			<table border="1">
				<tr>
					<th>DM �߼� ��ȣ[�ڵ� ����]</th>
					<td><input type="text" name="DMNO" value="<%= max %>" readOnly="readOnly"/></td>
				</tr>
				<tr>
					<th>�� ID</th>
					<td><input type="text" name="CUSTID"/></td>
				</tr>
				<tr>
					<th>�߼� ����</th>
					<td><input type="text" name="MAILDATE"/></td>
				</tr>
				<tr>
					<th>DM ����</th>
					<td><input type="text" name="CONTENTS"/></td>
				</tr>
				<tr>
					<th>�߼� �μ�</th>
					<td>
						<select name="DEPT">
						<%
							for(String l : list){
						%>
							<option><%= l %></option>
						<%
							}
						%>
						</select>
					</td>
				</tr>
				<tr>
					<th>�� ���</th>
					<td>
						<select name="GRADE">
							<%
								for(String g : grade){
							%>
								<option><%= g %></option>
							<%
								}
							%>
						</select>
					</td>
				</tr>
				<tr>
					<th>ķ���� ����</th>
					<td>
						<select name="CAMPAIN">
							<%
								for(String c : campain){
							%>
								<option><%= c %></option>								
							<%
								}
							%>
						</select>
					</td>
				</tr>
			</table><br/>
			<div align="center">
				<input type="submit" value="DM �߼� ���� ���"/>
			</div>
		</form>
		</div>
	</section>
	<%@ include file="footer.jsp" %>
</body>
</html>