package agendacontato.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import agendacontato.entidade.Cliente;
import agendacontato.entidade.ListaContato;
import agendacontato.entidade.TipoContato;
import agendacontato.servico.Fachada;
import agendacontato.util.JpaUtil;

public class TesteEntidade {

	public static void main(String[] args) {
		EntityManager em = JpaUtil.criaEntityManager();
		@SuppressWarnings("unused")
		EntityTransaction et = em.getTransaction();
		
		//TipoContato t = new TipoContato();
		//t.setDsContato("Teste");
		
		//et.begin();
		//em.persist(t);
		
		System.out.println(new Fachada().
				pesquisarListaContato(null));
		
		//et.commit();
		em.close();
	}
}
