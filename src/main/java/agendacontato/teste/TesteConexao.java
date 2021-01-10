package agendacontato.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import agendacontato.entidade.Cliente;
import agendacontato.util.JpaUtil;

/**
 * Classe de teste de conexão com o banco de dados.
 * 
 * Definição de Schema em:
 *  1. persistence.xml
 *  2. JpaUtil
 *  
 * @author Henrique Martins
 *
 */
public class TesteConexao {
	public static void main(String [] args) {
		
		EntityManager em = JpaUtil.criaEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		
		//Codigo vai aqui
		//Criar um objeto que deseja persistir e passar para em.persist ou em.merge
		
		Cliente entity = new Cliente();
		
		entity.setCpf("1111111");
		entity.setNome("t2");
		entity.setIdade(28);
		entity.setSexo("f");
		
		System.out.println(em.find(Cliente.class, entity.getCpf()).getCpf());
		
		System.out.println(em.isOpen());
		
		et.commit();
		em.close();
	}

}
