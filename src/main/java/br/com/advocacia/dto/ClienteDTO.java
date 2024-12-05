package br.com.advocacia.dto;

import java.util.List;

import br.com.advocacia.entidade.Advogado;
import br.com.advocacia.entidade.Cliente;
import br.com.advocacia.entidade.Processo;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClienteDTO {
    private Long id;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private List<Processo> processos;
    private Advogado advogados;

    public ClienteDTO(Cliente cadastre) {
        this.id = cadastre.getId();
        this.nome = cadastre.getNome();
        this.cpf = cadastre.getCpf();
        this.telefone = cadastre.getTelefone();
        this.email = cadastre.getEmail();
        this.processos = cadastre.getProcessos();
        this.advogados = cadastre.getAdvogados();

    }
}
