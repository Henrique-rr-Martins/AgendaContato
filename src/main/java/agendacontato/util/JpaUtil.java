package agendacontato.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * 20/12/2020
 * Classe de suporte a manipulação do banco de dados.
 * @author Henrique Martins
 */
public class JpaUtil {
	
	//Fabrica de entidades de manipulação de banco
	private static EntityManagerFactory fabrica;
	
	static {
		fabrica = Persistence.createEntityManagerFactory("CONTATOS");
	}
	
	/**
	 * Cria e retorna uma entidade de manipulação do banco de dados.
	 * @return EntityManager
	 */
	public static EntityManager criaEntityManager() {
		return fabrica.createEntityManager();
	}
	
	/**
	 * Finaliza a EntityManagerFactory.
	 *  
	 * NOTA: Usando esse método torna a classe
	 *       inútil para qualquer outra conexão que você quiser tentar criar.
	 */
	public static void fechaConexao() {
		fabrica.close();
	}
}
