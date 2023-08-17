package services;

import java.util.List;

import dao.ReceiptDAO;
import dto.ReceiptSales;
import vos.SelectQueryVO;

public class ReceiptService {
	private ReceiptDAO rd = new ReceiptDAO();
	
	public String createSelectQuery(SelectQueryVO sq) {
		System.out.println(sq);
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT order_date, odr_code, sum(sales) total_sales FROM ordr_view \n");
		
		//날짜 추가
		sb.append("WHERE order_date BETWEEN '"+sq.getDateStart()+" 00:00:00' and '"
				+ sq.getDateLast()+" 23:59:59' \nGROUP BY odr_code \n");
		
		//판매 종류
		switch (sq.getContentType()) {
		
			case "all":
				sb.append("HAVING sum(sales)");
				break;
		
			case "sale":
				sb.append("HAVING sum(sales) >=0 ");
				break;
	
			case "return":
				sb.append("HAVING sum(sales) <=0 ");
				break;
	
			default:
				System.out.println("Content Type 선택 오류");
				break;
			}
		
		//판매 처리
		if (sq.getLowPrice() != null && sq.getHighPrice() == null) {
			sb.append("AND sum(sales) >= "+sq.getLowPrice());
		}
		if (sq.getLowPrice() == null && sq.getHighPrice() != null) {
			sb.append("AND sum(sales) <= "+sq.getHighPrice());
		}
		if (sq.getLowPrice() != null && sq.getHighPrice() != null ) {
			sb.append("AND (sum(sales) >= "+sq.getLowPrice()+" AND sum(sales) <= "+sq.getHighPrice()+")");
		}
		
		//영수증 처리
		if (sq.getReceiptNum() != null) {
			sb.append(" AND odr_code = '" + sq.getReceiptNum() + "'");
		}
		
		sb.append(";");
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	public List<ReceiptSales> getReceipt(SelectQueryVO sq){
		return rd.getReceipt(createSelectQuery(sq));
	} 
}
