<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<%@ include file="../layout/adminHeader.jsp"%>


	<div id="wrapper">
	<%@ include file="../layout/adminSidebar.jsp"%>

	<div class="container">
		<div>
			<form>
				<input type="hidden" id="id" value="${principal.user.id}" />
				<div class="form-group">
					<label for="username">Username</label> <input type="text" value="${principal.user.username}" class="form-control" placeholder="Enter Username" id="username" readonly>
				</div>

				<c:if test="${empty principal.user.oauth}">
					<div class="form-group">
						<label for="userId">userId</label> <input type="text" value="${principal.user.userId}" class="form-control" placeholder="Enter userId" id="userId">
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
				</c:if>
			</form>
		</div>
		<button id="btn-update" class="btn btn-primary">UserDetail</button>
	</div>

</div>

<script src="/js/admin.js"></script>
<%@include file="../layout/adminFooter.jsp"%>

