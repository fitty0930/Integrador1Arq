package pojo;

public class Factura_producto {

	private int idFactura;
	private int idCliente;

	public Factura_producto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Factura_producto(int idFactura, int idCliente) {
		super();
		this.idFactura = idFactura;
		this.idCliente = idCliente;
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

}
