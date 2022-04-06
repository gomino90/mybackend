<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<%@ include file="../layout/header.jsp"%>

<div class="container">

	<form>
		<div class="form-group">
			<label for="username">Username:</label> <input type="text" class="form-control" placeholder="Enter Username" id="username">
		</div>
		<div class="form-group">
			<label for="UI">UserId:</label> <input type="text" class="form-control" placeholder="Enter UI" id="userId">
		</div>


		<div class="form-group">
			<label for="password">Password:</label> <input type="password" class="form-control" placeholder="Enter password" id="password">
		</div>
		<div class="form-group">
			<label for="email">Email:</label> <input type="email" class="form-control" placeholder="Enter email" id="email">
		</div>
		<div class="form-group">
			<label for="phone">Phone:</label> <input type="text" class="form-control" placeholder="Enter PhoneNumber" id="phone">
		</div>
		
		<input type="radio" name="role" id="role2" value="FACADMIN"> FACADMIN 
		<!-- <input type="radio" name="role" id="ro1e1" value="FACADMIN"> FACADMIN <br>
		 -->
	</form>
	<button id="btn-save" class="btn btn-primary">등록완료</button>


</div>
<script src="/js/user.js"></script>
<%@include file="../layout/footer.jsp"%>



