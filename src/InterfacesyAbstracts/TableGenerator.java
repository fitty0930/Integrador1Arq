package InterfacesyAbstracts;

import java.sql.SQLException;

/**
 * Esta interfaz nos permite definir los metodos para la creacion de tablas en
 * la base de datos
 * 
 * @author Grupo 15: Benjamin, Franco y Martin
 *
 */
public interface TableGenerator {

	void createTables() throws SQLException;
}
