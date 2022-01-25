<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String context = request.getContextPath();
    System.out.println("context->"+context);
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

	

	/* RestController TEST */
	/* http://jsonviewer.stack.hu/ */

	function getListDept(){
		var str="";
		var str2="";
		
		console.log("getListDept Run");
		alert("getListDept Run...");
		$.ajax(
			{
				url:"<%=context%>/sendVO3",
				dataType: 'json',
				success:function(data){
					var jsondata = JSON.stringify(data);
					alert("jsondata->"+jsondata);
					$('#Dept_list').append(jsondata);
					str += "<select name='dept'>";	
					$(data).each(  // 로우별로 each 각각 for 문이 돌아감 
							function(){
							 // str2 = " " + this.deptno + "' " + this.dname + "<br>";
								str2 = "<option value='"+this.deptno + "'> "+this.dname + "</option> ";
								str += str2 ;
							}
					);
					str += "</select><p>"
					$('#Dept_list3').append(str);
					
					
				}
				
				
			}
		 );
	}	
	
	//function getDeptDelete(Vindex){
	//	console.log(Vindex);
	//	alert("empDept->"+Vindex);
	//	var selEname = $("#ename"+Vindex).val();
	//	alert("selEname->"+selEname);
		// Ajax로 empnoDelete
		// 성공하면 $('#empDept'+Vindex).remove(); 수행 
	//	$('#empDept'+Vindex).remove();		/* Delete Tag(논리적으로)*/
	// }
	
	
	
	function getDeptDelete(Vindex){
		console.log(Vindex);
		alert("empDept->"+Vindex);
		var selEname = $("#ename"+Vindex).val();
		var selEmpno = $("#empno"+Vindex).val();
		alert("selEmpno->"+selEmpno);
		//Ajax로 empnoDelete
	    $.ajax(
	      {
	    	 	url:"<%=context%>/empnoDelete",
	    	 	data:{empno : selEmpno , ename : selEname},
	    	 	dataType:'text',
	    	 	success:function(data){
	    	 		alert(".ajax getDeptDelete data->"+data);
	    	 		if (data == '1') {
	    	 			// 성공하면 아래라인 수행
	    	 			$('#empDept'+Vindex).remove();		/* Delete Tag */
	    	 		}
	    	 	}
	      }
	     );
		
	
	
	}
	
	
</script>
</head>
<body>
<h2>회원 정보</h2>
<table>
	<tr><th>번호</th><th>사번</th><th>이름</th><th>업무</th><th>부서</th><th>근무지</th></tr>
<c:forEach var="empDept" items="${listEmp}" varStatus="status">
	<tr id="empDept${status.index}"><td>empDept${status.index}</td>	
		<td><input type="text" id="empno${status.index}" value="${empDept.empno }">${empDept.empno }</td>
		<td><input type="text" id="ename${status.index}" value="${empDept.ename }">${empDept.ename }</td>
		<td>${empDept.job }</td><td>${empDept.deptno } 
		    <input type="button" id="btn_idCheck2" value="부서Row Delete" onclick="getDeptDelete(${status.index})">
		</td>
		<td>${empDept.loc }</td>
	</tr>
</c:forEach>
</table>
	 
	deptName:  <input type="text" id="deptName"  readonly="readonly"><p>
    Message :  <span id="msg"></span><p>

    RestController RestDept1 sendVO2: <input type="text" id="RestDept1"       readonly="readonly"><p>
    RestController RestDept2 sendVO2: <input type="text" id="RestDept2"       readonly="readonly"><p>
	

    <!--  RestController LISTVO3: <input type="text" id="RestDeptList"   readonly="readonly"><p> -->
	RestController LISTVO3: <input type="button" id="btn_Dept3"     value="부서명 LIST"  onclick="getListDept()"><p>
	                        <span id="RestDeptList"></span><p>
	                        			<div id="board_reply">
	Dept_list:	<div id="Dept_list"></div>

	Dept_list3:
	<div id="Dept_list3">

	</div>
</body>
</html>