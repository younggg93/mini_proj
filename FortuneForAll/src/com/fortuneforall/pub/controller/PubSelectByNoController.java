package com.fortuneforall.pub.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/com.fortuneforall.pub.controller/PubController")
public class PubSelectByNoController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		System.out.println(title);
		request.setAttribute("title", title);

		RequestDispatcher rd = request.getRequestDispatcher("/html/Pub/pub.jsp");
		rd.forward(request, response);
	}
}
