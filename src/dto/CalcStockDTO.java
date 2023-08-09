package dto;

import lombok.Data;

@Data
// 현재 재고량으로 생산 가능한 계산한 결과 값을 저장해서 이동시킬 객체
public class CalcStockDTO {
	private String pr_name;
	private int pr_ea;
}
