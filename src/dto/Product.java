package dto;

import lombok.AllArgsConstructor;

//상품 추상클래스

@AllArgsConstructor
public abstract class Product {

	protected String pr_code;
	protected String pr_name;
	protected int pr_price;
	protected String pr_ctgry;

	
	
	public abstract int count();



	public String getPr_code() {
		return pr_code;
	}



	public void setPr_code(String pr_code) {
		this.pr_code = pr_code;
	}



	public String getPr_name() {
		return pr_name;
	}



	public void setPr_name(String pr_name) {
		this.pr_name = pr_name;
	}



	public int getPr_price() {
		return pr_price;
	}



	public void setPr_price(int pr_price) {
		this.pr_price = pr_price;
	}



	public String getPr_ctgry() {
		return pr_ctgry;
	}



	public void setPr_ctgry(String pr_ctgry) {
		this.pr_ctgry = pr_ctgry;
	}
}
