package vo;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class PeriodVO {
	private LocalDate beginPeriod;
	private LocalDate endPeriod;
}
