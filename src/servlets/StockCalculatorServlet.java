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
import services.Service_st;
import util.StockCalculator;

@WebServlet("/stock-c")
public class StockCalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		Service_st st_serv = new Service_st();
		List<RecipeDTO> rlist = st_serv.getRecipeList();
		
		request.setAttribute("rlist", rlist);
		request.setAttribute("page", "stockCalc.jsp");
		request.getRequestDispatcher("stock/stock.jsp").forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		String[] products = request.getParameterValues("products");
		
		JSONObject jobj = StockCalculator.getCalc(products);
		
		out.print(jobj);
	}
}
