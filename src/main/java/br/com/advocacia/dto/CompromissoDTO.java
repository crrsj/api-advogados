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
	    private LocalDateTime dataHora;	   
	    private Advogado advogados;	  
	    private Processo processos;
	    
	    public CompromissoDTO(Compromisso criar) {
			this.id = criar.getId();
			this.dataHora = criar.getDataHora();
			this.advogados = criar.getAdvogados();
			this.processos = criar.getProcessos();
		}

}
