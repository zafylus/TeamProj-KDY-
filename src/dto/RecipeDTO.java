package dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class RecipeDTO {
	private String pr_code;
	private double ma001;
	private double ma002;
	private double ma003;
	
	public RecipeDTO(double ma001, double ma002, double ma003) {
		this.ma001 = ma001;
		this.ma002 = ma002;
		this.ma003 = ma003;
	}
	
	public String getPr_code() {
		return pr_code;
	}
	public void setPr_code(String pr_code) {
		this.pr_code = pr_code;
	}
	public double getMa001() {
		return ma001;
	}
	public void setMa001(double ma001) {
		this.ma001 = ma001;
	}
	public double getMa002() {
		return ma002;
	}
	public void setMa002(double ma002) {
		this.ma002 = ma002;
	}
	public double getMa003() {
		return ma003;
	}
	public void setMa003(double ma003) {
		this.ma003 = ma003;
	}

	@Override
	public String toString() {
		return "RecipeDTO [pr_code=" + pr_code + ", ma001=" + ma001 + ", ma002=" + ma002 + ", ma003=" + ma003 + "]";
	}
	
	
}
