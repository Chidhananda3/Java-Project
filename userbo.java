package projectbo;

import java.util.List;

import com.tap.modules.user;

public interface userbo {
	int save(user u);
	int delete(int userid);
	int delete(user u);
	int update(user u);
	user get(int id);
	List<user>getAll();

}
