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
			alert("DM �߼� ���� ��� ����!");
		</script>
	<%
		}else if(result.equals("N")){
	%>
		<script type="text/javascript">
			alert("DM �߼� ���� ��Ͽ� �����Ͽ����ϴ�. �����ڿ��� ������ �ּ���.");
		</script>
	<%
		}
	%>
	<script type="text/javascript">
		location.href= "searchDmList.do";
	</script>
</body>
</html>