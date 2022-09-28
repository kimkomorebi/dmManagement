<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		String result = request.getParameter("R");
		if(result.equals("Y")){
	%>
		<script type="text/javascript">
			alert("DM 발송 내역 등록 성공!");
		</script>
	<%
		}else if(result.equals("N")){
	%>
		<script type="text/javascript">
			alert("DM 발송 내역 등록에 실패하였습니다. 관리자에게 문의해 주세요.");
		</script>
	<%
		}
	%>
	<script type="text/javascript">
		location.href= "searchDmList.do";
	</script>
</body>
</html>