package br.com.advocacia.entidade;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.advocacia.dto.AdvogadoDTO;

@Entity
@Table(name = "tb_advogados")
@Data
@NoArgsConstructor
public class Advogado {

  
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;	
    private String nome;
    private String email;
    private String especialidade;
    @Column(unique = true)
    private String oab;
    private String estado;
    @JsonIgnore
    @OneToMany(mappedBy = "advogados",cascade = CascadeType.ALL,orphanRemoval = true)    
    private List<Compromisso>compromissos = new ArrayList<>();  
    @JsonIgnore
    @OneToMany(mappedBy = "advogados",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Cliente>clientes = new ArrayList<>();
    
    public Advogado(AdvogadoDTO advogadoDTO) {
  		this.id = advogadoDTO.getId();
  		this.nome = advogadoDTO.getNome();
  		this.email = advogadoDTO.getEmail();
  		this.especialidade = advogadoDTO.getEspecialidade();
  		this.oab = advogadoDTO.getOab();
  		this.estado = advogadoDTO.getEstado();
  		this.compromissos = advogadoDTO.getCompromissos();
  		this.clientes = advogadoDTO.getClientes();
  	}

}
