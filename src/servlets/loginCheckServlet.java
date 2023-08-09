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

@WebServlet("/loginCheck")
public class loginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String logout = request.getParameter("logout");
		System.out.println("logout : " + logout );
		if(logout != null) {
			session.removeAttribute("userId");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();
			String id = request.getParameter("id");
	        String pw = request.getParameter("pw");
	        LoginDAO loginDAO = new LoginDAO();
	        boolean isValidLogin = loginDAO.checkLogin(id, pw);
	        if (isValidLogin) {
	        	System.out.println("로그인 성공...");
	            session.setAttribute("userId", id);
	            response.sendRedirect("/erp_ver1.1/main"); 
	  		  
	        } else {
	        	System.out.println("로그인 실패...");
	            response.sendRedirect("/erp_ver1.1/jsp/login.jsp?error=1"); // 로그인 실패 시 이동할 페이지 (예: 다시 로그인 페이지로)
	        }
	}

}
