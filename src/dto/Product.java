package dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public abstract class Product {
	private String prod_no;
	private String prodname;
	private int price;
	private String category;
	
	
	public abstract int count();
}
