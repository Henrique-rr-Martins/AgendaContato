package agendacontato.dao;

import java.util.List;

import agendacontato.entidade.ListaContato;

/**
 * Entidade: ListaContato
 * 
 * @author Henrique Martins
 *
 */
public interface ListaContatoDAO {
	/**
	 * 
	 * @param listaContato
	 * @return 
	 * 	1. true se realizado com sucesso. 
	 *  2. false se o processo falhou.
	 */
	public boolean inserir(ListaContato listaContato);
	
	/**
	 * 
	 * @param listaContato
	 * @return: 
	 * 	1. true se realizado com sucesso. 
	 *  2. false se o processo falhou.
	 */
	public boolean alterar(ListaContato listaContato);

	/**
	 * 
	 * @param listaContato
	 * @return: 
	 * 	1. true se realizado com sucesso. 
	 *  2. false se o processo falhou.
	 */
	public boolean remover(ListaContato listaContato);

	/**
	 * 
	 * @param listaContato
	 * @return: 
	 * 	1. ListaContato se realizado com sucesso. 
	 *  2. null se o processo falhou.
	 */
	public ListaContato pesquisar(int id);

	/**
	 * 
	 * @param listaContato
	 * @return: 
	 * 	1. ListaContato se realizado com sucesso. 
	 *  2. null se o processo falhou.
	 */
	public List<ListaContato> pesquisar(ListaContato listaContato);
}
