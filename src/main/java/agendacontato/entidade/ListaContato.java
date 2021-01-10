package agendacontato.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Schema:   CONTATOS
 * Entidade: LISTA_CONTATO
 * 
 * @author Henrique Martins
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "Lista_Contato")
@Table(name = "Lista_Contato")
public class ListaContato implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "S_LISTA_CONTATO")
	@SequenceGenerator( name           = "S_LISTA_CONTATO"
					  , sequenceName   = "S_LISTA_CONTATO"
					  , allocationSize = 1)
	@Column(name = "id", nullable = false)
	private int id = 0;
	
	@ManyToOne
	@JoinColumn(name = "cpf")
	private Cliente cliente = new Cliente();
	
	@ManyToOne
	@JoinColumn(name = "tp_contato")
	private TipoContato tipoContato = new TipoContato();
	
	@Column(name = "contato")
	private String contato = null;
	
	@Override
	public String toString() {
		return "Id: " + this.id + ", CPF: " + this.cliente.getCpf()
			+ ", TipoContato: " + this.tipoContato.getTpContato()
			+ ", Contato: " + this.contato;
	}
}