package agendacontato.controle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "MenuController")
@RequestScoped
public class MenuController {

	public String carregarCadastroCliente() {
		return "http://localhost:9090/AgendaContato/faces/paginas/cadastroCliente.xhtml?faces-redirect=true";
	}
}
