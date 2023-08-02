package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Service_st;
import util.OptionCheck;

@WebServlet("/StockOption")
public class StockOptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		OptionCheck optCheck = new OptionCheck();
		String alOpt = optCheck.alramStockCheck();
		int alNum = optCheck.alramStockNum();
		
		request.setAttribute("alNum", alNum);
		request.setAttribute("alOpt", alOpt);
		request.getRequestDispatcher("stock/stock.jsp?req=opt").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String alramOpt = request.getParameter("alramStock");
		String alramNum_str = request.getParameter("alramNum");
		int alramNum = 0;
		if(alramNum_str != null)
			alramNum = Integer.parseInt(alramNum_str);
		
		OptionCheck optCheck = new OptionCheck();
		Service_st serv_st = new Service_st();
		
		boolean result = optCheck.alramParamCheck(alramOpt);
		serv_st.setStockOption(result, alramNum);
		
		doGet(request, response);
	}

}
