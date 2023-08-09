package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.Service_ex;
import util.NameCheck;

@WebServlet("/expense")
public class ExpenseRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String ma_code = request.getParameter("ma_name");
		
		request.setAttribute("page", "expenseRegist.jsp");
		if(NameCheck.MaNameCheck(ma_code)) {
			request.setAttribute("code",NameCheck.MaNameToCode(ma_code) );
			request.setAttribute("ea",request.getParameter("ex_ea") );
			request.getRequestDispatcher("expense/expense.jsp?confirm=1").forward(request, response);
			return;
		}
		
		request.getRequestDispatcher("expense/expense.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Service_ex ex_serv = new Service_ex();
		String ma_code = request.getParameter("ma_name");
		String ex_cost = request.getParameter("ex_cost");
		String ex_ea = request.getParameter("ex_ea");

		ex_serv.insertExpense(ma_code, Integer.parseInt(ex_cost), Integer.parseInt(ex_ea));
		doGet(request, response);
	}
}
