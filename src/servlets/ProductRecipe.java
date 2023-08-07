package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.RecipeOrderbyNameDTO;
import services.ProductService;

@WebServlet("/product-recipe")
public class ProductRecipe extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService ps = new ProductService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		List<RecipeOrderbyNameDTO> rlist = ps.recipeList(); 
		
		request.setAttribute("rlist", rlist);
		request.setAttribute("uri", "productRecipe.jsp");
		
		request.getRequestDispatcher("product/product.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
