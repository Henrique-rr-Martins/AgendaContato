package agendacontato.servico;

import java.util.List;

import agendacontato.dao.ClienteDAO;
import agendacontato.dao.ClienteDAOImplementacao;
import agendacontato.dao.ListaContatoDAO;
import agendacontato.dao.ListaContatoDAOImplementacao;
import agendacontato.dao.TipoContatoDAO;
import agendacontato.dao.TipoContatoDAOImplementacao;
import agendacontato.entidade.Cliente;
import agendacontato.entidade.ListaContato;
import agendacontato.entidade.TipoContato;
import lombok.Data;

@Data
public class Fachada {
	
	private ClienteDAO      clienteDAO;
	private TipoContatoDAO  tipoContatoDAO;
	private ListaContatoDAO listaContatoDAO;
	
	public Fachada() {
		this.clienteDAO      = new ClienteDAOImplementacao();
		this.tipoContatoDAO  = new TipoContatoDAOImplementacao();
		this.listaContatoDAO = new ListaContatoDAOImplementacao();
	}
	
	
//	TIPOCONTATO - Ínicio
	public boolean inserirTipoContato(TipoContato tipoContato){
		
		TipoContato existe = this.tipoContatoDAO.pesquisar(tipoContato.getDsContato());
		
		if(existe == null)
				return this.tipoContatoDAO.inserir(tipoContato);
		
		return false;
	}
	
	public boolean alterarTipoContato(TipoContato tipoContato) {
		
		return this.tipoContatoDAO.alterar(tipoContato);
	}
	
	public boolean removerTipoContato(TipoContato tipoContato) {
		
		TipoContato existe = this.tipoContatoDAO.pesquisar(tipoContato.getDsContato());
		
		if(existe != null)
			return this.tipoContatoDAO.remover(tipoContato);
		
		return false;
	}
	
	public TipoContato pesquisarTipoContato(int tpContato) {
		
		return this.tipoContatoDAO.pesquisar(tpContato);
	}
	
	public List<TipoContato> pesquisarTipoContato(){
		
		return this.tipoContatoDAO.pesquisar();
	}
	
	public List<TipoContato> pesquisarTipoContato(TipoContato tipoContato){
		
		return this.tipoContatoDAO.pesquisar(tipoContato);
	}
//	TIPOCONTATO - Fim
//	CLIENTE - Início
	public boolean inserirCliente(Cliente cliente) {
		
		Cliente existe = this.clienteDAO.pesquisar(cliente.getCpf());
		
		if(existe == null) 
			return this.inserirCliente(cliente);

		return false;
	}
	
	public boolean alterarCliente(Cliente cliente) {
		
		System.out.println("FACHADA ALTERAR CLIENTE");
		
		return this.clienteDAO.alterar(cliente);
	}
	
	public boolean removerCliente(Cliente cliente) {

		Cliente existe = this.clienteDAO.pesquisar(cliente.getCpf());
		
		if(existe != null) 
			return this.clienteDAO.remover(cliente);
		
		return false;
	}
	
	public Cliente pesquisarCliente(String cpf) {
		
		return this.clienteDAO.pesquisar(cpf);
	}

	public List<Cliente> pesquisarCliente(Cliente cliente){
		
		return this.clienteDAO.pesquisar(cliente);
	}
//	CLIENTE - Fim
//  LISTACONTATO - Início
	public boolean inserirListaContato(ListaContato listaContato) {
		return this.listaContatoDAO.inserir(listaContato);
	}
	
	public boolean alterarListaContato(ListaContato listaContato) {
		return this.listaContatoDAO.alterar(listaContato);
	}
	
	public boolean removerListaContato(ListaContato listaContato) {
		return this.listaContatoDAO.remover(listaContato);
	}
	
	public ListaContato pesquisarListaContato(int id) {
		return this.listaContatoDAO.pesquisar(id);
	}
	
	public List<ListaContato> pesquisarListaContato(ListaContato listaContato){
		return this.listaContatoDAO.pesquisar(listaContato);
	}
//  LISTACONTATO - Fim
}
