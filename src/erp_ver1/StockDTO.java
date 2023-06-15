package erp_ver1;

import java.time.LocalDateTime;

public class StockDTO {
	private int s_no;
	private String m_code;
	private int s_amount;
	private int s_totalAmount;
	private LocalDateTime recDate;
	private LocalDateTime forwDate;
	
	public StockDTO() {}

	public StockDTO(int s_no, String m_code, int s_amount, int s_totalAmount, LocalDateTime recDate,
			LocalDateTime forwDate) {
		super();
		this.s_no = s_no;
		this.m_code = m_code;
		this.s_amount = s_amount;
		this.s_totalAmount = s_totalAmount;
		this.recDate = recDate;
		this.forwDate = forwDate;
	}

	public int getS_no() {
		return s_no;
	}

	public void setS_no(int s_no) {
		this.s_no = s_no;
	}

	public String getM_code() {
		return m_code;
	}

	public void setM_code(String m_code) {
		this.m_code = m_code;
	}

	public int getS_amount() {
		return s_amount;
	}

	public void setS_amount(int s_amount) {
		this.s_amount = s_amount;
	}

	public int getS_totalAmount() {
		return s_totalAmount;
	}

	public void setS_totalAmount(int s_totalAmount) {
		this.s_totalAmount = s_totalAmount;
	}

	public LocalDateTime getRecDate() {
		return recDate;
	}

	public void setRecDate(LocalDateTime recDate) {
		this.recDate = recDate;
	}

	public LocalDateTime getForwDate() {
		return forwDate;
	}

	public void setForwDate(LocalDateTime forwDate) {
		this.forwDate = forwDate;
	}
}
