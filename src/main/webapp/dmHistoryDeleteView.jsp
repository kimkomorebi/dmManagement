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
			<form action="deleteDmList.do" method="post">
				<input type="hidden" value="<%= dl.getDmno() %>" name="DMNO"/>
				<input type="hidden" value="<%= dl.getCustid() %>" name="CUSTID"/>
				<table border="1">
					<tr>
						<th>발송번호</th>
						<td><%= dl.getDmno() %></td>
					</tr>
					<tr>
						<th>고객ID</th>
						<td><%= dl.getCustid() %></td>
					</tr>
					<tr>
						<th>고객명</th>
						<td><%= dl.getAuthor() %></td>
					</tr>
					<tr>
						<th>발송일</th>
						<td><%= dl.getDate() %></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><%= dl.getContents() %></td>
					</tr>
					<tr>
						<th>캠페인 구분</th>
						<td><%= dl.getCampain() %></td>
					</tr>
				</table><br/>
				<input type="submit" value="발송 내역 삭제하기"/>
			</form>
		</div>
	</section>
	<%@ include file="footer.jsp" %>
</body>
</html>