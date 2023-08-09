package util;

import java.util.List;

import dto.MaterialDTO;
import dto.ProductDTO;
import services.Service_Pr;
import services.Service_ma;

public class NameCheck {
	
	// 매개 변수 값이 재료 리스트 이름에 존재하는지 확인
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
	
	// 매개 변수 값이 재료 리스트 코드에 존재하는지 확인
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
	
	// 재료 이름을 입력 받아 재료 코드로 변경 후 반환
	public static String MaNameToCode(String ma_name) {
		Service_ma ma_serv = new Service_ma();
		
		List<MaterialDTO> mlist = ma_serv.getList();
		
		for(MaterialDTO dto : mlist) {
			if(dto.getMa_name().equals(ma_name))
				ma_name = dto.getMa_code();	
		}
		return ma_name;
	}
	
	// 재료 코드를 입력 받아 재료 이름으로 변경 후 반환
	public static String MaCodeToName(String ma_code) {
		Service_ma ma_serv = new Service_ma();
		
		List<MaterialDTO> mlist = ma_serv.getList();
		
		for(MaterialDTO dto : mlist) {
			if(dto.getMa_code().equals(ma_code))
				ma_code = dto.getMa_name();	
		}
		return ma_code;
	}
	
	// 상품 코드를 입력 받아 상품 이름으로 변경 후 반환
	public static String PrCodeToName(String pr_code) {
		Service_Pr pr_serv = new Service_Pr();
		
		List<ProductDTO> plist = pr_serv.getList();
		
		for(ProductDTO dto : plist) {
			if(dto.getPr_code().equals(pr_code))
				pr_code = dto.getPr_name();
		}
		return pr_code;
	}
	
}