package servlets;

import lombok.Data;

@Data
public class MyData {
	private String code;
    private String ea;
    
    public MyData(String code, String ea) {
        this.code = code;
        this.ea = ea;
    }
}
