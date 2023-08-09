package dao;

import java.util.List;

public interface IERP_DAO {
	public boolean insert(Object dto);
	public List<Object> getData();
	public boolean update(Object dto);
	boolean delete(Object dto);
}
