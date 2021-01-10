package agendacontato.controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import agendacontato.entidade.Cliente;
import agendacontato.servico.Fachada;
import lombok.Data;

/**
 * @author Henrique Martins
 */
@Data
@ManagedBean(name = "ClienteBean")
@ViewScoped
public class ClienteBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Cliente cliente = new Cliente();
	private List<Cliente> listaCliente = new ArrayList<Cliente>();
	
	private Fachada fachada = new Fachada();
	
	public void pesquisar() {
		this.listaCliente = this.fachada.pesquisarCliente(this.cliente);
	}
	
	public void remover(Cliente cliente) {
		System.out.println("removendo");
		this.fachada.removerCliente(cliente);
		this.pesquisar();
	}
	
	public void salvar() {
		System.out.println("Salvar");
		this.fachada.alterarCliente(this.cliente);
	}
	
}
