package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.ExpenseDTO;
import service.Service_ex;
import util.DateCheck;
import util.PageCheck;

@WebServlet("/expenseList")
public class ExpenseListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String page_str = request.getParameter("pageNum");
		int pageNum = PageCheck.pageNumCheck(page_str);
		
		String PreDate = request.getParameter("date1");
		String afDate = request.getParameter("date2");
		
		String date2 = DateCheck.setDate2(afDate);
		String date1 = DateCheck.setDate1(PreDate);
		
		Service_ex e_serv = new Service_ex();
		
		List<ExpenseDTO> eList = e_serv.expenseDateBTWList(date1, date2, pageNum);
		
		int cnt = e_serv.getListCntBtwDate(date1, date2);
		
		request.setAttribute("date2", date2);
		request.setAttribute("date1", date1);
		request.setAttribute("currPage", pageNum);
		request.setAttribute("totalCnt", cnt);
		request.setAttribute("elist", eList);
		request.getRequestDispatcher("expense/expense.jsp?req=list").forward(request, response);
	}
}
