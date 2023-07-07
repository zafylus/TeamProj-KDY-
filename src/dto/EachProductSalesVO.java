package dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EachProductSalesVO {
	private String pr_code;
	private String pr_name;
	private String amount;
	private String sales;
}
