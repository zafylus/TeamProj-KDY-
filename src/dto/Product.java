package dto;

import lombok.AllArgsConstructor;
import lombok.Data;

//상품 추상클래스
@AllArgsConstructor
@Data
public abstract class Product {
	protected String pr_code;
	protected String pr_name;
	protected int pr_price;
	protected String pr_ctgry;
	
	
	public abstract int count();
}
