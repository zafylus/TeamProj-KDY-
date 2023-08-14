package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReceiptDAO;
import dto.ReceiptSales;

@WebServlet("/receipt")
public class receipt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReceiptDAO dao = new ReceiptDAO();
		List<ReceiptSales> rslist = dao.getSales();
		System.out.println(rslist);
		
		String a = request.getParameter("a");
		System.out.println("a : " + a);
		System.out.println("request : " + request);
		request.setAttribute("rslist", rslist);
		System.out.println(request.getRequestDispatcher("../jsp/receipt.jsp"));
		request.getRequestDispatcher("jsp/receipt.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
