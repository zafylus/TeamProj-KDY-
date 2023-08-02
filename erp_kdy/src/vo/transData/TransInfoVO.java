package vo.transData;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TransInfoVO {

	private String url;
	private String dateUnit;
	private String dateValue;
}
