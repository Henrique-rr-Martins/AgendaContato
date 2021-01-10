package agendacontato.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import agendacontato.entidade.Cliente;
import agendacontato.entidade.TipoContato;
import agendacontato.util.JpaUtil;

/**
 * Entidade: TipoContato
 * 
 * @author Henrique Martins
 *
 */
public class TipoContatoDAOImplementacao implements TipoContatoDAO {
	/**
	 * 
	 * @param tipoContato
	 * @return 
	 * 	1. true se realizado com sucesso. 
	 *  2. false se o processo falhou.
	 */
	public boolean inserir(TipoContato tipoContato) {
		
		EntityManager em     = JpaUtil.criaEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(tipoContato);
		
		et.commit();
		em.close();
		
		return true;
	}
	
	/**
	 * 
	 * @param tipoContato
	 * @return: 
	 * 	1. true se realizado com sucesso. 
	 *  2. false se o processo falhou.
	 */
	public boolean alterar(TipoContato tipoContato) {

		EntityManager em     = JpaUtil.criaEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		
		TipoContato existe = em.find(TipoContato.class, tipoContato.getTpContato());
		
		if(existe != null) {
			existe.setDsContato(tipoContato.getDsContato());
			
			em.merge(existe);
			et.commit();
			em.close();
			
			return true;
		}
		
		return false;
	}

	/**
	 * 
	 * @param tipoContato
	 * @return: 
	 * 	1. true se realizado com sucesso. 
	 *  2. false se o processo falhou.
	 */
	public boolean remover(TipoContato tipoContato) {

		EntityManager em     = JpaUtil.criaEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		
		TipoContato existe = em.find(TipoContato.class, tipoContato.getTpContato());
		
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
	 * @param tipoContato
	 * @return 
	 * 	1. TipoContato se realizado com sucesso. 
	 *  2. null se o processo falhou.
	 */
	public TipoContato pesquisar(int tpContato) {

		EntityManager em     = JpaUtil.criaEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		
		TipoContato existe = em.find(TipoContato.class, tpContato);
		
		em.close();
		
		if(existe != null) {
			
			return existe;
		}
		
		return null;
	}
	
	/**
	 * 
	 * @param dsContato
	 * @return
	 * 	1. TipoContato se realizado com sucesso. 
	 *  2. null se o processo falhou.
	 */
	public TipoContato pesquisar(String dsContato) {
		
		String sql = "from Tipo_Contato tc where 1=1 and ds_contato like ?";
		
		EntityManager em = JpaUtil.criaEntityManager();
		
		Query query = em.createQuery(sql);
		query.setParameter(1, dsContato);
		
		List<TipoContato> lista = query.getResultList();
		
		em.close();
		
		if(lista != null && lista.size() > 0) {
			return lista.get(0);
		}else {
			return null;
		}
		
	}
	
	public List<TipoContato> pesquisar(){
		String sql = "from Tipo_Contato tc where 1=1";
		
		EntityManager em = JpaUtil.criaEntityManager();
		
		Query query = em.createQuery(sql);
		
		List<TipoContato> listaTipoContato = query.getResultList();
		
		em.close();
		
		return listaTipoContato;
		
	}

	/**
	 * 
	 * @param tipoContato
	 * @return 
	 * 	1. TipoContato se realizado com sucesso. 
	 *  2. null se o processo falhou.
	 */
	public List<TipoContato> pesquisar(TipoContato tipoContato) {
		
		String sql = "from Tipo_Contato tc where 1=1";
		//Concatena o filtro do cliente passado
		//sql += criarFiltro(tipoContato);
		
		EntityManager em = JpaUtil.criaEntityManager();
		
		Query query = em.createQuery(sql);
		
		List<TipoContato> listaTipoContato = query.getResultList();
		
		em.close();
		
		return listaTipoContato;
	}
	
	private String criarFiltro(TipoContato tipoContato) {
		
		String sqlFiltro = " ";
		
		if(tipoContato.getTpContato() > 0) {
			sqlFiltro += " and tc.tp_contato = " + tipoContato.getTpContato();
		}else if(tipoContato.getDsContato() != null && !tipoContato.getDsContato().isEmpty()){
			sqlFiltro += " and tc.ds_contato LIKE '%" + tipoContato.getDsContato() + "%'";
		}
		
		return sqlFiltro;
	}
	
}
