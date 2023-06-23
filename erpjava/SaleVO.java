package erp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SaleVO {

	private int date;
	private int sale;
	private int margin;
	private int cost;
	private int income;
}
