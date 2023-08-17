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
import dto.ReceiptSales;
import services.ReceiptService;
import vos.SelectQueryVO;

@WebServlet("/receiptData")
public class receiptData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReceiptService rs = new ReceiptService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		String dateStart = request.getParameter("date_start");
		System.out.println("dateStart..." + dateStart);
		if(dateStart != null && !dateStart.equals("")) {
			System.out.println("dateStart." + dateStart);
	        String dateLast = request.getParameter("date_last");
	        String contentType = request.getParameter("content_type");
	        String lowPrice = request.getParameter("low_price");
	        String highPrice = request.getParameter("high_price");
	        String receiptNum = request.getParameter("receipt_num");
	        SelectQueryVO sqvo = new SelectQueryVO(dateStart, dateLast, contentType, lowPrice, highPrice, receiptNum);
	        System.out.println(sqvo);
	        System.out.println("-----------------------");
	         
	        List<ReceiptSales> rslist = rs.getReceipt(sqvo);
	        JSONArray jsonArray = new JSONArray(rslist); 
	        System.out.println("jsonArray " + jsonArray);
	        out.print(jsonArray);
	        return;
		}else {
			
			ReceiptDAO dao = new ReceiptDAO();
			String dataNo = request.getParameter("dataNo");
			System.out.println("dataNo" + dataNo);
			List<ReceiptItem> rilist = dao.getItems(dataNo);
			System.out.println("rilist" + rilist);
			JSONArray jsonArray = new JSONArray(rilist); // List를 JSON 배열로 변환
			System.out.println(jsonArray);
			out.print(jsonArray);
		}
		
			
		
      
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ReceiptDAO dao = new ReceiptDAO();
		String maxOdrCodeStr = dao.getMaxodrCode();

		String numericPart = maxOdrCodeStr.substring(2); 
		int numericInt = Integer.parseInt(numericPart) + 1; 
		String newMaxOdrCodeStr = "OR" + String.format("%03d", numericInt);
		System.out.println(newMaxOdrCodeStr);
		
		Boolean result = null;
		String orderNum = request.getParameter("orderNum"); // 클라이언트로부터 받은 데이터
		System.out.println("orderNum: " + orderNum);
		dao.insertOrderTbl(newMaxOdrCodeStr);

		List<ReceiptItem> rilist = dao.getItems(orderNum);
		for (ReceiptItem item : rilist) {
			String prNo = item.getPrNo();
		    int amount = (item.getAmount()*-1);
		    
		    System.out.println("amount: " + amount);
		    result = dao.insertOrder(newMaxOdrCodeStr, prNo ,amount);
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
