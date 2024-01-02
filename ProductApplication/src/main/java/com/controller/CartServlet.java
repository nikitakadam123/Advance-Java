package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Product;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*PrintWriter pw=response.getWriter();
		//pw.print("<h1>Hello cart sevlet here...</h1>");
		pw.print("<center><h1>Your Product List</h1></center>");
		HttpSession session=request.getSession(true);
		List<Product> lstProd=(List)session.getAttribute("prod");
		pw.print("<table>");
		{
			for(Product p:lstProd)
			{
				pw.print("<tr><td>"+p.getProdId()+"</td>");
				pw.print("<tr><td>"+p.getProdName()+"</td>");
				pw.print("<tr><td>"+p.getProdPrice()+"</td>");
				pw.print("<tr><td>"+p.getProdQty()+"</td></tr>");
				
				
			}
			pw.print("</table>");*/
		
		
		response.setContentType("text/html");
	     PrintWriter pw = response.getWriter();

	        pw.println("<!DOCTYPE html>");
	        pw.println("<html lang='en'>");
	        pw.println("<head>");
	        pw.println("    <meta charset='UTF-8'>");
	        pw.println("    <meta name='viewport' content='width=device-width, initial-scale=1.0'>");
	        pw.println("    <title>Product List</title>");
	        pw.println("    <link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css'>");
	        pw.println("    <style>");
	        pw.println("        body {");
	        pw.println("            font-family: Arial, sans-serif;");
	        pw.println("            background-color: #f4f4f4;");
	        pw.println("            padding: 20px;");
	        pw.println("        }");
	        pw.println("        h1 {");
	        pw.println("            color: #333;");
	        pw.println("        }");
	        pw.println("        table {");
	        pw.println("            width: 100%;");
	        pw.println("            border-collapse: collapse;");
	        pw.println("            margin-top: 20px;");
	        pw.println("        }");
	        pw.println("        th, td {");
	        pw.println("            border: 1px solid #ddd;");
	        pw.println("            padding: 8px;");
	        pw.println("            text-align: left;");
	        pw.println("        }");
	        pw.println("    </style>");
	        pw.println("</head>");
	        pw.println("<body>");
	        pw.println("    <div class='container'>");
	        pw.println("        <h1 class='display-4'>Product List</h1>");

	        HttpSession session = request.getSession(true);
	        List<Product> lstProd = (List<Product>) session.getAttribute("prod");

	        if (lstProd != null && !lstProd.isEmpty()) {
	            pw.println("        <table class='table table-striped'>");
	            pw.println("            <thead>");
	            pw.println("                <tr>");
	            pw.println("                    <th scope='col'>Product ID</th>");
	            pw.println("                    <th scope='col'>Product Name</th>");
	            pw.println("                    <th scope='col'>Product Price</th>");
	            pw.println("                    <th scope='col'>Product Quantity</th>");
	            pw.println("                </tr>");
	            pw.println("            </thead>");
	            pw.println("            <tbody>");

	            for (Product p : lstProd) {
	                pw.println("                <tr>");
	                pw.println("                    <td>" + p.getProdId() + "</td>");
	                pw.println("                    <td>" + p.getProdName() + "</td>");
	                pw.println("                    <td>" + p.getProdPrice() + "</td>");
	                pw.println("                    <td>" + p.getProdQty() + "</td>");
	                pw.println("                </tr>");
	            }

	            pw.println("            </tbody>");
	            pw.println("        </table>");
	        } else {
	            pw.println("        <p>No products available.</p>");
	        }

	        pw.println("    </div>");
	        pw.println("</body>");
	        pw.println("</html>");
			
			//pw.print("<h1>Click here for bill</h1>");
			//pw.print("<a href='BillServlet'>Yes</a>");
	        
	        response.setContentType("text/html");
	         

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
	        pw.println("        <h1 class='display-4'>Click here for bill.</h1>");
	        pw.println("        <a class='btn btn-primary btn-lg mt-3' href='BillServlet'>Yes</a>");
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
