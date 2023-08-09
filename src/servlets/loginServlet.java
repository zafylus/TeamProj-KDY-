package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import dao.LoginDAO;

@WebServlet("/login")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  System.out.println("login get..........."); 
		  HttpSession session = request.getSession();
		  String pageRedirect =(String) session.getAttribute("pageRedirect");
		  JSONObject jsonResponse = new JSONObject();
		  jsonResponse.put("pageRedirect" , pageRedirect);
		   response.setContentType("application/json");
		  response.setCharacterEncoding("UTF-8");
		  
		  PrintWriter out = response.getWriter();
		  out.print(jsonResponse.toString());
		 
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();
			String id = request.getParameter("id");
	        String pw = request.getParameter("pw");

	        System.out.println("id : " + id);
	        System.out.println("pw : " + pw);
	        LoginDAO loginDAO = new LoginDAO();
	        boolean isValidLogin = loginDAO.checkLogin(id, pw);
	        System.out.println("isValidLogin : " + isValidLogin);
	      
	}

}
