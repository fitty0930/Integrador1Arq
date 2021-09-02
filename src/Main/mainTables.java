package Main;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

import ClienteDao.ClienteDAOMySql;
import FacturaDao.FacturaDAOMySql;
import FacturaProductoDao.FacturaProductoDAOMySql;
import ProductoDao.ProductoDAOMySql;
import factories.DAOFactory;
import pojo.Cliente;
import Main.CSVaMySql;

public class mainTables {

	public static void main(String[] args) {
		DAOFactory factory = DAOFactory.getDaoFactory(DAOFactory.SQL);
		ClienteDAOMySql daoCliente = (ClienteDAOMySql) factory.getClienteDAO();
		FacturaDAOMySql daoFactura = (FacturaDAOMySql) factory.getFacturaDAO();
		ProductoDAOMySql daoProducto = (ProductoDAOMySql) factory.getProductoDAO();
		FacturaProductoDAOMySql daoFacturaProducto = (FacturaProductoDAOMySql) factory.getFacturaProductoDAO();
		CSVaMySql csvs= new CSVaMySql();
		
		Cliente cliente1 = new Cliente("Juancin", "michi03@gmail.com");
		Cliente cliente2 = new Cliente("Vierilla", "vierArobacunas@gmail.com");

		try {
			daoCliente.createTables();
			daoFactura.createTables();
			daoProducto.createTables();
			daoFacturaProducto.createTables();
			daoCliente.create(cliente1);
			daoCliente.create(cliente2);

			List<Cliente> listPersona =  daoCliente.getAll();
			Iterator<Cliente> listIterator = listPersona.iterator();
			while(listIterator.hasNext()) {
				Cliente c = listIterator.next();
				System.out.println(c);
			}
			
			arrayList<Producto> productos= csvs.getProductos();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
