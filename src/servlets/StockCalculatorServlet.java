package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import dto.RecipeDTO;
import service.Service_st;

@WebServlet("/stockCalc")
public class StockCalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		Service_st st_serv = new Service_st();
		List<RecipeDTO> rlist = st_serv.getRecipeList();
		
		request.setAttribute("rlist", rlist);
		request.getRequestDispatcher("stock/stock.jsp?req=calc").forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String[] pr_name = request.getParameterValues("products");
		String priority = request.getParameter("priority");
		System.out.println(pr_name);
		PrintWriter out = response.getWriter();
		if (pr_name != null) {
			for (int i = 0; i < pr_name.length; i++) {
				out.print(pr_name[i]);
			}
		}
		out.print(priority);
	}
}
