package erp_ver1;

import java.time.LocalDateTime;
import java.util.List;

public class Ex {

	public static void main(String[] args) {
		Service serv = new Service();
		
		StockDTO sdto = new StockDTO(1, "원두", 10, 20, LocalDateTime.now(), LocalDateTime.of(2023, 5, 10, 12,10,05));
		
		serv.insertStock(sdto);
		System.out.println("ex 입력");
		
	}
	
}
