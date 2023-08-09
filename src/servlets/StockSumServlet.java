package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.Service_st;
import util.OptionCheck;
import vos.TotalStockVO;

@WebServlet("/stock-t")
public class StockSumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		Service_st st_serv = new Service_st();
		boolean alOpt = st_serv.getStockOption().isAlramOpt();
		int alNum = OptionCheck.alramStockNum();
		ArrayList<TotalStockVO> aList = st_serv.getTotalList();
		
		request.setAttribute("alNum", alNum);
		request.setAttribute("alOpt", alOpt);
		request.setAttribute("alist", aList);
		request.setAttribute("page", "stockSum.jsp");
		request.getRequestDispatcher("stock/stock.jsp").forward(request, response);
	}
}
