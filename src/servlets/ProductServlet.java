package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dto.ProductInfoDTO;
import services.ProductService;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService ps = new ProductService();
	
	//상품목록 페이지 이동
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = null;
		uri = request.getParameter("uri");
		System.out.println(uri);
		List<ProductInfoDTO> plist = ps.productInfo(); 
		request.setAttribute("plist", plist);
		
		if (uri == null || uri.equals("card")) {
			request.setAttribute("uri", "productList_card.jsp");
			request.getRequestDispatcher("product/product.jsp").forward(request, response);
		}
		else if (uri.equals("list")) {
			request.setAttribute("uri", "productList.jsp");
			request.getRequestDispatcher("product/product.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
	}

}
