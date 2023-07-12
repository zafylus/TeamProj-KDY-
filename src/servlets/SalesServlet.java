package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import services.SalesModel;

@WebServlet("/sales")
public class SalesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SalesModel sm = new SalesModel();
	private ServletContext sc = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONArray jarray = sm.salesToJSON();
		System.out.println(jarray);
		sc = this.getServletContext();
		sc.setAttribute("sales", jarray);
		sc.setAttribute("monthTotal", sm.monthSalesNow());
		response.sendRedirect("sales.jsp");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String date = request.getParameter("date");
		sc = this.getServletContext();
		int sales = sm.monthSales(date);
		
		PrintWriter out = response.getWriter();
		out.print(sales);
	}

}
