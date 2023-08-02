package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OrderListVO {
	private String odr_no;
	private String odr_code;
	private String pr_code;
	private int amount;
	
	public OrderListVO(String odr_code, String pr_code, int amount) {
		this.odr_code = odr_code;
		this.pr_code = pr_code;
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "OrderListVO [odr_no=" + odr_no + ", odr_code=" + odr_code + ", pr_code=" + pr_code + ", amount="
				+ amount + "]";
	}
	
	
}
