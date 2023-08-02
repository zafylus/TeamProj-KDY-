package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Coffee;
import dto.Product;
import dto.RecipeDTO;

@WebServlet("/product-regist")
public class ProductRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("uri", "productReg.jsp");
		
		request.getRequestDispatcher("product/product.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pr_name = request.getParameter("pr_name");
		int pr_price = Integer.parseInt(request.getParameter("pr_price"));
		String pr_ctgry = request.getParameter("pr_ctgry");
		int ma001 = Integer.parseInt(request.getParameter("ma001"));
		int ma002 = Integer.parseInt(request.getParameter("ma002"));
		int ma003 = Integer.parseInt(request.getParameter("ma003"));
		Product p = new Coffee(pr_name, pr_price, pr_ctgry);
		RecipeDTO r = new RecipeDTO()
	}

}
