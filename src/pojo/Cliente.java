package pojo;

/**
 * 
 * @author Grupo 15: Benjamin, Franco y Martin
 *
 */
public class Cliente {

	private int idCliente;
	private String nombre;
	private String email;

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cliente(String nombre, String email) {
		super();
		this.nombre = nombre;
		this.email = email;
	}

	// solo para retornar
	public Cliente(int idCliente, String nombre, String email) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return idCliente;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + idCliente + ", nombre=" + nombre + ", email=" + email + "]";
	}

}
