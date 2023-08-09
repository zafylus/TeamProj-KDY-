package dto;

import lombok.Data;

@Data
public class ProductDTO {
	private String pr_code;
	private String pr_name;
	private int pr_price;
	private String pr_ctgry;
}
