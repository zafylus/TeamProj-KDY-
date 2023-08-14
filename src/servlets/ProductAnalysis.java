package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/productAnalysis")
public class ProductAnalysis extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("salePageMove Start...2");
		String page = request.getParameter("page");
		System.out.println(page);
		request.setAttribute("uri", "productAnalysis.jsp");
		request.getRequestDispatcher("sales/sales.jsp").forward(request, response);
	}

}
