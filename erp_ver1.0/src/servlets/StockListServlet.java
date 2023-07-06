package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.StockDTO;
import stock.Service_st;

@WebServlet("/stockList")
public class StockListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page_str = request.getParameter("pageNum");
		int pageNum = 1;
		if (page_str != null) {
			pageNum = Integer.parseInt(page_str);
		}
		
		Service_st s_serv = new Service_st();
		List<StockDTO> slist = s_serv.selectAllStock(pageNum);
		int cnt = s_serv.getListCnt();
		
		request.setAttribute("currPage", pageNum);
		request.setAttribute("totalCnt", cnt);
		request.setAttribute("slist", slist);
		request.getRequestDispatcher("stock/stock.jsp?req=list").forward(request, response);
	}
}
