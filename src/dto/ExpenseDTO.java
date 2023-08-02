package dto;

import java.time.LocalDateTime;

public class ExpenseDTO {
	private int ex_no;
	private String ma_code;
	private int ex_cost;
	private int ex_ea;
	private LocalDateTime ex_date;
	private String ex_note;
	
	public int getEx_no() {
		return ex_no;
	}
	public void setEx_no(int ex_no) {
		this.ex_no = ex_no;
	}
	public String getMa_code() {
		return ma_code;
	}
	public void setMa_code(String ma_code) {
		this.ma_code = ma_code;
	}
	public int getEx_cost() {
		return ex_cost;
	}
	public void setEx_cost(int ex_cost) {
		this.ex_cost = ex_cost;
	}
	public int getEx_ea() {
		return ex_ea;
	}
	public void setEx_ea(int ex_ea) {
		this.ex_ea = ex_ea;
	}
	public LocalDateTime getEx_date() {
		return ex_date;
	}
	public void setEx_date(LocalDateTime ex_date) {
		this.ex_date = ex_date;
	}
	public String getEx_note() {
		return ex_note;
	}
	public void setEx_note(String ex_note) {
		this.ex_note = ex_note;
	}
}