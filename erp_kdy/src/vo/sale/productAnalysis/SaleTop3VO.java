package vo.sale.productAnalysis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SaleTop3VO {

	private String prName;
	private int saleCnt;
	private int pay;
	
}
