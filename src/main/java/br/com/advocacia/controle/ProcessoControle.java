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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.advocacia.dto.ProcessoDTO;
import br.com.advocacia.servico.ProcessoServico;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/processo")
@RequiredArgsConstructor
public class ProcessoControle {
	
	private final ProcessoServico  processoServico;
	
	@PostMapping("{clienteId}")
    @Operation(summary = "Endpoint responsável pelo cadastro de processos.") 
    @ApiResponse(responseCode = "201",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<ProcessoDTO>criarProcesso(@RequestBody ProcessoDTO processoDTO,
		@PathVariable("clienteId")Long clienteId){
		var criarProcesso = processoServico.criarProcesso(processoDTO, clienteId);
		var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").
		buildAndExpand(criarProcesso.getId()).toUri();
		return ResponseEntity.created(uri).body(new ProcessoDTO(criarProcesso));
		
	}
	
	@GetMapping
	 @Operation(summary = "Endpoint responsável pela busca dos processos.") 
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<List<ProcessoDTO>>listarProcessor(){
		var listarProcessos = processoServico.listarProcessos().stream().map(ProcessoDTO::new).toList();
		return ResponseEntity.ok().body(listarProcessos);
	}
	
	
	@GetMapping("{id}")
	 @Operation(summary = "Endpoint responsável pela busca do processo pelo id.") 
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<ProcessoDTO>buscarProcessoId(@PathVariable Long id) {
		var buscar = processoServico.buscarProcessoId(id);
		return ResponseEntity.ok().body(new ProcessoDTO(buscar));
		
	}
	
	
	@PutMapping
	 @Operation(summary = "Endpoint responsável por atualizar dados dos processos.") 
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<ProcessoDTO>atualizarProcesso(@RequestBody ProcessoDTO processoDTO){
		var atualizar = processoServico.atualizarProceso(processoDTO);
		return ResponseEntity.ok().body(new ProcessoDTO(atualizar));
	}
	
	
	@DeleteMapping("{id}")
	@Operation(summary = "Endpoint responsável por excluir processos.") 
    @ApiResponse(responseCode = "204",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<Void>excluirProcesso(@PathVariable Long id){
		processoServico.excluirProcesso(id);
		return ResponseEntity.noContent().build();
	}	
	
	
    @GetMapping("buscarProcesso")
    @Operation(summary = "Endpoint responsável pela busca dos processos pelo número.") 
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<ProcessoDTO>buscarPorNumeroProcesso(@RequestParam("numeroProcesso")String numeroProcesso ) {	
		var buscarNumero = processoServico.buscarPorProcesso(numeroProcesso);
		return ResponseEntity.ok().body(new ProcessoDTO(buscarNumero));
	}
}
