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
							<form method="put" name="search" action="/admin/bbs">
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
				<table>
						<tr>
							<td>Name &nbsp;&nbsp;</td>
							<td>Phone</td>
							<td>Address</td>
							<td>삭제하기&nbsp;&nbsp;</td>
							<td>수정하기</td>
						</tr>

						<%
						Connection conn = null;
						PreparedStatement psmt = null;
						ResultSet rs = null;
						// db연결
						try {
							Class.forName("com.mysql.cj.jdbc.Driver");
							String url = "jdbc:mysql://localhost:3306/PI?serverTimezone=Asia/Seoul";
							String dbid = "root";
							String dbpw = "1234";
							conn = DriverManager.getConnection(url, dbid, dbpw);
							// sql준비 및 실행
							String sql = "select * from pi.user";
							psmt = conn.prepareStatement(sql);

							rs = psmt.executeQuery();
							// 반복문 안에서 rs 객체의 요소들을 tr 태그에 넣기

							while (rs.next()) {
								String USER_NAME = rs.getString(8);
								String USER_TELNO = rs.getString(6);
								String USER_EML = rs.getString(3);

								out.print("<tr>");
								out.print("<td>" + USER_NAME + "&nbsp;&nbsp;</td>");
								out.print("<td>" + USER_TELNO + "&nbsp;&nbsp;</td>");
								out.print("<td>" + USER_EML + "&nbsp;&nbsp;</td>");
								/* 회원정보를 삭제할 수 있도록 해줌 */
								/* querystring으로 보내줌 */
								out.print("<td><a href='DeleteServiceCon?USER_NAME=" + USER_NAME + "'>&nbsp;&nbsp;삭제</a></td>");
								out.print("<td><a href='DeleteServiceCon?USER_NAME=" + USER_NAME + "'>&nbsp;&nbsp;수정</a></td>");
								out.print("</tr>");
							}
						} catch (Exception e) {
							e.printStackTrace();
							// db연결 해제
						} finally {
							try {
								if (rs != null)
							rs.close();
								if (psmt != null)
							psmt.close();
								if (conn != null)
							conn.close();
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
						%>
					</table>
				</div>
			</div>
		</div>
	</div>
	<hr>

</div>
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="js/bootstrap.js"></script>

<%@include file="../layout/adminFooter.jsp"%>

