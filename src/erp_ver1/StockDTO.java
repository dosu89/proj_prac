package erp_ver1;

import java.time.LocalDateTime;

public class StockDTO {
	private int rm_no;
	private String rm_name;
	private int rm_enExEa;
	private int rm_TotalEa;
	private LocalDateTime recDate;
	private LocalDateTime forwDate;
	
	public StockDTO() {}
	
	public StockDTO(int rm_no, String rm_name, int rm_enExEa, int rm_TotalEa, LocalDateTime recDate,
			LocalDateTime forwDate) {
		super();
		this.rm_no = rm_no;
		this.rm_name = rm_name;
		this.rm_enExEa = rm_enExEa;
		this.rm_TotalEa = rm_TotalEa;
		this.recDate = recDate;
		this.forwDate = forwDate;
	}

	public int getRm_no() {
		return rm_no;
	}
	public void setRm_no(int rm_no) {
		this.rm_no = rm_no;
	}
	public String getRm_name() {
		return rm_name;
	}
	public void setRm_name(String rm_name) {
		this.rm_name = rm_name;
	}
	public int getRm_enExEa() {
		return rm_enExEa;
	}
	public void setRm_enExEa(int rm_enExEa) {
		this.rm_enExEa = rm_enExEa;
	}
	public int getRm_TotalEa() {
		return rm_TotalEa;
	}
	public void setRm_TotalEa(int rm_TotalEa) {
		this.rm_TotalEa = rm_TotalEa;
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

	@Override
	public String toString() {
		return "StockDTO [rm_no=" + rm_no + ", rm_name=" + rm_name + ", rm_enExEa=" + rm_enExEa + ", rm_TotalEa="
				+ rm_TotalEa + ", recDate=" + recDate + ", forwDate=" + forwDate + "]";
	}
}
