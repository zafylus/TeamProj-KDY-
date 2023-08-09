package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.StockDTO;
import services.Service_st;
import util.MakeData;
import util.PageCheck;

@WebServlet("/stocks")
public class StockSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String page_str = request.getParameter("pageNum");
		int pageNum = PageCheck.pageNumCheck(page_str);
		
		String PreDate = request.getParameter("date1");
		String afDate = request.getParameter("date2");
		
		String date2 = MakeData.setDate2(afDate);
		String date1 = MakeData.setDate1(PreDate);
		
		Service_st s_serv = new Service_st();
		List<StockDTO> slist = s_serv.stockDateBTWList(date1, date2, pageNum);
		int cnt = s_serv.getListCntBtwDate(date1, date2);
		
		request.setAttribute("date2", date2);
		request.setAttribute("date1", date1);
		request.setAttribute("currPage", pageNum);
		request.setAttribute("totalCnt", cnt);
		request.setAttribute("slist", slist);
		request.setAttribute("page", "stockSelect.jsp");
		request.getRequestDispatcher("stock/stock.jsp").forward(request, response);
	}
}
