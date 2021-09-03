package ProductoDao;

import java.sql.SQLException;

import InterfacesyAbstracts.TableGenerator;
import daoSql.CrudDao;
import pojo.Producto;

/**
 * 
 * @author Grupo 15: Benjamin, Franco y Martin
 *
 */
public interface ProductoDAOInterface extends CrudDao<Producto, Integer>, TableGenerator {
	// TO DO
	
	Producto getProductsForMoreCollections() throws SQLException;
	
	
	
}
