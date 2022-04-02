<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>


<title>Insert title here</title>
</head>
<body>
	<%@ include file="../layout/adminHeader.jsp"%>


	<div id="wrapper">
		<%@ include file="../layout/adminSidebar.jsp"%>

		<div class="container">
			<div>
				<form>
					<input type="hidden" id="id" value="${principal.user.password}" />

					<c:if test="${empty principal.user.oauth}">

						<div class="form-group">
							<label for="password">현재 비밀번호</label> <input type="password" class="form-control " placeholder="Enter password" id="pwd">
						</div>
						<div class="form-group">
							<label for="password">변경할 비밀번호</label> <input type="password" class="form-control" placeholder="Enter password" id="npwd">
						</div>
						<div class="form-group">
							<label for="password">비밀번호 확인</label> <input type="password" class="form-control" placeholder="Enter password" id="fpwd">
						</div>

					</c:if>
				</form>
		
			</div>

			<button id="updatePwdButton" class="btn btn-primary" value="완료">비밀번호 변경</button>
		</div>

	</div>
		<script>
			$('.form-control').keyup(function(){
			    let npwd = $("#npwd").val();
			    let fpwd = $("#fpwd").val();
			    
			    if(npwd !=""|| fpwd !=""){
			    	if(npwd == fpwd){
			    		$("checkpwd").html('일치');
			    		$("checkpwd").attr('color','green');
			    		
			    	}else{
			    		$("checkpwd").html('불일치');
			    		$("checkpwd").attr('color','red');
			    	}
			    }
			    });
 
							
			</script> 

	<script src="/js/admin.js"></script>
	<script src="/js/ajaxlib.js"></script>
	<%@include file="../layout/adminFooter.jsp"%>
</body>
</html>