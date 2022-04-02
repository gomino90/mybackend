<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<%@ include file="../layout/header.jsp"%>

<div class="container">

	<form>
		<input type="hidden" id="id" value="${principal.user.id}" />
		<div class="form-group">
			<label for="username">Username</label> <input type="text" value="${principal.user.username}" class="form-control" placeholder="Enter Username" id="username" readonly>
		</div>

		<c:if test="${empty principal.user.oauth}">
		<div class="form-group">
				<label for="userId">userId</label> <input type="text"value="${principal.user.userId}" class="form-control" placeholder="Enter userId" id="userId">
			</div>
			<div class="form-group">
				<label for="password">Password</label> <input type="password" class="form-control" placeholder="Enter password" id="password">
			</div>
			<div class="form-group">
				<label for="phone">phone</label> <input type="text" value="${principal.user.phone}" class="form-control" placeholder="Enter phone" id="phone">
			</div>

			<div class="form-group">
				<label for="email">Email</label> <input type="email" value="${principal.user.email}" class="form-control" placeholder="Enter email" id="email">
			</div>
			<div class="form-group">
				<label for="email">Email</label> <input type="email" value="${principal.user.role}" class="form-control" placeholder="Enter email" id="role" readonly>
			</div>

		</c:if>





	</form>
	<button id="btn-update" class="btn btn-primary">UserDetail</button>


</div>
<script src="/js/user.js"></script>
<%@include file="../layout/footer.jsp"%>



