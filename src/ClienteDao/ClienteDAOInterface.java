package ClienteDao;

import java.sql.SQLException;
import java.util.ArrayList;

import InterfacesyAbstracts.TableGenerator;
import daoSql.CrudDao;
import pojo.Cliente;

public interface ClienteDAOInterface extends CrudDao<Cliente, Integer>, TableGenerator {
//	TO DO 
	ArrayList<Cliente> clientSortByCollection() throws SQLException;
}
