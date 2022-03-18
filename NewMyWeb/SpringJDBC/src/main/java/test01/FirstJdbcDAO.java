package test01;

public interface FirstJdbcDAO {
	int insert(String code, String name, int price, String maker);
	void execute(String sql);
	int delete(String name);
}
