package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

import vo.PeriodVO;

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
		String referer = httpRequest.getHeader("Referer");
		String jspFileName = referer.substring(referer.lastIndexOf('/') + 1);

		String unit = request.getParameter("unit");
		String term = request.getParameter("term");
		
		PeriodVO period = new PeriodVO(jspFileName, unit, term);

		System.out.println("name = " + jspFileName);
		System.out.println("unit = " + unit);
		System.out.println("term =" + term);
		System.out.println("필터 끝");
		httpRequest.setAttribute("period", period);

		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
