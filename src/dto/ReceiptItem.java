package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReceiptItem {
	 private String odrCode;
	 private String prNo;
	 private String prName;
	 private int prPrice;
	 private int amount;
}
