package dto;

import lombok.Data;

//상품 추상클래스
@Data
public abstract class Product {

	protected String pr_code;
	protected String pr_name;
	protected int pr_price;
	protected String pr_ctgry;
	
	public Product(String pr_name, int pr_price, String pr_ctgry) {
		super();
		this.pr_name = pr_name;
		this.pr_price = pr_price;
		this.pr_ctgry = pr_ctgry;
	}
	
	public abstract int count();
}
