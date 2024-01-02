package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Product;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	List<Product> lstproduct;
	public void init()
	{
		lstproduct=new LinkedList<Product>();
	}
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int prodId=Integer.parseInt(request.getParameter("prodId"));
		String prodName=request.getParameter("prodName");
		float prodPrice= Float.parseFloat(request.getParameter("prodPrice"));
		int prodQty=Integer.parseInt(request.getParameter("prodQty"));
		
		PrintWriter pw=response.getWriter();
		
		Product prod = new Product(prodId,prodName,prodPrice,prodQty);
		lstproduct.add(prod);
		
		HttpSession session=request.getSession();
		session.setAttribute("prod", lstproduct);    //key and object
		
		pw.print("<h1>Do you want to continue yes or no? </h1><br/>");
		pw.print("<a href='Product.jsp'>Yes</a>");
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
