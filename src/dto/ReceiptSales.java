package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReceiptSales {
	private String odrCode;
    private double totalSales;
    private String odrDate;
}
