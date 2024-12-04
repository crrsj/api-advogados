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

import br.com.advocacia.dto.CompromissoDTO;
import br.com.advocacia.servico.CompromissoServico;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/compromissos")
@RequiredArgsConstructor
public class CompromissoControle {
	
	private final CompromissoServico compromissoServico;
	
	@PostMapping("{advogadoId}")
	@Operation(summary = "Endpoint responsável pelo cadastro de compromissos.") 
    @ApiResponse(responseCode = "201",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<CompromissoDTO>criarCompromisso(@RequestBody CompromissoDTO compromissoDTO,
			@PathVariable("advogadoId") Long advogadoId){
		var criar = compromissoServico.criarCompromisso(compromissoDTO, advogadoId);
		var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").
				buildAndExpand(criar.getId()).toUri();
		return ResponseEntity.created(uri).body(new CompromissoDTO(criar));
		
	}
	

	@GetMapping
	@Operation(summary = "Endpoint responsável pela busca dos compromissos.") 
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<List<CompromissoDTO>>listarCompromissos(){
		var listarCompromissos = compromissoServico.listarCompromissos().stream().map(CompromissoDTO::new).toList();
		return ResponseEntity.ok().body(listarCompromissos);
	}
	
	
	@GetMapping("{id}")
	 @Operation(summary = "Endpoint responsável pela busca dos compromissos pelo id.") 
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<CompromissoDTO>buscarCompromissoId(@PathVariable Long id){
		var buscar = compromissoServico.buscarCompromissoId(id);
		return ResponseEntity.ok().body(new CompromissoDTO(buscar));
	}
	
	@PutMapping
	 @Operation(summary = "Endpoint responsável por atualizar dados dos compromissos.") 
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<CompromissoDTO>atualizarCompromisso(@RequestBody CompromissoDTO compromissoDTO){
		var atualizar = compromissoServico.AtualizarCompromisso(compromissoDTO);
		return ResponseEntity.ok().body(new CompromissoDTO(atualizar));
	}
	
	
	@DeleteMapping("{id}")
	@Operation(summary = "Endpoint responsável por excluir compromissos pelo id.") 
    @ApiResponse(responseCode = "204",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<Void>excluirCompromisso(@PathVariable Long id){
		compromissoServico.excluirCompromisso(id);
		return ResponseEntity.noContent().build();
	}
}
