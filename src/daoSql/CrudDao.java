package daoSql;

import java.sql.SQLException;
import java.util.List;

public interface CrudDao<T, K> {

	void create(T pojo) throws SQLException;

	boolean delete(K id) throws SQLException;

	void update(K id) throws SQLException;

	T get(K id) throws SQLException;

	List<T> getAll() throws SQLException;
}

