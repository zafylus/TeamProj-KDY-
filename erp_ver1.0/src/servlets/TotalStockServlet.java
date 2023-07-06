package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stock.Service_st;
import vo.TotalStockVO;

@WebServlet("/totalstock")
public class TotalStockServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service_st st_serv = new Service_st();
		ArrayList<TotalStockVO> aList = st_serv.getTotalList();
		request.setAttribute("alist", aList);
		request.getRequestDispatcher("stock/stock.jsp?req=total").forward(request, response);
	}

}
