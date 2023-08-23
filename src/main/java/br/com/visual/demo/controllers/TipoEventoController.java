package br.com.visual.demo.controllers;

import br.com.visual.demo.model.entities.StatusFaseEvento;
import br.com.visual.demo.model.entities.TipoEvento;
import br.com.visual.demo.model.repositories.TipoEventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/tipo-evento")
public class TipoEventoController {

    @Autowired
    private TipoEventoRepository tipoEventoRepository;

    @GetMapping
    public Iterable<TipoEvento> getTipoEvento() {
        return tipoEventoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<TipoEvento> postTipoEvento(@Valid @RequestBody TipoEvento tipoEvento) {
        return ResponseEntity.ok(tipoEventoRepository.save(tipoEvento));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<TipoEvento> putTipoEvento(@PathVariable(name = "id") Integer id,
                                                                @Valid @RequestBody TipoEvento tipoEventoAtualizar) {

        TipoEvento tipoEvento = tipoEventoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tipo Evento não encontrado!"));

        tipoEvento.setDescricao(tipoEventoAtualizar.getDescricao());

        return ResponseEntity.ok(tipoEventoRepository.save(tipoEvento));
    }

    @GetMapping(path = "/{id}")
    public Optional<TipoEvento> getTipoEventoId(@PathVariable(name = "id") Integer id) {
        return tipoEventoRepository.findById(id);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteTipoEvento(@PathVariable(name = "id") Integer id) {
        tipoEventoRepository.deleteById(id);
    }
}
