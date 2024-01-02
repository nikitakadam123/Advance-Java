package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Bill;
import com.model.Product;

/**
 * Servlet implementation class DisplayServlet
 */
@WebServlet("/DisplayServlet")
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		PrintWriter pw=response.getWriter();
		HttpSession session=request.getSession(true);
		List<Product> lstProd=(List)session.getAttribute("prod");
		/*pw.print("<table border='4' bgcolor='blue'>");
		for(Product p:lstProd)
		{
			pw.print("<tr><td>"+p.getProdId()+"</td>");
			pw.print("<tr><td>"+p.getProdName()+"</td>");
			pw.print("<tr><td>"+p.getProdPrice()+"</td>");
			pw.print("<tr><td>"+p.getProdQty()+"</td></tr>");
		}
		pw.print("</table>");
		Bill bill=(Bill)session.getAttribute("bill");
		pw.print("<h1>----------------FINAL BILL------------------------</h1>");
		pw.print("<h3>Bill No: "+bill.getBillNo()+"</h3>");
		pw.print("<h3>Bill Date: "+new Date().getDate()+"</h3>");
		pw.print("<h3>Bill Total: "+bill.getTotal()+"</h3>");
		pw.print("<h3>Bill CGST: "+bill.getCgst()+"</h3>");
		pw.print("<h3>Bill SGST: "+bill.getSgst()+"</h3>");
		pw.print("<h3>Bill FINAL: "+bill.getFinaltotal()+"</h3>");
		pw.print("<h1>----------------Thank You -----------------------</h1>");*/
		
		
		response.setContentType("text/html");
        //PrintWriter pw = response.getWriter();

        pw.println("<!DOCTYPE html>");
        pw.println("<html lang='en'>");
        pw.println("<head>");
        pw.println("    <meta charset='UTF-8'>");
        pw.println("    <meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        pw.println("    <title>Final Bill</title>");
        pw.println("    <link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css'>");
        pw.println("    <style>");
        pw.println("        body {");
        pw.println("            font-family: Arial, sans-serif;");
        pw.println("            background-color: #f4f4f4;");
        pw.println("            padding: 20px;");
        pw.println("        }");
        pw.println("        h1, h3 {");
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

        //HttpSession session = request.getSession(true);
        //List<Product> lstProd = (List<Product>) session.getAttribute("prod");

        
        pw.println("<h1 class='display-4 mt-4'>Your Final Product List is: </h1>");
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

            Bill bill = (Bill) session.getAttribute("bill");
            pw.println("        <h1 class='display-4 mt-4'>-----------------FINAL BILL----------------</h1>");
            pw.println("        <h3>Bill no: " + bill.getBillNo() + "</h3>");
            pw.println("        <h3>Bill Date: " + new Date().getDate() + "</h3>");
            pw.println("        <h3>Bill Total: " + bill.getTotal() + "</h3>");
            pw.println("        <h3>Bill CGST: " + bill.getCgst() + "</h3>");
            pw.println("        <h3>Bill SGST: " + bill.getSgst() + "</h3>");
            pw.println("        <h3>Bill FINAL: " + bill.getFinaltotal() + "</h3>");
            pw.println("        <h1 class='display-4 mt-4'>----------------THANK YOU----------------</h1>");
        } else {
            pw.println("        <p>No products available.</p>");
        }

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
