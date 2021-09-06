package FacturaDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import InterfacesyAbstracts.SQLConnection;
import pojo.Factura;

public class FacturaDAOMySql extends SQLConnection implements FacturaDAOInterface {

	public FacturaDAOMySql() {
	}

	@Override
	public void create(Factura pojo) throws SQLException {
		Connection conn = this.createConnection();
		String insert = "INSERT INTO factura (idFactura, idCliente) VALUES (?, ?)";
		PreparedStatement ps = conn.prepareStatement(insert);
		ps.setInt(1, pojo.getIdFactura());
		ps.setInt(2, pojo.getIdCliente());
		ps.executeUpdate();
		ps.close();
		conn.commit();
		this.closeConnection(conn);
	}

	@Override
	public boolean delete(Integer id) throws SQLException {
		Connection conn = this.createConnection();
		String delete = "DELETE FROM factura WHERE idCliente=?";
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
	public Factura get(Integer id) throws SQLException {
		Connection conn = this.createConnection();
		String get = "SELECT FROM factura WHERE idFactura=?";
		PreparedStatement ps = conn.prepareStatement(get);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery(get);
		ps.close();
		conn.commit();
		this.closeConnection(conn);
		Factura f;
		if (rs.next()) {
			f = new Factura(rs.getInt(1), rs.getInt(2));
			return f;
		} else {
			return null;
		}
	}

	@Override
	public List<Factura> getAll() throws SQLException {
		Connection conn = this.createConnection();
		String getAll = "SELECT * FROM factura";
		PreparedStatement ps = conn.prepareStatement(getAll);
		ResultSet rs = ps.executeQuery(getAll);
		conn.commit();
		ArrayList<Factura> facturaList = new ArrayList<Factura>();
		while (rs.next()) {
			Factura f = new Factura(rs.getInt(1), rs.getInt(2));
			facturaList.add(f);
		}
		ps.close();
		this.closeConnection(conn);
		return facturaList;
	}

	@Override
	public void createTables() throws SQLException {
		Connection conn = this.createConnection();
		String table = "CREATE TABLE IF NOT EXISTS factura(" + "idFactura int ," + "idCliente int NOT NULL,"
				+ "PRIMARY KEY(idFactura)," + "FOREIGN KEY (idCliente) REFERENCES cliente(idCliente))";
		conn.prepareStatement(table).execute();
		conn.commit();
		this.closeConnection(conn);
	}

}
