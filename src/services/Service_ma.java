package services;

import java.util.List;

import dao.MaterialDAO;
import dto.MaterialDTO;

public class Service_ma {
	
	public List<MaterialDTO> getList() {
		MaterialDAO dao = new MaterialDAO();
		@SuppressWarnings("unchecked")
		List<MaterialDTO> list = (List<MaterialDTO>)(Object)dao.getData();
		return list;
	}
}
