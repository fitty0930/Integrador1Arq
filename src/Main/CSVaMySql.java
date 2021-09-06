package Main;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import pojo.Cliente;
import pojo.Factura;
import pojo.Factura_producto;
import pojo.Producto;

/**
 * Esta clase nos permite importar los archivos CSV y retornarlos como listas
 * 
 * @author Grupo 15: Benjamin, Franco y Martin
 *
 */
public class CSVaMySql {
	ArrayList<Producto> productos;

	public CSVaMySql() {
		this.productos = new ArrayList<Producto>();
		this.productos = this.importarCSVProducto();
	}

	public ArrayList<Producto> getProductos() {
		return this.productos;
	}

	/**
	 * Metodo que permite importar el archivo productos.csv
	 * 
	 * @return retorna una lista con todos los objetos producto importados
	 */
	@SuppressWarnings("deprecation")
	private ArrayList<Producto> importarCSVProducto() {
		ArrayList<Producto> fnProducts = new ArrayList<Producto>();
		CSVParser parser;
		try {
			parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader("productos.csv"));
			for (CSVRecord row : parser) {
				int idProducto = Integer.parseInt(row.get("idProducto"));
				float valor = Float.parseFloat(row.get("valor"));
				String nombre = row.get("nombre");
				Producto temp = new Producto(idProducto, nombre, valor);
				fnProducts.add(temp);
			}
			return fnProducts;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Metodo que permite importar el archivo clientes.csv
	 * 
	 * @return retorna una lista con todos los objetos cliente importados
	 */
	public ArrayList<Cliente> getClientes() {
		ArrayList<Cliente> fnCliente = new ArrayList<Cliente>();
		CSVParser parser;
		try {
			parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader("clientes.csv"));
			for (CSVRecord row : parser) {
				String nombre = row.get("nombre");
				String mail = row.get("email");
				Cliente temp = new Cliente(nombre, mail);
				fnCliente.add(temp);
			}
			return fnCliente;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Metodo que permite importar el archivo facturas.csv
	 * 
	 * @return retorna una lista con todos los objetos factura importados
	 */
	public ArrayList<Factura> getFacturas() {
		ArrayList<Factura> fnFacturas = new ArrayList<Factura>();
		CSVParser parser;
		try {
			parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader("facturas.csv"));
			for (CSVRecord row : parser) {
				int idFactura = Integer.parseInt(row.get("idFactura"));
				int idCliente = Integer.parseInt(row.get("idCliente"));
				Factura temp = new Factura(idFactura, idCliente);
				fnFacturas.add(temp);
			}
			return fnFacturas;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Metodo que permite importar el archivo factura_producto.csv
	 * 
	 * @return retorna una lista con todos los objetos factura_producto importados
	 */
	public ArrayList<Factura_producto> getFacturasProductos() {
		ArrayList<Factura_producto> fnFacturasProductos = new ArrayList<Factura_producto>();
		CSVParser parser;
		try {
			parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader("facturas-productos.csv"));
			for (CSVRecord row : parser) {
				int idFactura = Integer.parseInt(row.get("idFactura"));
				int idProducto = Integer.parseInt(row.get("idProducto"));
				int cantidad = Integer.parseInt(row.get("cantidad"));
				Factura_producto temp = new Factura_producto(idFactura, idProducto, cantidad);
				fnFacturasProductos.add(temp);
			}
			return fnFacturasProductos;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
