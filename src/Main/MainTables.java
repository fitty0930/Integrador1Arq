package Main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import ClienteDao.ClienteDAOMySql;
import FacturaDao.FacturaDAOMySql;
import FacturaProductoDao.FacturaProductoDAOMySql;
import ProductoDao.ProductoDAOMySql;
import daoSql.CrudDao;
import factories.DAOFactory;
import pojo.Cliente;
import pojo.Factura;
import pojo.Factura_producto;
import pojo.Producto;

public class MainTables {

	public static void main(String[] args) throws SQLException {
		DAOFactory factory = DAOFactory.getDaoFactory(DAOFactory.SQL);
		ClienteDAOMySql daoCliente = (ClienteDAOMySql) factory.getClienteDAO();
		FacturaDAOMySql daoFactura = (FacturaDAOMySql) factory.getFacturaDAO();
		ProductoDAOMySql daoProducto = (ProductoDAOMySql) factory.getProductoDAO();
		FacturaProductoDAOMySql daoFacturaProducto = (FacturaProductoDAOMySql) factory.getFacturaProductoDAO();
		CSVaMySql csvs = new CSVaMySql();

		try {
			daoCliente.createTables();
			daoFactura.createTables();
			daoProducto.createTables();
			daoFacturaProducto.createTables();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ArrayList<Producto> productos = csvs.getProductos();
		ArrayList<Cliente> clientes = csvs.getClientes();
		ArrayList<Factura> facturas = csvs.getFacturas();
		ArrayList<Factura_producto> facturaProductos = csvs.getFacturasProductos();

		insertarLista(clientes, daoCliente);
		insertarLista(productos, daoProducto);
		insertarLista(facturas, daoFactura);
		insertarLista(facturaProductos, daoFacturaProducto);


		System.out.println("El producto que mas recaudo fue:");
		Producto p = daoProducto.getProductsForMoreCollections();
		System.out.println(p.toString());
		System.out.println("");
		System.out.println("");
		System.out.println("Los clientes que mas invirtieron en nuestro negocio son: ");
		ArrayList<Cliente> clienteList = daoCliente.clientSortByCollection();
		for(Cliente cliente:clienteList) {
			System.out.println(cliente.toString());
		}
	}

	public static <T> void insertarLista(ArrayList<T> Objects, CrudDao dao) {
		Iterator<T> listIterator = Objects.iterator();
		while (listIterator.hasNext()) {
			Object obj = listIterator.next();
			try {
				dao.create(obj);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	

}
