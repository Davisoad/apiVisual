package br.com.visual.demo.controllers;

import br.com.visual.demo.model.entities.Evento;
import br.com.visual.demo.model.entities.FaseEvento;
import br.com.visual.demo.model.repositories.FaseEventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/fase-evento")
public class FaseEventoController {

    @Autowired
    private FaseEventoRepository faseEventoRepository;

    @GetMapping
    public Iterable<FaseEvento> getFaseEvento() {
        return faseEventoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<FaseEvento> postFaseEvento(@Valid @RequestBody FaseEvento faseEvento) {
        return ResponseEntity.ok(faseEventoRepository.save(faseEvento));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<FaseEvento> putFaseEvento(@PathVariable(name = "id") Integer id,
                                                    @Valid @RequestBody FaseEvento faseEventoAtualizar) {

        FaseEvento faseEvento = faseEventoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Fase Evento não encontrado!"));

        faseEvento.setDescricao(faseEventoAtualizar.getDescricao());

        return ResponseEntity.ok(faseEventoRepository.save(faseEvento));
    }

    @GetMapping(path = "/{id}")
    public Optional<FaseEvento> getFaseEventoId(@PathVariable(name = "id") Integer id) {
        return faseEventoRepository.findById(id);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteFaseEvento(@PathVariable(name = "id") Integer id) {
        faseEventoRepository.deleteById(id);
    }
}
