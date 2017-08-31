package com.fortuneforall.fortunereview.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fortuneforall.fortunereview.dao.FortuneReviewDAO;
import com.fortuneforall.fortunereview.domain.FortuneReview;

@WebServlet("/com.fortuneforall.fortunereview.controller/FortuneReviewInsertController")
public class FortuneReviewInsertController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String file = request.getParameter("file");
		System.out.println(title);
		System.out.println(content);
		
		FortuneReview fr = new FortuneReview();
		fr.setTitle(title);
		fr.setWriter("witer");
		fr.setContent(content);
		
		FortuneReviewDAO dao = new FortuneReviewDAO();
//		dao.insertDrink(d);

		request.setAttribute("fortuneReview", fr);
//		RequestDispatcher rd = request.getRequestDispatcher("/jsp/Drink/drink.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("/com.fortuneforall.fortunereview.controller/FortuneReviewSelectController");
		rd.forward(request, response);
	}
}