package br.com.advocacia.dto;

import java.util.List;

import br.com.advocacia.entidade.Advogado;
import br.com.advocacia.entidade.Cliente;
import br.com.advocacia.entidade.Compromisso;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AdvogadoDTO {


	   private Long id;	
	    private String nome;
	    private String email;
	    private String especialidade;
	    private String oab;
	    private String estado;	    
	    private List<Compromisso>compromissos;
	    private List<Cliente>clientes;
	    
		
		public AdvogadoDTO(Advogado cadastrar) {
			this.id = cadastrar.getId();
			this.nome = cadastrar.getNome();
			this.email = cadastrar.getEmail();
			this.especialidade = cadastrar.getEspecialidade();
			this.oab = cadastrar.getOab();
			this.estado = cadastrar.getEstado();
			this.compromissos = cadastrar.getCompromissos();
			this.clientes = cadastrar.getClientes();
		}
}
