package br.com.advocacia.dto;

import java.time.LocalDateTime;

import br.com.advocacia.entidade.Advogado;
import br.com.advocacia.entidade.Compromisso;
import br.com.advocacia.entidade.Processo;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CompromissoDTO {
	   
		private Long id;
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
