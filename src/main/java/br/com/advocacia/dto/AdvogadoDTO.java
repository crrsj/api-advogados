package br.com.advocacia.dto;

import java.util.List;

import br.com.advocacia.entidade.Advogado;
import br.com.advocacia.entidade.Cliente;
import br.com.advocacia.entidade.Compromisso;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AdvogadoDTO {


	    private Long id;	
	    @NotBlank(message = "Não pode estar em branco !")
	    private String nome;
	    @NotBlank(message = "Não pode estar em branco !")
	    private String email;
	    @NotBlank(message = "Não pode estar em branco !")
	    private String especialidade;
	    @NotBlank(message = "Não pode estar em branco !")
	    private String oab;
	    @NotBlank(message = "Não pode estar em branco !")
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
