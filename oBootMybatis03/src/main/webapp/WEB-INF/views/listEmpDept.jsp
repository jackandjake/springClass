<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String context = request.getContextPath();
%>
<html>
<head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/httpRequest.js"></script>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>



</head>
<body>
<h2>회원 정보</h2>
<a href="mailTransport">Mail Test</a>

<table>
	<tr><th>사번</th><th>이름</th><th>업무</th>
		<th>부서</th><th>근무지</th></tr>
<c:forEach var="EmpDept" items="${listEmpDept}">
	<tr><td>${EmpDept.empno }</td><td>${EmpDept.ename }</td>
		<td>${EmpDept.job }</td><td>${EmpDept.deptno }</td>
		<td>${EmpDept.loc }</td></tr>
</c:forEach>
</table>


</body>
</html>