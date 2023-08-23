package br.com.visual.demo.model.repositories;

import br.com.visual.demo.model.entities.TipoEvento;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TipoEventoRepository extends PagingAndSortingRepository<TipoEvento, Integer> {
}
