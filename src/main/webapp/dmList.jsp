<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*, model.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		ArrayList<DmList> list = (ArrayList<DmList>)request.getAttribute("LIST");
	%>
	<%@ include file="header.jsp" %>
	<section>
		<div align="center">
				<table border="1">
					<tr>
						<th>�߼۹�ȣ</th>
						<th>��ID</th>
						<th>����</th>
						<th>�߼���</th>
						<th>����</th>
						<th>ķ���α���</th>
						<th>���</th>
					</tr>
					<%
						for(DmList l : list){
					%>
					<form action="">
						<tr>
							<td><%= l.getDmno() %></td>
							<td><%= l.getCustid() %></td>
							<td><%= l.getAuthor() %></td>
							<td><%= l.getDate() %></td>
							<td><%= l.getContents() %></td>
							<td><%= l.getCampain() %></td>
							<td>
								<input type="submit" value="����" name="BTN"/>
								<input type="submit" value="����" name="BTN"/>
							</td>
						</tr>
					</form>
					<%
						}
					%>
					<tr>
						<td colspan="7" align="center">
							<input type="button" value="�� ���� ���" onClick="customer()"/>
							<input type="button" value="DM �߼� ���� ���" onClick="sendDm()"/>
						</td>
					</tr>
				</table>
		</div>
	</section>
	<%@ include file="footer.jsp" %>
	<script type="text/javascript">
		function customer(){
			location.href="custInfoRegister.jsp";
		}
	</script>
</body>
</html>