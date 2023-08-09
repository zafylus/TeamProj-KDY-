package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import service.common.PageDataManager;
import vo.transData.TransInfoDTO;

@WebServlet("/sale")
public class saleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.getRequestDispatcher("sales/sales.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url = "saleAnalysis";
		String dateUnit = request.getParameter("dateUnit");
		String dateValue = request.getParameter("dateValue");
		
		TransInfoDTO info = new TransInfoDTO(url, dateUnit, dateValue);
		// 요청 데이터 불러오기
		// service에 전달 -> db값 받기 -> jsp 전송
		PageDataManager pageDataManager= new PageDataManager();
		Map<String, Object> pageData = pageDataManager.dataDevision(info);
		
		response.setCharacterEncoding("UTF-8");
		JSONObject jobj  = getJsonStringFromMap(pageData);
		PrintWriter out = response.getWriter();
		out.print(jobj);
	}
	
	// Map -> JSON 변환 메서드다. 
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