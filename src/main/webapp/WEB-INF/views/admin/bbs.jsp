<%@page import="com.pi.login.model.User"%>
<%@page import="com.pi.login.dao.AdminDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter"%>

<%@ page import="java.util.ArrayList"%>

<!DOCTYPE html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width" , initial-scale="1">
<link rel="stylesheet" href="/css/bootstrap.css">
<link rel="stylesheet" href="/css/custom.css">
<title>JSP 게시판 웹 사이트</title>
<style type="text/css">
a, a:hover {
	color: #000000;
	text-decoration: none;
}
</style>
</head>
<div>
<%@ include file="../layout/adminHeader.jsp"%>

<div id="wrapper">
	<%@ include file="../layout/adminSidebar.jsp"%>
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
							<form method="get" name="search" action="/admin/bbs">
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

	<%
		String userID = null;
		if (session.getAttribute("userID") != null) {//주어진 userID에 연결된 속성값을 얻어낸다.
			userID = (String) session.getAttribute("userID");
		}
		//현재 페이지가 몇번째 페이지 인가
		int pageNumber = 1;//기본적으로 1페이지
		if (request.getParameter("pageNumber") != null)
			pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
	%>

	
			<%
				if (userID == null) {//로그인이 되어 있지 않다면
			%>
			
			<%
				} else {//로그인이 되어있다면
			%>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">회원관리<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="logoutAction.jsp">로그아웃</a></li>
						<li><a href="userUpdate.jsp">내 정보</a></li>
					</ul></li>
			</ul>
			<%
				}
			%>
		</div>
	</nav>
	<%
		AdminDao bbs = new AdminDao();
	%>
	
	<br>
	<div class="container">
		<div class="row">
			<table class="active table table-striped"
				style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th >번호</th>
						<th>Id</th>
						<th >username</th>
						<th >email</th>
						<th >phone</th>
						<th >role</th>
						<th >join date</th>
						<th >kakao</th>
					
					</tr>
				</thead>
				<tbody>
					<%
					
						AdminDao bbsDAO = new AdminDao();
						ArrayList<User> list = bbsDAO.getSearch(request.getParameter("searchField"),
								request.getParameter("searchText"));
						if (list.size() == 0) {
							PrintWriter script = response.getWriter();
							script.println("<script>");
							script.println("alert('검색결과가 없습니다.')");
							script.println("history.back()");
							script.println("</script>");
						}
						for (int i = 0; i < list.size(); i++) {
					%>
					<tr>
						<td><%=list.get(i).getId()%></td>
						<%--현재 게시글에 대한 정보 --%>
						
						<td><%=list.get(i).getUserId()%></td>
						<td><%=list.get(i).getUsername()%></td>					
						<td><%=list.get(i).getEmail()%></td>
						<td><%=list.get(i).getPhone()%></td>
						<td><%=list.get(i).getRole()%></td>
						<td><%=list.get(i).getCreateDate()%></td>
						<td><%=list.get(i).getOauth()%></td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
			<div class=container style="text-align: center">
				<%
					if (pageNumber != 1) {//이전페이지로
				%>
				<a href="bbs.jsp?pageNumber=<%=pageNumber - 1%>">◀ 이전</a>
				<%
					}
				%>
				<%
					int n = (int) (bbsDAO.getCount() / 10 + 1);
					for (int i = 1; i <= n; i++) {
				%>
				<a href="bbs.jsp?pageNumber=<%=i%>">|<%=i%>|
				</a>
				<%
					}
				%>
				<%
					if (bbsDAO.nextPage(pageNumber + 1)) {//다음페이지가 존재하는ㄱ ㅏ
				%>
				<a href="bbs.jsp?pageNumber=<%=pageNumber + 1%>">다음 ▶</a>
				<%
					}
				%>
			
			</div>

		</div>
	</div>
	
	<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>

</div>
<%@include file="../layout/adminFooter.jsp"%>
