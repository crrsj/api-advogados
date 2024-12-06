package br.com.advocacia.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.advocacia.dto.ProcessoDTO;
import br.com.advocacia.entidade.Processo;


import br.com.advocacia.repositorio.ClienteRepositorio;
import br.com.advocacia.repositorio.ProcessoRepositorio;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProcessoServico {
	
	private final ProcessoRepositorio processoRepositorio;
	
	private final ClienteRepositorio clienteRepositorio;
	
	public Processo criarProcesso(ProcessoDTO processoDTO,Long clienteId) {
		var criarProcesso = new Processo(processoDTO);
		var cliente = clienteRepositorio.findById(clienteId).get();
		criarProcesso.setClientes(cliente);
		return processoRepositorio.save(criarProcesso);
	}
	
	public List<Processo>listarProcessos(){
		return processoRepositorio.findAll();
	}
	
	public Processo buscarProcessoId(Long id) {
		Optional<Processo>busca = processoRepositorio.findById(id);
		return busca.get();
	}

	
	public Processo atualizarProceso(ProcessoDTO processoDTO) {
		var atualizar =  new Processo(processoDTO);
		return processoRepositorio.save(atualizar);
		
	}
	
	public void excluirProcesso(Long id) {
		processoRepositorio.deleteById(id);
	}
	
	public Processo buscarPorProcesso(String processo) {
		Optional<Processo>buscarProcesso =  processoRepositorio.findByNumeroProcesso(processo.trim().toUpperCase());	 
		   return buscarProcesso.get();
	   }
	   
	    
     



}