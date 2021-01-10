package agendacontato.dao;

import java.util.List;

import agendacontato.entidade.TipoContato;

/**
 * Entidade: TipoContato
 * 
 * @author Henrique Martins
 *
 */
public interface TipoContatoDAO {
	/**
	 * 
	 * @param tipoContato
	 * @return 
	 * 	1. true se realizado com sucesso. 
	 *  2. false se o processo falhou.
	 */
	public boolean inserir(TipoContato tipoContato);
	
	/**
	 * 
	 * @param tipoContato
	 * @return: 
	 * 	1. true se realizado com sucesso. 
	 *  2. false se o processo falhou.
	 */
	public boolean alterar(TipoContato tipoContato);

	/**
	 * 
	 * @param tipoContato
	 * @return: 
	 * 	1. true se realizado com sucesso. 
	 *  2. false se o processo falhou.
	 */
	public boolean remover(TipoContato tipoContato);
	
	public List<TipoContato> pesquisar();

	/**
	 * 
	 * @param tipoContato
	 * @return 
	 * 	1. TipoContato se realizado com sucesso. 
	 *  2. null se o processo falhou.
	 */
	public TipoContato pesquisar(int tpContato);
	
	/**
	 * 
	 * @param dsContato
	 * @return
	 * 	1. TipoContato se realizado com sucesso. 
	 *  2. null se o processo falhou.
	 */
	public TipoContato pesquisar(String dsContato);

	/**
	 * 
	 * @param tipoContato
	 * @return 
	 * 	1. TipoContato se realizado com sucesso. 
	 *  2. null se o processo falhou.
	 */
	public List<TipoContato> pesquisar(TipoContato tipoContato);
}
