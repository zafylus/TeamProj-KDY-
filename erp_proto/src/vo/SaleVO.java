package vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SaleVO {

	private int totalSale;
	private int saleCnt;
	private int avgPay;
	private int dayTotalSale;
	
}
