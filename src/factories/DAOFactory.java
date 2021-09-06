package factories;

import ClienteDao.ClienteDAOInterface;
import FacturaDao.FacturaDAOInterface;
import FacturaProductoDao.FacturaProductoDAOInterface;
import ProductoDao.ProductoDAOInterface;

/**
 * 
 * @author Grupo 15: Benjamin, Franco y Martin
 *
 */
public abstract class DAOFactory {

	public static final int SQL = 1;
	public static final int DERBY = 2;
	
	
	public abstract ClienteDAOInterface getClienteDAO();
	public abstract FacturaDAOInterface getFacturaDAO();
	public abstract FacturaProductoDAOInterface getFacturaProductoDAO();
	public abstract ProductoDAOInterface getProductoDAO();


	public static DAOFactory getDaoFactory(int factory) {
		switch(factory) {
		
		case SQL: return new MYSQLDaoFactory();
//		case DERBY: return new DERBYDaoFactory();
		default: return null;
		}
	}
	
	
}
