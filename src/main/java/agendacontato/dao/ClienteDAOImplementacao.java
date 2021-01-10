package agendacontato.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import agendacontato.entidade.Cliente;
import agendacontato.util.JpaUtil;

/**
 * Entidade: Cliente
 * 
 * @author Henrique Martins
 *
 */
public class ClienteDAOImplementacao implements ClienteDAO {
	/**
	 * 
	 * @param cliente
	 * @return 
	 * 	1. true se realizado com sucesso. 
	 *  2. false se o processo falhou.
	 */
	public boolean inserir(Cliente cliente) {
		
		EntityManager em     = JpaUtil.criaEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(cliente);
		
		et.commit();
		em.close();
		
		return true;
	}
	
	/**
	 * 
	 * @param cliente
	 * @return
	 * 	1. true se realizado com sucesso. 
	 *  2. false se o processo falhou.
	 */
	public boolean alterar(Cliente cliente) {
		
		System.out.println("DAO ALTERAR");
		
		EntityManager em     = JpaUtil.criaEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
			
		em.merge(cliente);
		et.commit();
		em.close();
		
		return true;
	}

	/**
	 * 
	 * @param cliente
	 * @return
	 * 	1. true se realizado com sucesso. 
	 *  2. false se o processo falhou.
	 */
	public boolean remover(Cliente cliente) {

		EntityManager em     = JpaUtil.criaEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Cliente existe = em.find(Cliente.class, cliente.getCpf());
		
		if(existe != null) {

			et.begin();
			em.remove(existe);
			et.commit();
			em.close();
			
			return true;
		}
		
		return false;
	}

	/**
	 * 
	 * @param cliente
	 * @return
	 * 	1. Cliente se realizado com sucesso. 
	 *  2. null se o processo falhou.
	 */
	public Cliente pesquisar(String cpf) {

		EntityManager em     = JpaUtil.criaEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		
		Cliente existe = em.find(Cliente.class, cpf);
		
		em.close();
		
		if(existe != null) {
			
			return existe;
		}
		
		return null;
	}

	/**
	 * 
	 * @param cliente
	 * @return
	 * 	1. Cliente se realizado com sucesso. 
	 *  2. null se o processo falhou.
	 */
	public List<Cliente> pesquisar(Cliente cliente){
		
		String sql = "from Cliente c where 1=1 ";
		//Cocatena o filtro do cliente passado
		sql += criarFiltro(cliente);
		
		EntityManager em = JpaUtil.criaEntityManager();
		
		Query query = em.createQuery(sql);
		
		List<Cliente> listaCliente = query.getResultList();
		
		em.close();
		
		return listaCliente;
	}
	
	/**
	 * Usado junto com a pesquisa que retorna lista para criar o filtro
	 * para o cliente específico passado como parâmetro
	 * 
	 * @param cliente
	 * @return String
	 */
	private String criarFiltro(Cliente cliente) {
		
		String filtro= " ";
		
		if(cliente.getCpf() != null && !cliente.getCpf().isEmpty()) {
			filtro += " and c.cpf = '" + cliente.getCpf() + "'";
		}else {
			if(cliente.getNome() != null && !cliente.getNome().isEmpty()) {
				filtro += " and c.nome LIKE '%" + cliente.getNome() + "%'";
			}
			if(cliente.getIdade() > 0) {
				filtro += " and c.idade = " + cliente.getIdade();
			}
			if(cliente.getSexo() != null && !cliente.getSexo().isEmpty()) {
				filtro += " and c.sexo like '%" + cliente.getSexo() + "%'";
			}
		}
		
		return filtro;
	}
}
