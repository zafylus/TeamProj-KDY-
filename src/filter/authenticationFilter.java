package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class authenticationFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		Filter.super.init(filterConfig);
		System.out.println("authenticationFilter.....");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		
		//Session 생성
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession();

		//이전 페이지 url 획득
		String previousPageUrl = httpRequest.getHeader("Referer");
		previousPageUrl = previousPageUrl.replace("http://localhost:8089", "");
		
		// userID 획득
		String userId = (String) session.getAttribute("userId"); 

		// admin - 통과
		// 권한 없음 - 이전 페이지
		// 로그인 x - 로그인 페이지 
		if (userId != null) {
			if ("admin".equals(userId)) {
				chain.doFilter(request, response);
			} else {
				httpResponse.sendRedirect(previousPageUrl);
				return;
			}
		} else {
			httpResponse.sendRedirect("/erp/jsp/login.jsp");
			return;
		}
		

	}

	public void destroy() {
	}

}
