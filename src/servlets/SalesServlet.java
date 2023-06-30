package servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import dao.SalesDAO;

@WebServlet("/salesservlet")
public class SalesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SalesDAO sDao = new SalesDAO();
		JSONArray jarray = new JSONArray(sDao.showSalesDate());
		System.out.println(jarray);
		ServletContext sc = this.getServletContext();
		sc.setAttribute("sales", jarray);
		System.out.println(sc.getAttribute("sales"));
		response.sendRedirect("Sales.html");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
