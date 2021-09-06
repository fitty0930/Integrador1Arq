package daoSql;

import java.sql.SQLException;
import java.util.List;

/**
 * Esta interfaz nos permite definir los metodos para las clases DAO
 * 
 * @author Grupo 15: Benjamin, Franco y Martin
 *
 */

public interface CrudDao<T, K> {

	/**
	 * Es el metodo que permite hacer inserciones de nuestros objetos en la base de
	 * datos
	 * 
	 * @param pojo recibe un objeto Cliente, Factura_producto, Factura y/o Producto
	 * @throws SQLException alerta de posibles errores en las consultas SQL
	 */
	void create(T pojo) throws SQLException;

	/**
	 * Es el metodo que permite eliminar entradas en la base de datos
	 * 
	 * @param id es el identificador del Objeto Java
	 * @return retorna verdadero si la consulta fue exitosa o falso si fallo
	 * @throws SQLException alerta de posibles errores en las consultas SQL
	 */
	boolean delete(K id) throws SQLException;

	/**
	 * Es el metodo que permite actualizar entradas en la base de datos
	 * 
	 * @param id recibe el id de la entrada que se quiere actualizar
	 * @throws SQLException alerta de posibles errores en las consultas SQL
	 */
	void update(K id) throws SQLException;

	/**
	 * Es el metodo que permite consultar la base de datos por una entrada en
	 * especifico
	 * 
	 * @param id es el identificador de la tupla
	 * @return retorna un objeto del tipo consultado
	 * @throws SQLException alerta de posibles errores en las consultas SQL
	 */
	T get(K id) throws SQLException;

	/**
	 * Es el metodo que permite consultar varias entradas en la base de datos
	 * 
	 * @return retorna una lista de los objetos del tipo consultado
	 * @throws SQLException alerta de posibles errores en las consultas SQL
	 */
	List<T> getAll() throws SQLException;
}
