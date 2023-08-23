package br.com.visual.demo.controllers;

import br.com.visual.demo.model.entities.FaseEvento;
import br.com.visual.demo.model.entities.StatusFaseEvento;
import br.com.visual.demo.model.repositories.StatusFaseEventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/status-fase-evento")
public class StatusFaseEventoController {

    @Autowired
    private StatusFaseEventoRepository statusFaseEventoRepository;

    @GetMapping
    public Iterable<StatusFaseEvento> getStatusFaseEvento() {
        return statusFaseEventoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<StatusFaseEvento> postStatusFaseEvento(@Valid @RequestBody StatusFaseEvento statusFaseEvento) {
        return ResponseEntity.ok(statusFaseEventoRepository.save(statusFaseEvento));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<StatusFaseEvento> putStatusFaseEvento(@PathVariable(name = "id") Integer id,
                                                    @Valid @RequestBody StatusFaseEvento statusfaseEventoAtualizar) {

        StatusFaseEvento statusFaseEvento = statusFaseEventoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Status Fase Evento não encontrado!"));

        statusFaseEvento.setStatus(statusfaseEventoAtualizar.getStatus());

        return ResponseEntity.ok(statusFaseEventoRepository.save(statusFaseEvento));
    }

    @GetMapping(path = "/{id}")
    public Optional<StatusFaseEvento> getStatusFaseEventoId(@PathVariable(name = "id") Integer id) {
        return statusFaseEventoRepository.findById(id);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteStatusFaseEvento(@PathVariable(name = "id") Integer id) {
        statusFaseEventoRepository.deleteById(id);
    }
}
