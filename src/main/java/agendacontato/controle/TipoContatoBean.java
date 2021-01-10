package agendacontato.controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import agendacontato.entidade.TipoContato;
import agendacontato.servico.Fachada;
import lombok.Data;

@Data
@ManagedBean(name = "TipoContatoBean")
@ViewScoped
public class TipoContatoBean {
	
	private TipoContato tipoContato;
	private List<TipoContato> listaTipoContato;
	private Fachada fachada;
	
	public TipoContatoBean() {
		this.fachada = new Fachada();
		this.tipoContato = new TipoContato();
		this.listaTipoContato = new ArrayList<TipoContato>();
		this.pesquisar();
	
	}
	
	public void pesquisar() {
		this.listaTipoContato = fachada.pesquisarTipoContato(tipoContato); 
	}
	
	public void salvar() {
		this.fachada.inserirTipoContato(tipoContato);
		this.tipoContato = new TipoContato();
		
		this.pesquisar();
	}
	
	public void remover(TipoContato tipoContato) {
		
		this.fachada.removerTipoContato(tipoContato);
		this.pesquisar();
	}
}
