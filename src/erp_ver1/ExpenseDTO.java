package erp_ver1;

import java.time.LocalDateTime;

public class ExpenseDTO {
	private int e_no;
	private String e_name;
	private int e_ea;
	private int e_price;
	private LocalDateTime e_date;
	
	public ExpenseDTO() {}
	
	public ExpenseDTO(int e_no, String e_name, int e_ea, int e_price, LocalDateTime e_date) {
		super();
		this.e_no = e_no;
		this.e_name = e_name;
		this.e_ea = e_ea;
		this.e_price = e_price;
		this.e_date = e_date;
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
	public int getE_ea() {
		return e_ea;
	}
	public void setE_ea(int e_ea) {
		this.e_ea = e_ea;
	}
	public int getE_price() {
		return e_price;
	}
	public void setE_price(int e_price) {
		this.e_price = e_price;
	}
	public LocalDateTime getE_date() {
		return e_date;
	}
	public void setE_date(LocalDateTime e_date) {
		this.e_date = e_date;
	}

	@Override
	public String toString() {
		return "ExpenseDTO [e_no=" + e_no + ", e_name=" + e_name + ", e_ea=" + e_ea + ", e_price=" + e_price
				+ ", e_date=" + e_date + "]";
	}
}
