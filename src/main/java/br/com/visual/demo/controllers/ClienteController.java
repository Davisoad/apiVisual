package br.com.visual.demo.controllers;

import br.com.visual.demo.model.entities.Cliente;
import br.com.visual.demo.model.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public Iterable<Cliente> getCliente() {
        return clienteRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Cliente> postCliente(@Valid @RequestBody Cliente cliente) {
        return ResponseEntity.ok(clienteRepository.save(cliente));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Cliente> putCliente(@PathVariable(name = "id") Integer id,
                                              @Valid @RequestBody Cliente clienteAtualizado) {

        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado!"));

        cliente.setNomeCliente(clienteAtualizado.getNomeCliente());
        cliente.setDescricaoc(clienteAtualizado.getDescricaoc());

        return ResponseEntity.ok(clienteRepository.save(cliente));
    }

    @GetMapping(path = "/{id}")
    public Optional<Cliente> getClienteId(@PathVariable(name = "id") Integer id) {
        return clienteRepository.findById(id);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteCliente(@PathVariable(name = "id") Integer id) {
        clienteRepository.deleteById(id);
    }
}
