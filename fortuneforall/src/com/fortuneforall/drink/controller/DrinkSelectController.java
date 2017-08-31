package com.fortuneforall.drink.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fortuneforall.drink.dao.DrinkDAO;

@WebServlet("/com.fortuneforall.drink.controller/DrinkSelectController")
public class DrinkSelectController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DrinkDAO dao = new DrinkDAO();
		System.out.println(dao.selectBoard());
		request.setAttribute("board", dao.selectBoard());
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/Drink/drink.jsp");
		rd.forward(request, response);
	}
}
