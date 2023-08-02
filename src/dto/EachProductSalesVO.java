package dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
//상품 매출 정보
public class EachProductSalesVO {
	private String pr_code;
	private String pr_name;
	private String amount;
	private String sales;
}
