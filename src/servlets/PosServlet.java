package servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import services.PosService;

@WebServlet("/pos")
public class PosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PosService pps = new PosService();
	
	//상품 목록 보내는 Servlet
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		JSONArray jarray = pps.productList();
		System.out.println(jarray);
		
		request.setAttribute("plist", jarray);
		request.getRequestDispatcher("pos.jsp").forward(request, response);
	}
	
	//주문 결제 처리하는 Servlet
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("utf-8");
		
		BufferedReader br = request.getReader();
		String jstr = br.readLine();
		
		PrintWriter out = response.getWriter();
		//Service에서 Regist 처리
		if (pps.regist(jstr)) {
			out.print("Order Regist Succes");
		}else {
			out.print("Order Regist Failed");
		}
	}
}
