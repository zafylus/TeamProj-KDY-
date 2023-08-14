package servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class poservlet
 */
//@WebServlet("/pos")
public class poservlet extends HttpServlet {
	    private static final long serialVersionUID = 1L;
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		}
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
	        StringBuilder jsonData = new StringBuilder();
	        String line;
	        while ((line = br.readLine()) != null) {
	            jsonData.append(line);
	        }
	        System.out.println("jsonData" + jsonData);
	        // JSON 데이터를 MyData 배열로 파싱하여 처리
	        MyData[] myDataArr = parseJson(jsonData.toString());
	        System.out.println("myDataArr" +myDataArr);
	        // 요청 데이터 출력 (예시로 간단하게 콘솔에 출력)
	        for (int i = 0; i < myDataArr.length; i++) {
	            MyData myData = myDataArr[i];
	            System.out.println("Code: " + myData.getCode() + ", EA: " + myData.getEa());
	        }

	        // 클라이언트에게 응답 전송
	        response.setContentType("text/plain");
	        PrintWriter out = response.getWriter();
	        out.println("서버에서 요청 데이터를 정상적으로 처리하였습니다.");
	    }

	    // JSON 데이터를 MyData 배열로 파싱하는 메서드
	    private MyData[] parseJson(String json) {
	        MyData[] myDataArr = new MyData[0];

	        // JSON 배열 형태로 변환된 데이터를 파싱하여 MyData 객체들을 생성하고 배열에 추가
	        String[] dataArray = json.split(",");
	        for (String data : dataArray) {
	            String code = null;
	            String ea = null;

	            String[] keyValueArray = data.split(":");
	            String key = keyValueArray[0].trim();
	            String value = keyValueArray[1].trim();
	            System.out.println("key " + key);
	            System.out.println("value " + value);
	            if (key.startsWith("{\"code\"")) {
	                code = value.substring(1, value.length() - 1);
	            } else if (key.startsWith("\"ea\"")) {
	                ea = value.substring(1, value.length() - 1);
	            }

	            if (code != null && ea != null) {
	                // 배열 크기를 동적으로 늘려서 MyData 객체를 추가
	                MyData[] tempArr = new MyData[myDataArr.length + 1];
	                System.arraycopy(myDataArr, 0, tempArr, 0, myDataArr.length);
	                tempArr[tempArr.length - 1] = new MyData(code, ea);
	                myDataArr = tempArr;
	            }
	        }

	        return myDataArr;
	    }
}
