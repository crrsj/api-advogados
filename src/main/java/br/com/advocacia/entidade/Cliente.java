package br.com.advocacia.entidade;

import br.com.advocacia.dto.ClienteDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_clientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    @OneToMany(mappedBy = "clientes",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Processo>processos;

    public Cliente(ClienteDTO clienteDTO) {
        this.id = clienteDTO.getId();
        this.nome = clienteDTO.getNome();
        this.cpf = clienteDTO.getCpf();
        this.telefone = clienteDTO.getTelefone();
        this.email = clienteDTO.getEmail();
        this.processos = clienteDTO.getProcessos();
    }
}
