package py.una.bd;

import py.una.entidad.Cliente;

import java.sql.SQLException;
import java.util.List;

public class TestPersonaDAO {

	
	
	public static void main(String args[]) throws SQLException {
		
		ClienteDAO pdao = new ClienteDAO();
		
		
		pdao.insertar(new Cliente(500L, "Familiar", "25.5") );
		/*pdao.insertar(new Persona(201L,"Juan", "Lopez") );
		pdao.insertar(new Persona(202L,"Ana", "Iturbe") );
		pdao.insertar(new Persona(203L,"Jose", "Gomez") );
		
		
		pdao.actualizar(new Persona(201L,"Antonio", "Roman") );
		
		pdao.borrar(203L);
		*/
		//List<Persona> lista = pdao.seleccionarPorCedula(202L);
		
		List<Cliente> lista = pdao.seleccionar();
		
		
		for (Cliente p: lista){
			System.out.println(p.getIdcliente() + " " + p.getCliente() + " " + p.getCotizacion());
		}
	}
	
	
}
