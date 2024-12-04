package br.com.advocacia.repositorio;

import br.com.advocacia.entidade.Compromisso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompromissoRepositorio extends JpaRepository<Compromisso,Long> {
}
