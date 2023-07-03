package servlets;

import java.io.IOException;

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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		SalesModel sm = new SalesModel();
		JSONArray jarray = sm.parseList();
		ServletContext sc = this.getServletContext();
		sc.setAttribute("sales", jarray);
		System.out.println("SalesServlet : " + sc.getAttribute("sales"));
		response.sendRedirect("sales.jsp");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
