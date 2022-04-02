package com.pi.login.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pi.login.dao.AdminDao;

@WebServlet("/DeleteServiceCon")
public class DeleteServiceCon extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// select.jsp에서 email을 가져옴
		String USER_ID =  request.getParameter("USER_ID");
		// dao에서 만든 delete 메소드를 호출해서 사용
		AdminDao dao = new AdminDao();
		int cnt = dao.delete1(USER_ID);
		// delete 성공하면 cnt가 0보다 큼
		// delete 성공/실패 후 select.jsp로 넘어감
		if(cnt>0) {
			response.sendRedirect("/");
		}else {
			response.sendRedirect("/");
			System.out.println("삭제 실패");
		}
	}
}
