package py.una.entidad;
import java.util.ArrayList;
import java.util.List;

public class Cliente {

	Long idcliente;
	String cliente;
	String moneda;
	String valor_compra;
	String valor_venta;



	public Cliente() {
	}

	public Cliente(Long idcliente, String cliente, String moneda, String valor_compra, String valor_venta) {
		this.idcliente = idcliente;
		this.cliente = cliente;
		this.moneda = moneda;
		this.valor_compra = valor_compra;
		this.valor_venta = valor_venta;
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

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public String getValor_compra() {
		return valor_compra;
	}

	public void setValor_compra(String valor_compra) {
		this.valor_compra = valor_compra;
	}

	public String getValor_venta() {
		return valor_venta;
	}

	public void setValor_venta(String valor_venta) {
		this.valor_venta = valor_venta;
	}

	@Override
	public String toString() {
		return "Cliente{" +
				"idcliente=" + idcliente +
				", cliente='" + cliente + '\'' +
				", moneda='" + moneda + '\'' +
				", valor_compra='" + valor_compra + '\'' +
				", valor_venta='" + valor_venta + '\'' +
				'}';
	}
}
