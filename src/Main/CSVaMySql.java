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

public class CSVaMySql {
	ArrayList<Producto>productos;

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
//		ArrayList<Producto>productos=new ArrayList<Producto>();
//		this.productos = importarCSV();
//	}
	public CSVaMySql() {
		this.productos = new ArrayList<Producto>();
		this.productos = this.importarCSVProducto();
	}
	
	public ArrayList<Producto> getProductos(){
		return this.productos;
	}

	@SuppressWarnings("deprecation")
	private ArrayList<Producto> importarCSVProducto() {
		ArrayList<Producto>fnProducts = new ArrayList<Producto>();
		CSVParser parser;
		try {
			parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader("productos.csv"));
			for(CSVRecord row: parser) {
				int idProducto=Integer.parseInt(row.get("idProducto"));
				float valor= Float.parseFloat(row.get("valor"));
				String nombre =  row.get("nombre");
				Producto temp= new Producto( idProducto, nombre, valor);
				fnProducts.add(temp);
			}
			return fnProducts;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<Cliente> getClientes() {
		ArrayList<Cliente>fnCliente = new ArrayList<Cliente>();
		CSVParser parser;
		try {
			parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader("clientes.csv"));
			for(CSVRecord row: parser) {
				String nombre =  row.get("nombre");
				String mail =  row.get("email");
				Cliente temp= new Cliente( nombre, mail);
				fnCliente.add(temp);
			}
			return fnCliente;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<Factura> getFacturas() {
		ArrayList<Factura>fnFacturas = new ArrayList<Factura>();
		CSVParser parser;
		try {
			parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader("facturas.csv"));
			for(CSVRecord row: parser) {
				int idFactura  = Integer.parseInt(row.get("idFactura"));
				int idCliente = Integer.parseInt(row.get("idCliente"));
				Factura temp= new Factura(idFactura, idCliente);
				fnFacturas.add(temp);
			}
			return fnFacturas;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<Factura_producto> getFacturasProductos() {
		ArrayList<Factura_producto>fnFacturasProductos = new ArrayList<Factura_producto>();
		CSVParser parser;
		try {
			parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader("facturas-productos.csv"));
			for(CSVRecord row: parser) {
				int idFactura  = Integer.parseInt(row.get("idFactura"));
				int idProducto = Integer.parseInt(row.get("idProducto"));
				int cantidad = Integer.parseInt(row.get("cantidad"));
				Factura_producto temp= new Factura_producto(idFactura, idProducto, cantidad);
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
