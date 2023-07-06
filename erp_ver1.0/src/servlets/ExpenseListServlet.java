package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.ExpenseDTO;
import expense.Service_ex;

@WebServlet("/expenseList")
public class ExpenseListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service_ex e_serv = new Service_ex();
		
		List<ExpenseDTO> eList = e_serv.selectAllExpense();
		request.setAttribute("elist", eList);
		
		request.getRequestDispatcher("expense.jsp").forward(request, response);
	}

}
