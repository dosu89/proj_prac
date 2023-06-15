package erp_ver1;

import java.time.LocalDateTime;
import java.util.List;

public class Service {

		public void insertStock(StockDTO s) {
			StockDAO dao = new StockDAO();
			if (dao.insert(s)) {
				System.out.println("등록 완료");
			}
		}
		
		public void updateStock(StockDTO s) {
			StockDAO dao = new StockDAO();
			Object dto = s;
			s.setS_totalAmount(s.getS_totalAmount() + s.getS_amount());
			if (s.getS_amount() >= 0 ) {
				s.setRecDate(LocalDateTime.now());
			} else {
				s.setForwDate(LocalDateTime.now());
			}
			if (dao.update(dto)) {
				System.out.println("수정 완료");
			}
		}
		
		public List<StockDTO> selectAllStock() {
			StockDAO dao = new StockDAO();
			List<Object> list = dao.getData();
			@SuppressWarnings("unchecked")
			List<StockDTO> slist = (List<StockDTO>)(Object)list;
			return slist;
		}
		
		public void deleteStock(StockDTO s) {
			StockDAO dao = new StockDAO();
			if (dao.dalete(s)) {
				System.out.println("삭제 완료");
			}
		}
}
