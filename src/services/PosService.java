package services;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import dao.OrderDAO;
import dao.ProductMDAO;
import dto.OrderListVO;
import dto.Product;

public class PosService {
	private ProductMDAO pDao = new ProductMDAO();
	private OrderDAO oDao = new OrderDAO();
	
	public JSONArray productList() {
		JSONArray jarray = null;
		ArrayList<Product> plist = pDao.productList_imgX();
		
		if(plist != null) {
			jarray = new JSONArray(plist);
		}else {
			System.out.println("상품 리스트 없음");
		}
		
		return jarray;
	}
	
	public boolean regist(String jstr) {
		int registRes = oDao.regist();
		if (registRes == 1) {
			String LatestOrderCode = oDao.getMaxOdrCode();
			JSONArray jarray = new JSONArray(jstr);
			for (int i = 0; i < jarray.length(); i++) {
				JSONObject jo = new JSONObject(jarray.get(i).toString());
				String pr_code = (String) jo.get("code");
				int amount = Integer.parseInt((String) jo.get("ea")); 
				OrderListVO olVo = new OrderListVO(LatestOrderCode, pr_code, amount);
				oDao.registOrderList(olVo, LatestOrderCode);
			}
			System.out.println("Regist Success!");
			return true;
		}else {
			System.out.println("Regist Failed...");
		}
		
		return false;
	}
}
