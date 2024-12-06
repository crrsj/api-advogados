package br.com.advocacia.dto;

import java.time.LocalDateTime;

import br.com.advocacia.entidade.Advogado;
import br.com.advocacia.entidade.Compromisso;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CompromissoDTO {
	   
		private Long id;
		@NotBlank(message = "Não pode estar em branco !")
		private String titulo;	
	    private LocalDateTime dataHora;	   
	    private Advogado advogados;	  
	    
	    
	    public CompromissoDTO(Compromisso criar) {
			this.id = criar.getId();
			this.titulo = criar.getTitulo();
			this.dataHora = criar.getDataHora();
			this.advogados = criar.getAdvogados();
			
		}

}
