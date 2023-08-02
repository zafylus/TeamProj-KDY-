package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import dao.SalesDAO;
import services.SalesModel;

@WebServlet("/eachProdSales")
public class EachProductSales extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SalesModel sm = new SalesModel();
	
	//일별 각 상품 정보 서블릿
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String date = request.getParameter("date");
		System.out.println("EachProductDate :  " + date);
		JSONArray jarray = sm.dayStatToJSON(date); 
		System.out.println("EachProdServl : " + jarray);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(jarray);
	}

}
