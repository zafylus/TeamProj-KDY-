package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import services.PosService;

@WebServlet("/pos_product")
public class PosProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PosService pps = new PosService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONArray jarray = pps.productList();
		System.out.println(jarray);
		request.setAttribute("plist", jarray);
		request.getRequestDispatcher("test.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
