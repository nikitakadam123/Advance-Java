package com.contoller;

import java.io.IOException;
import java.util.LinkedList;
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
 * Servlet implementation class BillServlet
 */
@WebServlet("/BillServlet")
public class BillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	 
    public BillServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session=request.getSession(true);
		List<Product> lstProd=(List)session.getAttribute("prod");
		float total=0,finaltotal=0,cgst=0,sgst=0;
		for(Product p:lstProd)
		{
			total=total+p.getProdPrice()*p.getProdQty();
			
		}
		cgst=total*0.06f;
		sgst=total*0.06f;
		finaltotal=total+cgst+sgst;
		Bill bill=new Bill(111,total,cgst,sgst,finaltotal);
		session.setAttribute("bill", bill);
		response.sendRedirect("DisplayServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
