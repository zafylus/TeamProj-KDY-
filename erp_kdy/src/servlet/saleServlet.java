package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import service.common.PageDataManager;
import vo.transData.TransInfoVO;

@WebServlet("/sale")
public class saleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		TransInfoVO Info = (TransInfoVO) request.getAttribute("info");
		System.out.println("info : " + Info);
		
		// 요청받은 정보를  PageDataManager 입력한다.
		// PageDataManager는  페이지 별 필요 데이터를 반환한다.
		// 자료구조는 Map<String, Object>이다.
		PageDataManager pageDataManager= new PageDataManager();
		Map<String, Object> pageData = pageDataManager.dataDevision(Info);
		System.out.println("output : " + pageData);
		
		response.setCharacterEncoding("UTF-8");
		JSONObject jobj  = getJsonStringFromMap(pageData);
		PrintWriter out = response.getWriter();
		System.out.println(jobj);
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