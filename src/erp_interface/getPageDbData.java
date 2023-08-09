package erp_interface;

import java.sql.Date;
import java.util.Map;

public interface getPageDbData {
	Map<String, Object> returnData(Date BeginDate, Date endDate); 
}
