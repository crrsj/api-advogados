package br.com.advocacia.entidade;

import java.time.LocalDateTime;

import br.com.advocacia.dto.CompromissoDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_compromissos")
@Data
@NoArgsConstructor
public class Compromisso {
  
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dataHora;
    @ManyToOne
    @JoinColumn(name = "advogado_Id")
    private Advogado advogados;
    @ManyToOne
    @JoinColumn(name = "processo_Id")
    private Processo processos;
    
    
    public Compromisso(CompromissoDTO compromissoDTO) {
  		this.id = compromissoDTO.getId();
  		this.dataHora = compromissoDTO.getDataHora();
  		this.advogados = compromissoDTO.getAdvogados();
  		this.processos = compromissoDTO.getProcessos();
  	}
}
