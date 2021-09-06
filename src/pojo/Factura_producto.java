package pojo;

/**
 * 
 * @author Grupo 15: Benjamin, Franco y Martin
 *
 */
public class Factura_producto {

	private int idFactura;
	private int idProducto;
	private int cantidad;

	public Factura_producto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Factura_producto(int idFactura, int idProducto) {
		super();
		this.idFactura = idFactura;
		this.idProducto = idProducto;
	}

	public Factura_producto(int idFactura, int idProducto, int cantidad) {
		super();
		this.idFactura = idFactura;
		this.idProducto = idProducto;
		this.cantidad = cantidad;
	}

	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public int getidProducto() {
		return idProducto;
	}

	public void setidProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public int getCantidad() {
		// TODO Auto-generated method stub
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Factura_producto [idFactura=" + idFactura + ", idProducto=" + idProducto + ", cantidad=" + cantidad
				+ "]";
	}

}
