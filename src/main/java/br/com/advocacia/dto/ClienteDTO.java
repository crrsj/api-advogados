package br.com.advocacia.dto;

import br.com.advocacia.entidade.Cliente;
import br.com.advocacia.entidade.Processo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ClienteDTO {
    private Long id;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private List<Processo> processos;

    public ClienteDTO(Cliente cadastre) {
        this.id = cadastre.getId();
        this.nome = cadastre.getNome();
        this.cpf = cadastre.getCpf();
        this.telefone = cadastre.getTelefone();
        this.email = cadastre.getEmail();
        this.processos = cadastre.getProcessos();

    }
}
