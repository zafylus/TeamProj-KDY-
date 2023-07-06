package dto;

import java.time.LocalDateTime;

public class StockDTO {
	private int st_no;
	private String ma_code;
	private int st_ea;
	private LocalDateTime st_recDate = LocalDateTime.now();
	private String st_note;
	
	public int getSt_no() {
		return st_no;
	}
	public void setSt_no(int st_no) {
		this.st_no = st_no;
	}
	public String getMa_code() {
		return ma_code;
	}
	public void setMa_code(String ma_code) {
		this.ma_code = ma_code;
	}
	public int getSt_ea() {
		return st_ea;
	}
	public void setSt_ea(int st_ea) {
		this.st_ea = st_ea;
	}
	public LocalDateTime getSt_recDate() {
		return st_recDate;
	}
	public void setSt_recDate(LocalDateTime st_recDate) {
		this.st_recDate = st_recDate;
	}
	public String getSt_note() {
		return st_note;
	}
	public void setSt_note(String st_note) {
		this.st_note = st_note;
	}
	
	
}
