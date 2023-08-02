package filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.transData.TransInfoVO;

@WebFilter(urlPatterns = "/sale")
public class productSaleFilter extends HttpFilter implements Filter {
	private static final long serialVersionUID = 1L;

	public productSaleFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		// 데이터를 요청한 jsp url 얻기
		// 이전 페이지의 header를 얻는 코드
		String referer = httpRequest.getHeader("Referer");
		String url = referer.substring(referer.lastIndexOf('/') + 1);
		url = url.substring(0, url.length() - 4);
		
		String dateUnit = request.getParameter("dateUnit");
		String dateValue = request.getParameter("dateValue");

		
		TransInfoVO info = new TransInfoVO(url, dateUnit, dateValue);

		System.out.println("url = " + url);
		System.out.println("dateUnit = " + dateUnit);
		System.out.println("dateValue =" + dateValue);
		System.out.println("필터 끝");
		httpRequest.setAttribute("info", info);

		chain.doFilter(request, response);

	    httpResponse.setCharacterEncoding("UTF-8");


		
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}