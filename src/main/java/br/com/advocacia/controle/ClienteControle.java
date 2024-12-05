package br.com.advocacia.controle;

import br.com.advocacia.dto.ClienteDTO;
import br.com.advocacia.servico.ClienteServico;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/advocacia")
@RequiredArgsConstructor
public class ClienteControle {


    private final ClienteServico clienteServico;

    @PostMapping("{clienteId}")
    @Operation(summary = "Endpoint responsável pelo cadastro de clientes.") 
    @ApiResponse(responseCode = "201",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
    public ResponseEntity<ClienteDTO>cadastrarCliente(@RequestBody ClienteDTO clienteDTO,
    		@PathVariable("clienteId")Long clienteId){
        var cadastre = clienteServico.cadastrarCliente(clienteDTO,clienteId);
        var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").
        buildAndExpand(cadastre.getId()).toUri();
        return ResponseEntity.created(uri).body(new ClienteDTO(cadastre));
    }

    @GetMapping
    @Operation(summary = "Endpoint responsável pela busca dos clientes.") 
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
    public ResponseEntity<List<ClienteDTO>>listarClientes(){
        var listar = clienteServico.listarClientes().stream().map(ClienteDTO::new).toList();
        return ResponseEntity.ok().body(listar);
    }

    @PutMapping
    @Operation(summary = "Endpoint responsável por atualizar dados dos clientes.") 
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
    public ResponseEntity<ClienteDTO>atualizarCliente(@RequestBody ClienteDTO clienteDTO){
        var atualizar = clienteServico.atualizarCliente(clienteDTO);
        return ResponseEntity.ok().body(new ClienteDTO(atualizar));
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Endpoint responsávelpor excluir clientes.") 
    @ApiResponse(responseCode = "204",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))         
	})     
    public ResponseEntity<Void>excluirCliente(@PathVariable Long id){
        clienteServico.excluirCliente(id);
        return ResponseEntity.noContent().build();
    }
    
    
    @GetMapping("{id}")
    @Operation(summary = "Endpoint responsável pela busca de clientes pelo id.") 
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
    public ResponseEntity<ClienteDTO>buscarClientePorId(@PathVariable Long id){
    	var buscar = clienteServico.buscarClienteId(id);
    	return ResponseEntity.ok().body(new ClienteDTO(buscar));
    }
    
    @GetMapping("clienteNome")
    @Operation(summary = "Endpoint responsável pela busca dos clientes pelo nome.") 
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
    public ResponseEntity<List<ClienteDTO>>buscarPorNome(@RequestParam("nome") String nome){
    	var buscaNome = clienteServico.buscarPorNome(nome).stream().map(ClienteDTO::new).toList();
    	return ResponseEntity.ok().body(buscaNome);
    	
    }
}
