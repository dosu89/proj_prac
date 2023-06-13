package erp_ver1;

import java.time.LocalDateTime;
import java.util.List;

public class Ex {

	public static void main(String[] args) {
		Service serv = new Service();
		
		StockDAO dao = new StockDAO();
		
		
		StockDTO sdto = new StockDTO(1, "원두", 10, 20, LocalDateTime.now(), LocalDateTime.of(2023, 5, 10, 12,10,05));
		if(dao.insert(sdto))
		System.out.println("ex 입력");
		
		System.out.println("깃허브 테스트");
		System.out.println("깃허브 테스트");
		System.out.println("깃허브 테스트");
		System.out.println("깃허브 테스트");
	}
	
}
