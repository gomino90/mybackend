<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.pi.login.model.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.pi.login.dao.AdminDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<%@ include file="../layout/adminHeader.jsp"%>


<div id="wrapper">
	<%@ include file="../layout/adminSidebar.jsp"%>

	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span3" id="sidebar"></div>

			<!--/span-->
			<div class="span9" id="content">
				<div class="row-fluid">
					<div class="alert alert-success">
						<button type="button" class="close" data-dismiss="alert">&times;</button>
						<h4>회원리스트</h4>
					</div>


					<div class="container">
						<div class="row">
							<form method="post" name="search" action="/admin/bbs">
								<table class="pull-right">
									<tr>
										<td><select class="form-control" name="searchField">
												<option value="0">선택</option>
												<option value="USER_NAME">이름</option>
												<option value="phone">전화번호</option>
										</select></td>
										<td><input type="text" class="form-control" placeholder="검색어 입력" name="searchText" maxlength="100"></td>
										<td><button type="submit" class="btn btn-success">검색</button></td>
									</tr>

								</table>
							</form>
						</div>
					</div>
				</div>
				<div>
				<!-- <form method="post" action="" name="frm"> -->
					<%-- 	<div class="table-responsive">
							<table class="table">
								<tr class="success">
									<th>번호</th>
									<th>이름</th>
									<th>아이디</th>
									<th>이메일</th>
									<th>전화</th>
									<th>가입일</th>
								</tr>
								<c:if test="${empty principal.user.userId}">
									<tr>
										<td colspan="6" class="text-center">검색된 상품이 없습니다.</td>
									</tr>
								</c:if>

								<tr>
									<td>${principal.user.id}</td>
									<td>${principal.user.username}</td>
									<td>${principal.user.userId}</td>
									<td>${principal.user.email}</td>
									<td>${principal.user.phone}</td>
									<td>${principal.user.createDate}</td>

								</tr>


							</table>
						</div> --%>
					</form>

				</div>


			</div>
		</div>


	</div>
	<hr>

</div>
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="js/bootstrap.js"></script>

<%@include file="../layout/adminFooter.jsp"%>

