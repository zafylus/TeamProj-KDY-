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

import dao.SalesDAO;

@WebServlet("/salesdate")
public class SalesDateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SalesDAO sDao = new SalesDAO();
		JSONArray jarray = new JSONArray(sDao.selectAll());
		System.out.println(jarray);
		ServletContext sc = this.getServletContext();
		sc.setAttribute("sales", jarray);
		System.out.println(sc.getAttribute("sales"));
		response.sendRedirect("sales.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
