package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.ExpenseDTO;
import services.Service_ex;
import util.MakeData;
import util.PageCheck;

@WebServlet("/expenses")
public class ExpenseSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Service_ex e_serv = new Service_ex();
		
		String page_str = request.getParameter("pageNum");
		int pageNum = PageCheck.pageNumCheck(page_str);
		
		String PreDate = request.getParameter("date1");
		String afDate = request.getParameter("date2");
		
		String date2 = MakeData.setDate2(afDate);
		String date1 = MakeData.setDate1(PreDate);
		
		List<ExpenseDTO> eList = e_serv.expenseDateBTWList(date1, date2, pageNum);
		
		int cnt = e_serv.getListCntBtwDate(date1, date2);
		
		request.setAttribute("date2", date2);
		request.setAttribute("date1", date1);
		request.setAttribute("currPage", pageNum);
		request.setAttribute("totalCnt", cnt);
		request.setAttribute("elist", eList);
		request.setAttribute("page", "expenseSelect.jsp");
		request.getRequestDispatcher("expense/expense.jsp").forward(request, response);
	}
}
