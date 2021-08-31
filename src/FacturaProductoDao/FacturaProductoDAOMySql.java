package FacturaProductoDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.Factura;
import pojo.Factura_producto;

public class FacturaProductoDAOMySql implements FacturaProductoDAOInterface {
	
	String driver;
	String uri;

	public FacturaProductoDAOMySql() {
		this.driver = "com.mysql.cj.jdbc.Drive";
		this.uri = "jdbc:mysql://localhost:3306/integrador1";
	}

	private Connection createConnection() {
		Connection conn;
		try {
			conn = DriverManager.getConnection(uri, "root", ""); // cambiar
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
	public void create(Factura_producto pojo) throws SQLException {
		Connection conn = this.createConnection();
		String insert = "INSERT INTO factura_producto (idFactura, idCliente, cantidad) VALUES (?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(insert);
		ps.setInt(1, pojo.getIdFactura());
		ps.setInt(2, pojo.getIdCliente());
		ps.setInt(3, pojo.getCantidad());
		ps.executeUpdate();
		ps.close();
		conn.commit();
		this.closeConnection(conn);
	}

	@Override
	public boolean delete(Integer id) throws SQLException {
		Connection conn = this.createConnection();
		String delete = "DELETE FROM factura_producto WHERE idFactura=?";
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
	public Factura_producto get(Integer id) throws SQLException {
		Connection conn = this.createConnection();
		String get = "SELECT FROM factura_producto WHERE idFactura=?";
		PreparedStatement ps = conn.prepareStatement(get);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery(get);
		ps.close();
		conn.commit();
		this.closeConnection(conn);
		Factura_producto f;
		if (rs.next()) {
			f = new Factura_producto(rs.getInt(1), rs.getInt(2),rs.getInt(3));
			return f;
		} else {
			return null;
		}
	}

	@Override
	public List<Factura_producto> getAll() throws SQLException {
		Connection conn = this.createConnection();
		String getAll = "SELECT * FROM factura";
		PreparedStatement ps = conn.prepareStatement(getAll);
		ResultSet rs = ps.executeQuery(getAll);
		conn.commit();
		ArrayList<Factura_producto> facturaProductoList = new ArrayList<Factura_producto>();
		while (rs.next()) {
			Factura_producto f = new Factura_producto(rs.getInt(1), rs.getInt(2), rs.getInt(3));
			facturaProductoList.add(f);
		}
		ps.close();
		this.closeConnection(conn);
		return facturaProductoList;
	}
	
	public void createTables() throws SQLException {
		Connection conn = this.createConnection();
		String table = "CREATE TABLE  factura_producto(" +
				        "idFactura int NOT NULL," +
				        "idProducto int NOT NULL," +
				        "cantidad int," +
				        "FOREIGN KEY (idFactura) REFERENCES factura(idFactura),"+
				        "FOREIGN KEY (idProducto) REFERENCES producto(idProducto))";
		conn.prepareStatement(table).execute();
		conn.commit();
		this.closeConnection(conn);
	}
}
