package agendacontato.dao;

import java.util.List;

import agendacontato.entidade.Cliente;

/**
 * Entidade: Cliente
 * 
 * @author Henrique Martins
 *
 */
public interface ClienteDAO {
	/**
	 * 
	 * @param cliente
	 * @return 
	 * 	1. true se realizado com sucesso. 
	 *  2. false se o processo falhou.
	 */
	public boolean inserir(Cliente cliente);
	
	/**
	 * 
	 * @param cliente
	 * @return: 
	 * 	1. true se realizado com sucesso. 
	 *  2. false se o processo falhou.
	 */
	public boolean alterar(Cliente cliente);

	/**
	 * 
	 * @param cliente
	 * @return: 
	 * 	1. true se realizado com sucesso. 
	 *  2. false se o processo falhou.
	 */
	public boolean remover(Cliente cliente);

	/**
	 * 
	 * @param cliente
	 * @return: 
	 * 	1. Cliente se realizado com sucesso. 
	 *  2. null se o processo falhou.
	 */
	public Cliente pesquisar(String cpf);

	/**
	 * 
	 * @param cliente
	 * @return: 
	 * 	1. Cliente se realizado com sucesso. 
	 *  2. null se o processo falhou.
	 */
	public List<Cliente> pesquisar(Cliente cliente);
}
