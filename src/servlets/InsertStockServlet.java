package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Service_st;

@WebServlet("/insertStock")
public class InsertStockServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		request.getRequestDispatcher("stock/stock.jsp?req=reg").forward(request, response);;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String ma_code = request.getParameter("ma_code");
		String st_ea_str = request.getParameter("st_ea");
		int st_ea = Integer.parseInt(st_ea_str);
		String st_note = request.getParameter("note");
		Service_st st = new Service_st();
		
		st.insertStock(ma_code, st_ea, st_note);
		
		response.sendRedirect("stockList");
	}
}
