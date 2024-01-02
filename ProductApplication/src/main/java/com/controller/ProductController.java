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
 * Servlet implementation class ProductController
 */
@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	List<Product>prodList=null;
	public void init()
	{
		prodList=new LinkedList<Product>();
	}
    public ProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter pw=response.getWriter();
		int prodId=Integer.parseInt(request.getParameter("prodId"));
		String prodName=request.getParameter("prodName");
		float prodPrice=Float.parseFloat(request.getParameter("prodPrice"));
		int prodQty=Integer.parseInt(request.getParameter("prodQty"));
		
		Product prod=new Product(prodId, prodName, prodPrice, prodQty);
		prodList.add(prod);
		HttpSession session=request.getSession(true);
		session.setAttribute("prod", prodList);
		//pw.print("<h1>do you want to add more product in cart</h1>");
		//pw.print("<a href='Product.html'>Yes</a>");
		//pw.print("<h1>To Confirm Product Click yes</h1>");
		//pw.print("<a href='CartServlet'>Yes</a>");
		
		response.setContentType("text/html");
        //PrintWriter pw = response.getWriter();

        pw.println("<!DOCTYPE html>");
        pw.println("<html lang='en'>");
        pw.println("<head>");
        pw.println("    <meta charset='UTF-8'>");
        pw.println("    <meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        pw.println("    <title>Add Product to Cart</title>");
        pw.println("    <link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css'>");
        pw.println("</head>");
        pw.println("<body class='bg-light text-center'>");
        pw.println("    <div class='container mt-5'>");
        pw.println("        <h1 class='display-4'>Do you want to add more products to the cart?</h1>");
        pw.println("        <a class='btn btn-primary btn-lg mt-3' href='Product.html'>Yes</a>");
        pw.println("    </div>");
        pw.println("</body>");
        pw.println("</html>");
        
        response.setContentType("text/html");
        //PrintWriter pw = response.getWriter();

        pw.println("<!DOCTYPE html>");
        pw.println("<html lang='en'>");
        pw.println("<head>");
        pw.println("    <meta charset='UTF-8'>");
        pw.println("    <meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        pw.println("    <title>Add Product to Cart</title>");
        pw.println("    <link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css'>");
        pw.println("</head>");
        pw.println("<body class='bg-light text-center'>");
        pw.println("    <div class='container mt-5'>");
        pw.println("        <h1 class='display-4'>To Confirm Product Click yes</h1>");
        pw.println("        <a class='btn btn-primary btn-lg mt-3' href='CartServlet'>Yes</a>");
        pw.println("    </div>");
        pw.println("</body>");
        pw.println("</html>");
        
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
