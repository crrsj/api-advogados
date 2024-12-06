package br.com.advocacia.entidade;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.advocacia.dto.ProcessoDTO;
import br.com.advocacia.enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_processos")
@Data
@NoArgsConstructor
public class Processo {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String numeroProcesso;
    private String descricao;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne
    @JoinColumn(name = "cliente_id",nullable = false)
    @JsonIgnore
    private Cliente clientes; 
  
    


    public Processo(ProcessoDTO processoDTO) {
		this.id = processoDTO.getId();
		this.numeroProcesso = processoDTO.getNumeroProcesso();
		this.descricao = processoDTO.getDescricao();
		this.status = processoDTO.getStatus();
		this.clientes = processoDTO.getClientes();
	
		
	}
}
