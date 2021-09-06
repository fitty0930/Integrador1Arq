package InterfacesyAbstracts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Esta clase abstracta nos permite generalizar la conexión a la base de datos
 * MySql a todos los objetos DAO
 * 
 * @author Grupo 15: Benjamin, Franco y Martin
 *
 */

public abstract class SQLConnection {
	protected String driver = "com.mysql.cj.jdbc.Driver";
	protected String uri = "jdbc:mysql://localhost/integrador1?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

	/**
	 * Este metodo permite hacer la conexión a la base de datos
	 * 
	 * @return una conexión a la base de datos
	 */
	protected Connection createConnection() {
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

	/**
	 * Este metodo permite cerrar la conexión
	 * 
	 * @param conn es la conexión a cerrar
	 * @return retorna true si se pudo cerrar la conexion o caso contrario retorna
	 *         false
	 */
	protected boolean closeConnection(Connection conn) {
		try {
			conn.close();
			return conn.isClosed();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
