package agendacontato.entidade;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Schema:   CONTATOS
 * Entidade: TIPO_CONTATO
 * 
 * @author Henrique Martins
 *
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "Tipo_Contato")
@Table(name = "Tipo_Contato")
public class TipoContato {
	
	@Id
	@GeneratedValue(generator = "S_TIPO_CONTATO")
	@SequenceGenerator( name           = "S_TIPO_CONTATO"
					  , sequenceName   = "S_TIPO_CONTATO"
					  , allocationSize = 1)
	@Column(name = "tp_contato", nullable = false)
	private int tpContato = 0;
	
	@Column(name = "ds_contato", nullable = false)
	private String dsContato = null;
	
	@OneToMany(mappedBy = "tipoContato", fetch = FetchType.EAGER)
	private List<ListaContato> listaContato = new ArrayList<ListaContato>();

}
