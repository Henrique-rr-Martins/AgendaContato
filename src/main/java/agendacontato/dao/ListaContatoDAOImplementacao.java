package agendacontato.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import agendacontato.entidade.ListaContato;
import agendacontato.util.JpaUtil;

/**
 * Entidade: ListaContato
 * 
 * @author Henrique Martins
 *
 */
public class ListaContatoDAOImplementacao implements ListaContatoDAO{
	/**
	 * 
	 * @param listaContato
	 * @return 
	 * 	1. true se realizado com sucesso. 
	 *  2. false se o processo falhou.
	 */
	public boolean inserir(ListaContato listaContato) {
		
		EntityManager em     = JpaUtil.criaEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(listaContato);
		
		et.commit();
		em.close();
		
		return true;
	}
	
	
	/**
	 * 
	 * @param listaContato
	 * @return: 
	 * 	1. true se realizado com sucesso. 
	 *  2. false se o processo falhou.
	 */
	public boolean alterar(ListaContato listaContato) {

		EntityManager em     = JpaUtil.criaEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		
		ListaContato existe = em.find(ListaContato.class, listaContato.getId());
		
		if(existe != null) {
			existe.setContato(listaContato.getContato());
			existe.setTipoContato(listaContato.getTipoContato());
			
			em.merge(existe);
			et.commit();
			em.close();
			
			return true;
		}
		
		return false;
	}
	
	/**
	 * 
	 * @param listaContato
	 * @return: 
	 * 	1. true se realizado com sucesso. 
	 *  2. false se o processo falhou.
	 */
	
	public boolean remover(ListaContato listaContato) {

		EntityManager em     = JpaUtil.criaEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		
		ListaContato existe = em.find(ListaContato.class, listaContato.getId());
		
		if(existe != null) {
			em.remove(existe);
			et.commit();
			em.close();
			
			return true;
		}
		
		return false;
	}


	/**
	 * 
	 * @param listaContato
	 * @return: 
	 * 	1. ListaContato se realizado com sucesso. 
	 *  2. null se o processo falhou.
	 */
	public ListaContato pesquisar(int id) {

		EntityManager em     = JpaUtil.criaEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		
		ListaContato existe = em.find(ListaContato.class, id);
		
		em.close();
		
		if(existe != null) {
			
			return existe;
		}
		
		return null;
	}

	/**
	 * 
	 * @param listaContato
	 * @return: 
	 * 	1. ListaContato se realizado com sucesso. 
	 *  2. null se o processo falhou.
	 */
	public List<ListaContato> pesquisar(ListaContato listaContato) {
		
		String sql = "from Lista_Contato lc JOIN FETCH lc.cliente JOIN FETCH lc.tipoContato";
		sql += criaFiltro(listaContato);
		
		EntityManager em     = JpaUtil.criaEntityManager();
		
		TypedQuery<ListaContato> query = em.createQuery(sql, ListaContato.class);
		
		List<ListaContato> listaResultado = query.getResultList();
		
		em.close();
		
		return listaResultado;
	}
	
	private String criaFiltro(ListaContato listaContato) {
		
		String filtro = " where 1=1";
		
		if(listaContato != null) {
			if(listaContato.getId() > 0) {
				
				filtro += " and lc.id = " + listaContato.getId();
			}else {
				if(listaContato.getContato() != null && !listaContato.getContato().isEmpty()) {
					
					filtro += " and lc.contato LIKE '%" + listaContato.getContato() + "%'";
				}
				
				//Filtro - Cliente
				if(listaContato.getCliente() != null && 
						listaContato.getCliente().getCpf() != null &&
						!listaContato.getCliente().getCpf().isEmpty()) {
					
					filtro += " and lc.cliente.cpf like '" + listaContato.getCliente().getCpf() + "'";
				}
				
				//Filtro - TipoContato
				if(listaContato.getTipoContato() != null &&
						listaContato.getTipoContato().getTpContato() > 0) {
					
					filtro += " and lc.tipoContato.tpContato = " + listaContato.getTipoContato().getTpContato() + ";";
				}
			}
		}
		
		return filtro;
	
	}
	
}
