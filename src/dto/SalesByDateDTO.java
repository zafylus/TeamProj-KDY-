package dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
//일자별 매출
public class SalesByDateDTO {
	private String start;
	private String title;
}
