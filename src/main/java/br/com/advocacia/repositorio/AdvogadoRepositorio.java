package br.com.advocacia.repositorio;

import br.com.advocacia.entidade.Advogado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvogadoRepositorio extends JpaRepository<Advogado,Long> {
}
