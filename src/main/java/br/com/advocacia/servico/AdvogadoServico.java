package br.com.advocacia.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.advocacia.dto.AdvogadoDTO;
import br.com.advocacia.entidade.Advogado;
import br.com.advocacia.repositorio.AdvogadoRepositorio;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdvogadoServico {

	private final AdvogadoRepositorio advogadoRepositorio;
	
	public Advogado cadastrarAdvogado(AdvogadoDTO advogadoDTO) {
		var criar = new Advogado(advogadoDTO);
		return advogadoRepositorio.save(criar);
	}
	
	public List<Advogado>listarAdvogados(){
		return advogadoRepositorio.findAll();
	}
	
	public Advogado buscarPorId(Long id) {
		Optional<Advogado>buscar = advogadoRepositorio.findById(id);
		return buscar.get();
	}
	
	public Advogado atualizarAdvogado(AdvogadoDTO advogadoDTO) {
		var atualizar = new Advogado(advogadoDTO);
		return advogadoRepositorio.save(atualizar);
	}
	
	public void excluirAdvogado(Long id) {
		advogadoRepositorio.deleteById(id);
	}
}
