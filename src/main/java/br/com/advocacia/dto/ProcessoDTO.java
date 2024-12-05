package br.com.advocacia.dto;

import java.util.List;

import br.com.advocacia.entidade.Cliente;
import br.com.advocacia.entidade.Compromisso;
import br.com.advocacia.entidade.Processo;
import br.com.advocacia.enums.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProcessoDTO {
	

	    private Long id;
	    private String numeroProcesso;
	    private String descricao;
	    private Status status;	 
	    private Cliente clientes;	    
	    private List<Compromisso>compromissos;

		 public ProcessoDTO(Processo criarProcesso) {
				this.id = criarProcesso.getId();
				this.numeroProcesso = criarProcesso.getNumeroProcesso();
				this.descricao = criarProcesso.getDescricao();
				this.status = criarProcesso.getStatus();
				this.clientes = criarProcesso.getClientes();
				
			}

		public ProcessoDTO(ProcessoDTO buscarNumero) {
			this.id = buscarNumero.getId();
			this.numeroProcesso = buscarNumero.getNumeroProcesso();
			this.descricao = buscarNumero.getDescricao();
			this.status = buscarNumero.getStatus();
			this.clientes = buscarNumero.getClientes();
			
		}
}
