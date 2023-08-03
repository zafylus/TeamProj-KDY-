package dto;
//커피 DTO

import lombok.Data;

public class Coffee extends Product{

	private String pr_img;

	public Coffee(String pr_code, String pr_name, int pr_price, String pr_ctgry) {
		super(pr_code, pr_name, pr_price, pr_ctgry);
		// TODO Auto-generated constructor stub
	}

	public Coffee(String pr_code, String pr_name, int pr_price, String pr_ctgry, String pr_img) {
		super(pr_code, pr_name, pr_price, pr_ctgry);
		this.pr_img = pr_img;
	}
	
	@Override
	public int count() {
		return 0;
	}

	public String getPr_img() {
		return pr_img;
	}

	public void setPr_img(String pr_img) {
		this.pr_img = pr_img;
	}
	
	
}
