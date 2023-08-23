package br.com.visual.demo.controllers;

import br.com.visual.demo.model.entities.Evento;
import br.com.visual.demo.model.repositories.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/evento")
public class EventoController {

    @Autowired
    private EventoRepository eventoRepository;

    @GetMapping
    public Iterable<Evento> getEvento() {
        return eventoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Evento> postEvento(@Valid @RequestBody Evento evento) {
        return ResponseEntity.ok(eventoRepository.save(evento));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Evento> putEvento(@PathVariable(name = "id") Integer id,
                                            @Valid @RequestBody Evento eventoAtualizar) {

        Evento evento = eventoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Evento não encontrado!"));

        evento.setEnvoiDados(eventoAtualizar.getEnvoiDados());
        evento.setStatusLegenda(eventoAtualizar.getStatusLegenda());
        evento.setDataEntrega(eventoAtualizar.getDataEntrega());
        evento.setDataEvento(eventoAtualizar.getDataEvento());
        evento.setFezBackup(eventoAtualizar.getFezBackup());
        evento.setQualHD(eventoAtualizar.getQualHD());
        evento.setEditor(eventoAtualizar.getEditor());

        return ResponseEntity.ok(eventoRepository.save(evento));
    }

    @GetMapping(path = "/{id}")
    public Optional<Evento> getEventoId(@PathVariable(name = "id") Integer id) {
        return eventoRepository.findById(id);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteEvento(@PathVariable(name = "id") Integer id) {
        eventoRepository.deleteById(id);
    }
}
