package ClienteDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import InterfacesyAbstracts.SQLConnection;
import pojo.Cliente;
/**
 * 
 * @author Grupo 15: Benjamin, Franco y Martin
 *
 */
public class ClienteDAOMySql extends SQLConnection implements ClienteDAOInterface {
	String driver;
	String uri;

	public ClienteDAOMySql() {
	}

	@Override
	public void create(Cliente pojo) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = this.createConnection();
		String insert = "INSERT INTO cliente (nombre, email) VALUES (?, ?)";
		PreparedStatement ps = conn.prepareStatement(insert);
		ps.setString(1, pojo.getNombre());
		ps.setString(2, pojo.getEmail());
		ps.executeUpdate();
		ps.close();
		conn.commit();
		this.closeConnection(conn);

	}

	@Override
	public boolean delete(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = this.createConnection();
		String delete = "DELETE FROM cliente WHERE idCliente=?";
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
		Connection conn = this.createConnection();
		String update="UPDATE cliente"
				+ "SET nombre, email VALUES (?,?)"
				+ "WHERE idCliente=?;";
		PreparedStatement ps = conn.prepareStatement(update);
		ps.setInt(1, id);
		int updated= ps.executeUpdate();
		ps.close();
		conn.commit();
		this.closeConnection(conn);
		if(updated!=0) {
			System.out.println("Database updated successfully ");
		}
	    
	}

	@Override
	public Cliente get(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = this.createConnection();
		String get = "SELECT FROM cliente WHERE idCliente=?";
		PreparedStatement ps = conn.prepareStatement(get);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery(get);
		ps.close();
		conn.commit();
		this.closeConnection(conn);
		Cliente c;
		if (rs.next()) {
			c = new Cliente(rs.getString(2), rs.getString(3));
			return c;
		} else {
			return null;
		}
	}

	@Override
	public List<Cliente> getAll() throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = this.createConnection();
		String getAll = "SELECT * FROM cliente";
		PreparedStatement ps = conn.prepareStatement(getAll);
		ResultSet rs = ps.executeQuery(getAll);
		conn.commit();
		ArrayList<Cliente> clienteList = new ArrayList<Cliente>();
		while (rs.next()) {
			Cliente c = new Cliente(rs.getInt(1),rs.getString(2), rs.getString(3));
			clienteList.add(c);
		}
		ps.close();
		this.closeConnection(conn);
		return clienteList;
	}
	
	@Override
	public ArrayList<Cliente> clientSortByCollection() throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = this.createConnection();
		String getAll ="SELECT c.idCliente, c.nombre, c.email, SUM(fp.cantidad) as cantidad, SUM(fp.cantidad)*p.valor AS total FROM cliente c JOIN factura f ON (c.idCliente = f.idCliente) JOIN factura_producto fp ON f.idFactura = fp.idFactura JOIN producto p ON fp.idProducto = p.idProducto GROUP BY c.idCliente ORDER BY total DESC";
		PreparedStatement ps = conn.prepareStatement(getAll);
		ResultSet rs = ps.executeQuery(getAll);
		conn.commit();
		ArrayList<Cliente> clienteList = new ArrayList<Cliente>();
		while (rs.next()) {
			Cliente c = new Cliente(rs.getInt(1),rs.getString(2), rs.getString(3));
			clienteList.add(c);
		}
		ps.close();
		this.closeConnection(conn);
		return clienteList;
	}

	@Override
	public void createTables() throws SQLException {
		Connection conn = this.createConnection();
		String table = "CREATE TABLE IF NOT EXISTS cliente (" + "idCliente int AUTO_INCREMENT," + "nombre VARCHAR(500),"
				+ "email VARCHAR(150)," + "PRIMARY KEY(idCliente))";
		conn.prepareStatement(table).execute();
		conn.commit();
		this.closeConnection(conn);
	}
}
