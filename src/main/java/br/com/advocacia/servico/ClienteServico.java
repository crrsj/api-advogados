package br.com.advocacia.servico;

import br.com.advocacia.dto.ClienteDTO;
import br.com.advocacia.entidade.Cliente;
import br.com.advocacia.repositorio.ClienteRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteServico {


    private final ClienteRepositorio clienteRepositorio;

    public Cliente cadastrarCliente(ClienteDTO clienteDTO){
        var cadastro = new Cliente(clienteDTO);
        return clienteRepositorio.save(cadastro);

    }
    public List<Cliente>listarClientes(){
        return clienteRepositorio.findAll();
    }

    public Cliente atualizarCliente(ClienteDTO clienteDTO){
        var atualizar  = new Cliente(clienteDTO);
        return clienteRepositorio.save(atualizar);
    }

    public void excluirCliente(Long id){
        clienteRepositorio.deleteById(id);
    }
    
    public Cliente buscarClienteId(Long id) {
    	Optional<Cliente>buscarCliente = clienteRepositorio.findById(id);
    	return buscarCliente.get();
    }
    
    public List<Cliente> buscarPorNome(String nome) {
    	return clienteRepositorio.findByNome(nome.trim().toUpperCase());
    	
    	
    	
    	
    	
    	
    	
    }
}
