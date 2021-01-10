package agendacontato.entidade;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Schema:   CONTATOS
 * Entidade: Cliente
 * 
 * @author Henrique Martins
 *
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "Cliente")
@Table(name = "Cliente")
public class Cliente implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cpf", nullable=false)
	private String cpf = null;
	
	@Column(name="nome", nullable = false)
	private String nome = null;

	@Column(name="idade", nullable = false)
	private int    idade = 0;
	
	@Column(name="sexo", nullable = false)
	private String sexo = null;
	
	@Column(name="interesses", nullable = true)
	private String interesses = null;
	
	@OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER)
	private List<ListaContato> listaContato;
		
}
