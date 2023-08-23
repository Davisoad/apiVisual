package br.com.visual.demo.model.repositories;

import br.com.visual.demo.model.entities.FaseEvento;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FaseEventoRepository extends PagingAndSortingRepository<FaseEvento, Integer> {
}
