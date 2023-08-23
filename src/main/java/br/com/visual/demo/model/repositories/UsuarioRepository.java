package br.com.visual.demo.model.repositories;

import br.com.visual.demo.model.entities.Usuario;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Integer> {
}
