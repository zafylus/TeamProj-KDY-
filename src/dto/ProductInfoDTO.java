package dto;

import lombok.Getter;

@Getter
public class ProductInfoDTO extends Product {
	
	private String pr_img;
	private int total_cost;
	private int margin;
	private double margin_per;

	public ProductInfoDTO(String pr_code, String pr_name, int pr_price, String pr_ctgry, String pr_img, int total_cost,
			int margin, double margin_per) {
		super(pr_code, pr_name, pr_price, pr_ctgry);
		this.pr_img = pr_img;
		this.total_cost = total_cost;
		this.margin = margin;
		this.margin_per = margin_per;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public String toString() {
		return "ProductInfoDTO [pr_img=" + pr_img + ", total_cost=" + total_cost + ", margin=" + margin
				+ ", margin_per=" + margin_per + ", pr_code=" + pr_code + ", pr_name=" + pr_name + ", pr_price="
				+ pr_price + ", pr_ctgry=" + pr_ctgry + "]";
	}
	
	

}
