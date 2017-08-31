package com.fortuneforall.fortunereview.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fortuneforall.fortunereview.dao.FortuneReviewDAO;


@WebServlet("/com.fortuneforall.fortunereview.controller/FortuneReviewSelectController")
public class FortuneReviewSelectController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FortuneReviewDAO dao = new FortuneReviewDAO();
		System.out.println(dao.selectBoard());
		request.setAttribute("board", dao.selectBoard());
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/FortuneReview/fortuneReview.jsp");
		rd.forward(request, response);
	}
}
