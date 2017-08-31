package com.fortuneforall.pub.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fortuneforall.pub.dao.PubDAO;
import com.fortuneforall.pub.domain.Pub;


@WebServlet("/com.fortuneforall.pub.controller/PubInsertController")
public class PubInsertController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String files = request.getParameter("file");
		System.out.println(title);
		System.out.println(content);
		
		Pub d = new Pub();
		d.setTitle(title);
		d.setWriter("witer");
		d.setContent(content);
		d.setFile("files");
		
		PubDAO dao = new PubDAO();
		dao.insertPub(d);

		request.setAttribute("pub", d);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/Pub/pub.jsp");
		rd.forward(request, response);
	}
}