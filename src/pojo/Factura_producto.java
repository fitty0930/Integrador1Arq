package pojo;

public class Factura_producto {

	private int idFactura;
	private int idCliente;
	private int cantidad;
	
	public Factura_producto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Factura_producto(int idFactura, int idCliente) {
		super();
		this.idFactura = idFactura;
		this.idCliente = idCliente;
	}
	public Factura_producto(int idFactura, int idCliente, int cantidad) {
		super();
		this.idFactura = idFactura;
		this.idCliente = idCliente;
		this.cantidad = cantidad;
	}

	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getCantidad() {
		// TODO Auto-generated method stub
		return cantidad;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad=cantidad;
	}

}
