package com.fortuneforall.drink.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fortuneforall.drink.dao.DrinkDAO;
import com.fortuneforall.drink.domain.Drink;

@WebServlet("/com.fortuneforall.drink.controller/DrinkInsertController")
public class DrinkInsertController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String file = request.getParameter("file");
		
		Drink d = new Drink();
		d.setTitle(title);
		d.setWriter("witer");
		d.setContent(content);
		d.setFiles(file);
		
		DrinkDAO dao = new DrinkDAO();
		dao.insertDrink(d);

		request.setAttribute("drink", d);
//		RequestDispatcher rd = request.getRequestDispatcher("/jsp/Drink/drink.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("/com.fortuneforall.drink.controller/DrinkSelectController");
		rd.forward(request, response);
	}
}