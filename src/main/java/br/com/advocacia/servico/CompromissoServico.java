package br.com.advocacia.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.advocacia.dto.CompromissoDTO;
import br.com.advocacia.entidade.Compromisso;
import br.com.advocacia.repositorio.AdvogadoRepositorio;
import br.com.advocacia.repositorio.CompromissoRepositorio;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CompromissoServico {
	
	
	private final CompromissoRepositorio compromissoRepositorio;
	private final AdvogadoRepositorio advogadoRepositorio;
	
	public Compromisso criarCompromisso(CompromissoDTO compromissoDTO,Long advogadoId) {		
		var compromisso = new Compromisso(compromissoDTO);
		var advogado = advogadoRepositorio.findById(advogadoId).get();
		compromisso.setAdvogados(advogado);
		return compromissoRepositorio.save(compromisso);
	}
	
	public List<Compromisso>listarCompromissos(){
		return compromissoRepositorio.findAll();
	}

	public Compromisso buscarCompromissoId(Long id) {
		Optional<Compromisso>busca = compromissoRepositorio.findById(id);
		return busca.get();
	}
	
	public Compromisso AtualizarCompromisso(CompromissoDTO compromissoDTO) {
		var atualizar = new Compromisso(compromissoDTO);
		return compromissoRepositorio.save(atualizar);
	}
	
	public void excluirCompromisso(Long id) {
		compromissoRepositorio.deleteById(id);
	}
}
