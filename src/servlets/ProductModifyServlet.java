package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Coffee;
import dto.Product;
import dto.RecipeDTO;
import services.ProductService;

@WebServlet("/product-modify")
public class ProductModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService ps = new ProductService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pr_code = request.getParameter("pr-code");
		
		System.out.println("Mod : " + ps.productOne(pr_code));
		request.setAttribute("prod", ps.productOne(pr_code));
		request.setAttribute("code", pr_code);
		request.setAttribute("rec", ps.recipe(pr_code));
		request.setAttribute("uri", "productModify.jsp");
		
		request.getRequestDispatcher("product/product.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pr_code = request.getParameter("pr_code");
		String pr_name = request.getParameter("pr_name");
		int pr_price = Integer.parseInt(request.getParameter("pr_price"));
		String pr_ctgry = request.getParameter("pr_ctgry");
		System.out.println(pr_ctgry);
		double ma001 = Double.parseDouble(request.getParameter("ma001"))/1000.0;
		double ma002 = Double.parseDouble(request.getParameter("ma002"))/1000.0;
		double ma003 = Double.parseDouble(request.getParameter("ma003"))/1000.0;
		Product p = new Coffee(pr_code, pr_name, pr_price, pr_ctgry);
		RecipeDTO r = new RecipeDTO(pr_code, ma001, ma002, ma003);
		
		if (ps.modify(p, r)) {
			response.sendRedirect("product");
		}else {
			PrintWriter out = response.getWriter();
			out.print("<script>alert('Error')</script>");
			
		}
	}

}
