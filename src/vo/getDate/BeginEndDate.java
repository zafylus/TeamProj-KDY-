package vo.getDate;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class BeginEndDate {
	private LocalDate beginDate;
	private LocalDate endDate;
}
