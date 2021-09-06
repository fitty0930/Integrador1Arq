package ClienteDao;

import java.sql.SQLException;
import java.util.ArrayList;

import InterfacesyAbstracts.TableGenerator;
import daoSql.CrudDao;
import pojo.Cliente;

/**
 * 
 * 
 * @author Grupo 15: Benjamin, Franco y Martin
 *
 */

public interface ClienteDAOInterface extends CrudDao<Cliente, Integer>, TableGenerator {

	/**
	 * Este es el metodo pedido para imprimir la lista de cliente ordenada por a
	 * cual se le facturo mas
	 * 
	 * @return retorna una lista de clientes
	 * @throws SQLException avisa errores de sql
	 */
	ArrayList<Cliente> clientSortByCollection() throws SQLException;
}
