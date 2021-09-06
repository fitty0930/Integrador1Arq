package pojo;

/**
 * 
 * @author Grupo 15: Benjamin, Franco y Martin
 *
 */
public class Factura {
	private int idFactura;
	private int idCliente;
	
	public Factura() {
		super();	
	}
	
	public Factura(int idFactura, int idCliente) {
		super();
		this.idFactura = idFactura;
		this.idCliente = idCliente;
	}

	public int getIdFactura() {
		return idFactura;
	}

	public int getIdCliente() {
		return idCliente;
	}
	
}
