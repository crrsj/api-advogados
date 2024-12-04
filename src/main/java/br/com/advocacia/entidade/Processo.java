package br.com.advocacia.entidade;

import br.com.advocacia.dto.ProcessoDTO;
import br.com.advocacia.enums.Status;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_processos")
@Data
@NoArgsConstructor
public class Processo {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numeroProcesso;
    private String descricao;
    private Status status;
    @ManyToOne
    @JoinColumn(name = "cliente_id",nullable = false)
    private Cliente clientes;
    @OneToMany(mappedBy = "processos",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Compromisso>compromissos;


    public Processo(ProcessoDTO processoDTO) {
		this.id = processoDTO.getId();
		this.numeroProcesso = processoDTO.getNumeroProcesso();
		this.descricao = processoDTO.getDescricao();
		this.status = processoDTO.getStatus();
	}
}
