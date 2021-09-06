package factories;

import ClienteDao.ClienteDAOInterface;
import ClienteDao.ClienteDAOMySql;
import FacturaDao.FacturaDAOInterface;
import FacturaDao.FacturaDAOMySql;
import FacturaProductoDao.FacturaProductoDAOInterface;
import FacturaProductoDao.FacturaProductoDAOMySql;
import ProductoDao.ProductoDAOInterface;
import ProductoDao.ProductoDAOMySql;

/**
 * 
 * @author Grupo 15: Benjamin, Franco y Martin
 *
 */
public class MYSQLDaoFactory  extends DAOFactory {

	@Override
	public ClienteDAOInterface getClienteDAO() {
		return new ClienteDAOMySql();
	}

	@Override
	public FacturaDAOInterface getFacturaDAO() {
		return new FacturaDAOMySql();
	}

	@Override
	public FacturaProductoDAOInterface getFacturaProductoDAO() {
		return new FacturaProductoDAOMySql();
	}

	@Override
	public ProductoDAOInterface getProductoDAO() {
		return new ProductoDAOMySql();
	}

	

}
