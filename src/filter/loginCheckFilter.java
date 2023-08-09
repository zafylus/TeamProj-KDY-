package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class loginCheckFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		Filter.super.init(filterConfig);
		System.out.println("loginCheckFilter.....");
	}
	
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
	     	HttpServletRequest httpRequest = (HttpServletRequest) request;
	        HttpServletResponse httpResponse = (HttpServletResponse) response;
	        HttpSession session = httpRequest.getSession();
	        
	        String previousPageUrl = httpRequest.getHeader("Referer");
	        boolean containsLimit = previousPageUrl.matches(".*\\/limit\\/.*");
	        System.out.println();
	        System.out.println("필터 url : "+previousPageUrl);
	        

	        // 로그인 체크를 위해 세션에서 사용자 정보 확인
	        String userId = (String) session.getAttribute("userId");
	        System.out.println(userId);
	        // 세션 생성 및 설정
	        if (userId == null) {
	        	System.out.println("필터 통과");
	        	chain.doFilter(request, response);
	        }

	        
	        // 로그아웃 처리
	        if (httpRequest.getParameter("logout") != null) {
	        	System.out.println("로그아웃 함수");
	        	session.removeAttribute("userId");// 세션 무효화
	        	if(containsLimit) {
	        		System.out.println("로그아웃 홈으로 가요....");
	        		session.setAttribute("pageRedirect", "/erp/jsp/pos.jsp");
		        	httpResponse.sendRedirect("/erp/loginCheck");
	        		return;
	        	}
	        	System.out.println("로그아웃 이전 페이지로...");
	            httpResponse.sendRedirect(httpRequest.getContextPath() + previousPageUrl);
	            return;
	        }

	    }
}
