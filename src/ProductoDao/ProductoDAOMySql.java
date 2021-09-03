package ProductoDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pojo.Producto;

/**
 * 
 * @author Grupo 15: Benjamin, Franco y Martin
 *
 */
public class ProductoDAOMySql implements ProductoDAOInterface {

	String driver;
	String uri;

	public ProductoDAOMySql() {
		this.driver = "com.mysql.cj.jdbc.Drive";
//		Apparently, to get version 5.1.33 of MySQL JDBC driver to work with UTC time zone, one has to specify the serverTimezone explicitly in the connection string.
		this.uri = "jdbc:mysql://localhost/integrador1?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	}

	private Connection createConnection() {
		Connection conn;
		try {
			conn = DriverManager.getConnection(uri, "root", "");
			conn.setAutoCommit(false);
			return conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	private boolean closeConnection(Connection conn) {
		try {
			conn.close();
			return conn.isClosed();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public void create(Producto pojo) throws SQLException {
		Connection conn = this.createConnection();
		String insert = "INSERT INTO producto (idProducto, nombre, valor) VALUES (?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(insert);
		ps.setInt(1, pojo.getIdProducto());
		ps.setString(2, pojo.getNombre());
		ps.setFloat(3, pojo.getValor());
		ps.executeUpdate();
		ps.close();
		conn.commit();
		this.closeConnection(conn);
	}

	@Override
	public boolean delete(Integer id) throws SQLException {
		Connection conn = this.createConnection();
		String delete = "DELETE FROM producto WHERE idProducto=?";
		PreparedStatement ps = conn.prepareStatement(delete);
		ps.setInt(1, id);
		int deleted = ps.executeUpdate();
		ps.close();
		conn.commit();
		this.closeConnection(conn);
		return deleted != 0;
	}

	@Override
	public void update(Integer id) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Producto> getAll() throws SQLException {
		Connection conn = this.createConnection();
		String getAll = "SELECT * FROM producto";
		PreparedStatement ps = conn.prepareStatement(getAll);
		ResultSet rs = ps.executeQuery(getAll);
		conn.commit();
		ArrayList<Producto> productoList = new ArrayList<Producto>();
		while (rs.next()) {
			Producto f = new Producto(rs.getInt(1), rs.getString(2), rs.getFloat(3));
			productoList.add(f);
		}
		ps.close();
		this.closeConnection(conn);
		return productoList;
	}

	@Override
	public Producto get(Integer id) throws SQLException {
		Connection conn = this.createConnection();
		String get = "SELECT FROM producto WHERE idProducto=?";
		PreparedStatement ps = conn.prepareStatement(get);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery(get);
		ps.close();
		conn.commit();
		this.closeConnection(conn);
		Producto p;
		if (rs.next()) {
			p = new Producto(rs.getInt(1), rs.getString(2), rs.getFloat(3));
			return p;
		} else {
			return null;
		}
	}

	@Override
	public Producto getProductsForMoreCollections() throws SQLException {
		Connection conn = this.createConnection();
		String getAll = "SELECT p.idProducto,p.nombre,p.valor,SUM(cantidad) as cantidad, SUM(cantidad)*p.valor AS total FROM producto p JOIN factura_producto fp ON p.idProducto = fp.idProducto GROUP BY p.idProducto ORDER BY total DESC LIMIT 1";
		PreparedStatement ps = conn.prepareStatement(getAll);
		ResultSet rs = ps.executeQuery(getAll);
		conn.commit();
		if (rs.next()) {
			Producto p = new Producto(rs.getInt(1), rs.getString(2), rs.getFloat(3));
			this.closeConnection(conn);
			ps.close();
			return p;
		} else {
			return null;
		}
//		https://stackoverflow.com/questions/2120255/resultset-exception-before-start-of-result-set
	}

	@Override
	public void createTables() throws SQLException {
		Connection conn = this.createConnection();
		String table = "CREATE TABLE IF NOT EXISTS producto(" + "idProducto int AUTO_INCREMENT," + "nombre VARCHAR(45),"
				+ "valor FLOAT," + "PRIMARY KEY(idProducto))";
		conn.prepareStatement(table).execute();
		conn.commit();
		this.closeConnection(conn);
	}
}
