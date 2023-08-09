package vo.transData;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PeriodDTO extends TransInfoDTO {

	private String url;
	private String dateUnit;
	private String dateValue;
}
