package br.com.visual.demo.model.repositories;

import br.com.visual.demo.model.entities.Evento;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EventoRepository extends PagingAndSortingRepository<Evento, Integer> {
}
