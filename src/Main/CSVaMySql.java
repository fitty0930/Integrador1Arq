package Main;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import pojo.Producto;

public class CSVaMySql {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Producto>productos=new ArrayList<Producto>();
		productos = importarCSV();
	}

	@SuppressWarnings("deprecation")
	private static List<Producto> importarCSV() {
		// TODO Auto-generated method stub
		List<Producto>productos=new ArrayList<Producto>();
		
		CSVParser parser;
		try {
			parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader("productos.csv"));
			for(CSVRecord row: parser) {
				int idProducto=Integer.parseInt(row.get("idProducto"));
				float valor= Float.parseFloat(row.get("valor"));
				Producto temp= new Producto( idProducto, row.get("nombre"), valor);
				System.out.println(temp.toString());
//				System.out.println(row.get("idProducto"));
//				System.out.println(row.get("nombre"));
//				System.out.println(row.get("valor"));
				}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

				
		
		return null;
	}
	
	
	
}
