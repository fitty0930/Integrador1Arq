import java.sql.SQLException;

import ClienteDao.ClienteDAOMySql;
import FacturaDao.FacturaDAOMySql;
import FacturaProductoDao.FacturaProductoDAOMySql;
import ProductoDao.ProductoDAOMySql;

public class mainTables {

	public static void main(String[] args) {
		ClienteDAOMySql test = new ClienteDAOMySql();
		FacturaDAOMySql testF = new FacturaDAOMySql();
		FacturaProductoDAOMySql testFP = new FacturaProductoDAOMySql();
		ProductoDAOMySql testP = new ProductoDAOMySql();

		try {
			test.createTables();
			testF.createTables();
			testP.createTables();
			testFP.createTables();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
