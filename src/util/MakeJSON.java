package util;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class MakeJSON<T> {
	
	public String getJSONArray(List<T> list) {
		JSONArray jarray = new JSONArray(list);
		
		return jarray.toString();
	}
	
	public String getJSONObj(T obj) {
		JSONObject jobj = new JSONObject(obj);
		
		return jobj.toString();
	}
}
