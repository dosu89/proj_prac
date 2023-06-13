package erp_ver1;

import java.util.List;

public interface DBcrud {
	
	public boolean insert(Object dto);
	
	public List<Object> getData();
	
	public boolean update(Object dto);
	
	public boolean dalete(Object dto);
}
