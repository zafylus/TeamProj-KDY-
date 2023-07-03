package services;

import java.util.ArrayList;

import org.json.JSONArray;

import dao.SalesDAO;
import dto.SalesByDateDTO;

public class SalesModel {
	SalesDAO sd = new SalesDAO();
	
	public JSONArray parseList() {
		ArrayList<SalesByDateDTO> slist = sd.selectAll();
		System.out.println("SalesModel : " + slist);
		JSONArray jarray = new JSONArray(slist);
		return jarray;
	}
}
