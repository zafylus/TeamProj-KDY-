package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

import vo.transData.TransInfoDTO;

public class saleFilter extends HttpFilter implements Filter {
	private static final long serialVersionUID = 1L;

	public saleFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		request.setCharacterEncoding("UTF-8");
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		
	/*	// 데이터를 요청한 jsp의 url 얻기
		String referer = httpRequest.getHeader("Referer");
		System.out.println("referer : " + referer);
		String url = referer.substring(referer.lastIndexOf('/') + 1);
		url = url.substring(0, url.length() - 4);*/
		
		// 요청 파라미터 불러오기
		String dateUnit = request.getParameter("dateUnit");
		String dateValue = request.getParameter("dateValue");
		String url = request.getParameter("page");
		
		// 요청  + url 객체에 담아서 전송
		TransInfoDTO info = new TransInfoDTO(url, dateUnit, dateValue);
		httpRequest.setAttribute("info", info);
		// 매개 변수는 하나인 게 보기 이쁘다. 
		

		chain.doFilter(request, response);



		
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("sale filter.....");
	}

}