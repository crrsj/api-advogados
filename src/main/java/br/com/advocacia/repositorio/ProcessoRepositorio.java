package br.com.advocacia.repositorio;

import br.com.advocacia.entidade.Processo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProcessoRepositorio extends JpaRepository<Processo,Long> {

	@Query(value = "select p from Processo p where upper(trim(p.numeroProcesso)) like %?1% ")
	Processo findByNumeroProcesso(String processo);
}
