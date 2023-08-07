package dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RecipeOrderbyNameDTO {
	private String pr_name;
	private double ma001;
	private double ma002;
	private double ma003;
	
	public RecipeOrderbyNameDTO(double ma001, double ma002, double ma003) {
		this.ma001 = ma001;
		this.ma002 = ma002;
		this.ma003 = ma003;
	}
	
}
