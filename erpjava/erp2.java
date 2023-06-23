package erp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

@WebServlet("/erp2")
public class erp2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset =utf-8");
		PrintWriter out = response.getWriter();
		
		String value = request.getParameter("value");
		
		SaleDAO dao = new SaleDAO();
		JSONArray jsonArray = new JSONArray();
		ArrayList<SaleVO> mlist = dao.getMonth();
		if(value.equals("m")) {
			for (SaleVO s : mlist) {
			    JSONObject jo = new JSONObject();
			    jo.put("월", s.getDate());
			    jo.put("판매금액", s.getSale());
			    jo.put("마진", s.getMargin());
			    jo.put("지출", s.getCost());
			    jo.put("순수익", s.getIncome());

			    jsonArray.put(jo);

			}
		}else if(value.equals("d")) {
			for (SaleVO s : mlist) {
			    JSONObject jo = new JSONObject();
			    jo.put("일", s.getDate());
			    jo.put("판매금액", s.getSale());
			    jo.put("순수익", s.getIncome());

			    jsonArray.put(jo);

			}
		
		}
		JSONObject resultObj = new JSONObject();
		resultObj.put("data", jsonArray);
		out.print(resultObj);
		
	}

}
