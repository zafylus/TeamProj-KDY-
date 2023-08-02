package util;

import java.util.List;

import dto.MaterialDTO;
import service.Service_ma;

public class NameCheck {
	
	public static boolean MaNameCheck(String ma_name) {
		boolean flag = false;
		Service_ma ma_serv = new Service_ma();
		
		List<MaterialDTO> mlist = ma_serv.getList();
		
		for(MaterialDTO dto : mlist) {
			if(dto.getMa_name().equals(ma_name))
				flag = true;	
		}
		return flag;
	}
	
	public static boolean MaCodeCheck(String ma_code) {
		boolean flag = false;
		Service_ma ma_serv = new Service_ma();
		
		List<MaterialDTO> mlist = ma_serv.getList();
		
		for(MaterialDTO dto : mlist) {
			if(dto.getMa_code().equals(ma_code))
				flag = true;	
		}
		return flag;
	}
	
	public static String MaNameToCode(String ma_name) {
		Service_ma ma_serv = new Service_ma();
		
		List<MaterialDTO> mlist = ma_serv.getList();
		
		for(MaterialDTO dto : mlist) {
			if(dto.getMa_name().equals(ma_name))
				ma_name = dto.getMa_code();	
		}
		return ma_name;
	}
	
	public static String MaCodeToName(String ma_code) {
		Service_ma ma_serv = new Service_ma();
		
		List<MaterialDTO> mlist = ma_serv.getList();
		
		for(MaterialDTO dto : mlist) {
			if(dto.getMa_code().equals(ma_code))
				ma_code = dto.getMa_name();	
		}
		return ma_code;
	}
	
}