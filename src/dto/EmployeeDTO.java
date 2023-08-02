package dto;

import java.time.LocalDate;

public class EmployeeDTO {
	private int e_no;
	private String e_name;
	private String e_position;
	private LocalDate e_joinDate = LocalDate.now();
	
	public EmployeeDTO() {}
	
	public EmployeeDTO(String e_name, String e_position) {
		super();
		this.e_name = e_name;
		this.e_position = e_position;
	}
	
	public EmployeeDTO(int e_no, String e_name, String e_position, LocalDate e_joinDate) {
		super();
		this.e_no = e_no;
		this.e_name = e_name;
		this.e_position = e_position;
		this.e_joinDate = e_joinDate;
	}

	public int getE_no() {
		return e_no;
	}

	public void setE_no(int e_no) {
		this.e_no = e_no;
	}

	public String getE_name() {
		return e_name;
	}

	public void setE_name(String e_name) {
		this.e_name = e_name;
	}

	public String getE_position() {
		return e_position;
	}

	public void setE_position(String e_position) {
		this.e_position = e_position;
	}

	public LocalDate getE_joinDate() {
		return e_joinDate;
	}

	public void setE_joinDate(LocalDate e_joinDate) {
		this.e_joinDate = e_joinDate;
	}
}
