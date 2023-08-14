package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import dao.ReceiptDAO;
import dto.ReceiptItem;

@WebServlet("/receiptData")
public class receiptData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ReceiptDAO dao = new ReceiptDAO();
		String dataNo = request.getParameter("dataNo");
		System.out.println("dataNo" + dataNo);
		List<ReceiptItem> rilist = dao.getItems(dataNo);
		System.out.println("rilist" + rilist);
		JSONArray jsonArray = new JSONArray(rilist); // List를 JSON 배열로 변환
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		System.out.println(jsonArray);
		out.print(jsonArray);
		
		
		 String dateStart = request.getParameter("date_start");
         String dateLast = request.getParameter("date_last");
         String contentType = request.getParameter("content_type");
         String lowPrice = request.getParameter("low_price");
         String highPrice = request.getParameter("high_price");
         String receiptNum = request.getParameter("receipt_num");
         
         
         System.out.println(dateLast);
         System.out.println(contentType);
         System.out.println(lowPrice);
         System.out.println(highPrice);
         System.out.println(receiptNum);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ReceiptDAO dao = new ReceiptDAO();
		int maxOdrCodeInt = dao.getMaxodrCode() + 1;
		String maxOdrCode = Integer.toString(maxOdrCodeInt);
		Boolean result = null;
		String orderNum = request.getParameter("orderNum"); // 클라이언트로부터 받은 데이터
		System.out.println("orderNum: " + orderNum);

		List<ReceiptItem> rilist = dao.getItems(orderNum);
		for (ReceiptItem item : rilist) {
			String prNo = item.getPrNo();
		    int amount = (item.getAmount()*-1);
		    
		    System.out.println("amount: " + amount);
		    result = dao.insertOrder(maxOdrCode, prNo ,amount);
		}
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		
		if(result) {
			out.print("성공");
		}else {
			out.print("실패");
		}

	}

}
