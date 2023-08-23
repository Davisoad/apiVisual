package br.com.visual.demo.controllers;

import br.com.visual.demo.model.entities.TipoEvento;
import br.com.visual.demo.model.entities.Usuario;
import br.com.visual.demo.model.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public Iterable<Usuario> getUsuario() {
        return usuarioRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Usuario> postUsuario(@Valid @RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioRepository.save(usuario));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Usuario> putUsuario(@PathVariable(name = "id") Integer id,
                                                    @Valid @RequestBody Usuario usuarioAtualizar) {

        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado!"));

        usuario.setLogin(usuarioAtualizar.getLogin());
        usuario.setNome(usuarioAtualizar.getNome());
        usuario.setSenha(usuarioAtualizar.getSenha());

        return ResponseEntity.ok(usuarioRepository.save(usuario));
    }

    @GetMapping(path = "/{id}")
    public Optional<Usuario> getUsuarioId(@PathVariable(name = "id") Integer id) {
        return usuarioRepository.findById(id);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteUsuario(@PathVariable(name = "id") Integer id) {
        usuarioRepository.deleteById(id);
    }

}
