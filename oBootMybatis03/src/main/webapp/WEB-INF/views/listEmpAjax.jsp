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

<script type="text/javascript">
    var contextPath='${pageContext.request.contextPath}';
	var src='${pageContext.request.contextPath}/images/';
	var contextPath='${pageContext.request.contextPath}';
	var i=2;
	var str="";
	var str2="";
	
	/* EmpController */
	function getDeptName(Vdeptno) {
		console.log(Vdeptno);
		// alert("Vdeptno->"+Vdeptno);
		
		$.ajax(
			{
					url:"<%=context%>/getDeptName",
					data:{deptno : Vdeptno},
					dataType:'text',			// 리턴에 관한 것. 객체로 받으면 json
					success:function(data){     // 리턴에 관한 것.
						// alert("success ajax Data"+data);
						$('#deptName').val(data);         /*  input  Tag / #은 id .은 class를 말함  */
						$('#msg').html(data);			  /* span id Tag */ 
					}
			}		
		);
	}
	
	/* RestController TEST */ 
	function getDept(Vdeptno){
		alert("Vdeptno->"+Vdeptno);
		$.ajax({
			url:"<%=context%>/sample/sendVO2",
			data:{deptno : Vdeptno},
			dataType: 'json',  // 객체로 받는 것. 
			success:function(data){
				/* alert(".ajax getDept Data"+data); */
				str = data.firstName + " " + data.lastName + " " + data.mno;  // 넘어온 객체릐 필드명을 각각 조립 가능! 
				alert(".ajax getDept str"+str);
				$('RestDept').val(str);		/* Input Tag */
			}
		 }		
		);
	}

	
	
	
	
	
	
 </script>
</head>
<body>
<h2>회원 정보</h2>
<table>
	<tr><th>사번</th><th>이름</th><th>업무</th><th>부서</th><th>근무지</th></tr>
	<c:forEach var="empDept" items="${listEmp}">
		<tr><td>${empDept.empno }</td><td>${empDept.ename }</td>
			<td>${empDept.job }</td>
			<td>${empDept.deptno} 
			    <input type="button" id="btn_idCheck" value="부서명" onmouseover="getDeptName(${empDept.deptno})">
			</td>
			<td>${empDept.loc }</td>
		</tr>
	</c:forEach>
</table>
	 
	deptName:  <input type="text" id="deptName"  readonly="readonly"><p>
    Message :  <span id="msg"></span><p>

    RestController sendVO2: <input type="text" id="RestDept"       readonly="readonly"><p>
	RestController sendVO2: sendVO2<input type="button" id="btn_Dept"     value="부서명"  onclick="getDept(10)"><p>


</body>
</html>