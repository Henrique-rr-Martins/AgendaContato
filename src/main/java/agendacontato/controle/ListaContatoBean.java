package agendacontato.controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import agendacontato.entidade.ListaContato;
import agendacontato.servico.Fachada;
import lombok.Data;

@Data
@ManagedBean(name = "ListaContatoBean")
@ViewScoped
public class ListaContatoBean {

	@ManagedProperty(value="#{ClienteBean}")
	private ClienteBean clienteBean;
	
	@ManagedProperty(value="#{TipoContatoBean}")
	private TipoContatoBean tipoContatoBean;
	
	private ListaContato listaContato = new ListaContato();
	private Fachada fachada = new Fachada();
	
	
	private List<ListaContato> listaListaContato = new ArrayList<ListaContato>(); 
	
	public ListaContatoBean() {
		this.pesquisar();
	}
	
	public void pesquisar() {
		if(this.clienteBean != null && 
				this.clienteBean.getCliente() != null &&
				this.clienteBean.getCliente().getCpf() != null  && 
				!this.clienteBean.getCliente().getCpf().isEmpty()) {
			this.listaContato.setCliente(clienteBean.getCliente());
			this.listaListaContato = this.fachada.pesquisarListaContato(listaContato);
		}
	}
	
	public void salvar() {
		
		if(this.clienteBean.getCliente().getCpf() != null && !this.clienteBean.getCliente().getCpf().isEmpty()) {
			System.out.println("tem cpf");
			this.listaContato.setCliente(this.fachada.pesquisarCliente(clienteBean.getCliente().getCpf()));
		}
		
		if(this.tipoContatoBean.getTipoContato().getTpContato() > 0) {
			System.out.println("tem tipo");
			this.listaContato.setTipoContato(this.fachada.pesquisarTipoContato(tipoContatoBean.getTipoContato().getTpContato()));
		}
		
		if(this.listaContato.getCliente().getCpf() != null && 
				!this.listaContato.getCliente().getCpf().isEmpty() &&
				this.listaContato.getTipoContato().getTpContato() > 0) {
			System.out.println("TENTANDO SALVAR");
			this.fachada.inserirListaContato(listaContato);
		}
		
		this.listaContato = new ListaContato();
		
		this.pesquisar();
	}
	
	public void remover(ListaContato listaContato) {
		this.fachada.removerListaContato(listaContato);
		
		this.pesquisar();
	}
}
