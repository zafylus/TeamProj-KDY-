package servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import services.ProductService;

@WebServlet("/product-delete")
public class ProductDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService ps = new ProductService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("utf-8");
		
		BufferedReader br = request.getReader();
		String jstr = br.readLine();
		boolean res = true;
		
		if (!jstr.equals("[]")) {
			JSONArray jarray = new JSONArray(jstr);
			List<Object> list = jarray.toList();
			for (Object object : list) {
				res = res && ps.delete((String)object);
			}
		}
		
		System.out.println(res);
//		//Service에서 Regist 처리
//
		if (res) {
			System.out.println("delete!");
//			response.sendRedirect("product");
		}
//		else {
//			PrintWriter out = response.getWriter();
//			out.print("Product Deleted Failed");
//		}
	}
}
