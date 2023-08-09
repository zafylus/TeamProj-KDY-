package servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import dto.FixedCostDTO;
import services.Service_ex;
import util.MakeJSON;

@WebServlet("/fixedcost")
public class ExpenseFixedCostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		String req = request.getParameter("data");
		
		if(req != null && req.equals("1")) {
			Service_ex ex_serv = new Service_ex();
			PrintWriter out = response.getWriter();
			
			List<FixedCostDTO> flist = ex_serv.getFixedCostList();
			
			MakeJSON<FixedCostDTO> jobj = new MakeJSON<>();
			out.print(jobj.getJSONArray(flist));
			
			return;
		}
		
		request.setAttribute("page", "expenseFixedCost.jsp");
		request.getRequestDispatcher("/expense/expense.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		Service_ex ex_ser = new Service_ex();
		
		String no = request.getParameter("no");
		String name = request.getParameter("name");
		String cost = request.getParameter("cost");
		String date = request.getParameter("date");
		
		ex_ser.registFixedCost(new FixedCostDTO(Integer.parseInt(no), name, Integer.parseInt(cost), Integer.parseInt(date)) );
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		Service_ex ex_ser = new Service_ex();
		
		BufferedReader br = request.getReader();
		String str = br.readLine();
		
		JSONObject jobj = new JSONObject(str);
		
		int no = jobj.getInt("no");
		String name = jobj.getString("name");
		int cost = jobj.getInt("cost");
		int date = jobj.getInt("date");
		
		ex_ser.modifyFixedCost(new FixedCostDTO(no, name, cost, date));
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service_ex ex_ser = new Service_ex();
		
		BufferedReader br = request.getReader();
		String str = br.readLine();
		
		FixedCostDTO dto = new FixedCostDTO();
		dto.setFi_no(Integer.parseInt(str));
		
		ex_ser.deleteFixedCost(dto);
	}

}
