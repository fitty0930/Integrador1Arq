package ClienteDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.Cliente;

public class ClienteDAOMySql implements ClienteDAOInterface {
	String driver;
	String uri;

	public ClienteDAOMySql() {
		this.driver = "com.mysql.cj.jdbc.Driver";
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
	public void create(Cliente pojo) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = this.createConnection();
		String insert = "INSERT INTO cliente (idCliente, nombre, email) VALUES (?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(insert);
		ps.setInt(1, pojo.getId());
		ps.setString(2, pojo.getNombre());
		ps.setString(3, pojo.getEmail());
		ps.executeUpdate();
		ps.close();
		conn.commit();
		System.out.println("Created");
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
			Cliente c = new Cliente(rs.getString(2), rs.getString(3));
			clienteList.add(c);
		}
		ps.close();
		this.closeConnection(conn);
		return clienteList;
	}

	public void createTables() throws SQLException {
		Connection conn = this.createConnection();
		String table = "CREATE TABLE cliente (" + "idCliente int AUTO_INCREMENT," + "nombre VARCHAR(500),"
				+ "email VARCHAR(500)," + "PRIMARY KEY(idCliente))";
		conn.prepareStatement(table).execute();
		conn.commit();
		this.closeConnection(conn);
	}
}
