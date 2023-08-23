package br.com.visual.demo.model.repositories;

import br.com.visual.demo.model.entities.Cliente;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ClienteRepository extends PagingAndSortingRepository<Cliente, Integer> {
}
