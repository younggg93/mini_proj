package com.fortuneforall.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fortuneforall.member.dao.MemberDAO;

@WebServlet("/com.fortuneforall.member.controller/MemberJoinController")
public class MemberJoinController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("userID");
		String pw = request.getParameter("userPassword");
		String name = request.getParameter("userName");
		String email = request.getParameter("userEmail");
		String name = request.getParameter("userName");
		String name = request.getParameter("userName");
		String name = request.getParameter("userName");
		MemberDAO dao = new MemberDAO();
		request.getAttribute(arg0);
		dao.join(user);
	}

}
