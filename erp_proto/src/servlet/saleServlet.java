package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import service.DivisionService;
import vo.PeriodVO;

@WebServlet("/sale")
public class saleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PeriodVO input = (PeriodVO) request.getAttribute("period");
		System.out.println("input : " + input);
		
		DivisionService division = new DivisionService();
		Map<String, Object> output = division.dataDevision(input);
		System.out.println("output : " + output);
		
		response.setCharacterEncoding("UTF-8");
		JSONObject jobj  = getJsonStringFromMap(output);
		PrintWriter out = response.getWriter();
		System.out.println(jobj);
		out.print(jobj);
	}

    public static JSONObject getJsonStringFromMap( Map<String, Object>  map )
    {
        JSONObject jsonObject = new JSONObject();
        for( Map.Entry<String, Object> entry : map.entrySet() ) {
            String key = entry.getKey();
            Object value = entry.getValue();
            jsonObject.put(key, value);
        }
        
        return jsonObject;
    }
}