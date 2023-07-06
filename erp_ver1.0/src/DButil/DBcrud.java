package DButil;

import java.util.List;

public interface DBcrud {
	
	public boolean insert(Object dto);
	
	public List<Object> getData(int p);
	
	public boolean update(Object dto);
	
	public boolean dalete(Object dto);
}
