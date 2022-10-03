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
		ArrayList<DmList> area = (ArrayList<DmList>)request.getAttribute("AREA");
	%>
	<%@ include file="header.jsp" %>
	<section>
		<div align="center">
				<table border="1">
					<tr>
						<th>발송번호</th>
						<th>고객ID</th>
						<th>고객명</th>
						<th>발송일</th>
						<th>내용</th>
						<th>캠페인구분</th>
						<th>비고</th>
					</tr>
					<%
						for(DmList l : list){
					%>
					<form action="DmHistoryUpdateDeleteView" method="post">
						<input type="hidden" value="<%= l.getDmno() %>" name="DMNO"/>
						<tr>
							<td><%= l.getDmno() %></td>
							<td><%= l.getCustid() %></td>
							<td><%= l.getAuthor() %></td>
							<td><%= l.getDate() %></td>
							<td><%= l.getContents() %></td>
							<td><%= l.getCampain() %></td>
							<td>
								<input type="submit" value="수정" name="BTN"/>
								<input type="submit" value="삭제" name="BTN"/>
							</td>
						</tr>
					</form>
					<%
						}
					%>
					<tr>
						<td colspan="7" align="center">
							<input type="button" value="고객 정보 등록" onClick="customer()"/>
							<input type="button" value="DM 발송 정보 등록" onClick="sendDmListRegister()"/>
						</td>
					</tr>
				</table><br/>
				<table border="1">
					<%
						for(DmList a : area){
					%>
						<tr>
							<th><%= a.getArea() %></th>
							<td><%= a.getAreaCount() %></td>
						</tr>
					<%	
						}
					%>
				</table>
		</div>
	</section>
	<%@ include file="footer.jsp" %>
	<script type="text/javascript">
		function customer(){
			location.href="custInfoRegister.jsp";
		}
		function sendDmListRegister(){
			location.href="dmDeptSelect.do";
		}
	</script>
</body>
</html>