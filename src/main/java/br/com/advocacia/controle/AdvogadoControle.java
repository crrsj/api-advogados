package br.com.advocacia.controle;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.advocacia.dto.AdvogadoDTO;
import br.com.advocacia.servico.AdvogadoServico;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/advogados")
@RequiredArgsConstructor
public class AdvogadoControle {

	private final AdvogadoServico advogadoServico;
	
	
	@PostMapping
	@Operation(summary = "Endpoint responsável por cadastrar advogados.") 
    @ApiResponse(responseCode = "201",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<AdvogadoDTO>cadastrarAdvogado(@RequestBody AdvogadoDTO advogadoDTO){
		var cadastrar = advogadoServico.cadastrarAdvogado(advogadoDTO);
		var uri  = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").
				buildAndExpand(cadastrar.getId()).toUri();
		return ResponseEntity.created(uri).body(new AdvogadoDTO(cadastrar));
	}
	
	
	@GetMapping
	 @Operation(summary = "Endpoint responsável pela busca dos advogados.") 
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<List<AdvogadoDTO>>listarTodos(){
		var listar = advogadoServico.listarAdvogados().stream().map(AdvogadoDTO::new).toList();
		return ResponseEntity.ok().body(listar);
	}
	
	
	@GetMapping("{id}")
	@Operation(summary = "Endpoint responsável pela busca de advogados pelo id.") 
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<AdvogadoDTO> buscarAdvogadoId(@PathVariable Long id) {
		var busca = advogadoServico.buscarPorId(id);
		return ResponseEntity.ok().body(new AdvogadoDTO(busca));
	}
	
	@DeleteMapping("{id}")
	@Operation(summary = "Endpoint responsável por excluir advogados.") 
    @ApiResponse(responseCode = "204",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<Void>excluirAdvogado(@PathVariable Long id){
		advogadoServico.excluirAdvogado(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping
	 @Operation(summary = "Endpoint responsável por atualizar dados de advogados.") 
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<AdvogadoDTO>atualizarAdvogado(@RequestBody AdvogadoDTO advogadoDTO){
		var atualizar = advogadoServico.atualizarAdvogado(advogadoDTO);
		return ResponseEntity.ok().body(new AdvogadoDTO(atualizar));
	}
}
