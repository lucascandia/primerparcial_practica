package py.una.entidad;
import java.util.ArrayList;
import java.util.List;

public class Cliente {

	Long idcliente;
	String cliente;
	String cotizacion;

	public Cliente(Long idcliente, String cliente, String cotizacion) {
		this.idcliente = idcliente;
		this.cliente = cliente;
		this.cotizacion = cotizacion;
	}

	public Cliente() {
	}

	public Long getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(Long idcliente) {
		this.idcliente = idcliente;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getCotizacion() {
		return cotizacion;
	}

	public void setCotizacion(String cotizacion) {
		this.cotizacion = cotizacion;
	}

	@Override
	public String toString() {
		return "Cliente{" +
				"id=" + idcliente +
				", cliente='" + cliente + '\'' +
				", cotizacion=" + cotizacion +
				'}';
	}
}
