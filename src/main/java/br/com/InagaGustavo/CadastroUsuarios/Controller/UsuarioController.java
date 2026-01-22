package br.com.InagaGustavo.CadastroUsuarios.Controller;

import br.com.InagaGustavo.CadastroUsuarios.Repository.UsuarioRepository;
import br.com.InagaGustavo.CadastroUsuarios.model.Usuario;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<Usuario> criar(@Valid @RequestBody Usuario usuario){
        Usuario usuariosCriados = usuarioRepository.save(usuario);
        return ResponseEntity.status(201).body(usuariosCriados);

    }

    @GetMapping({"/{id}"})
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id){
        return usuarioRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Usuario> deletar(@PathVariable Long id){
        if(!usuarioRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }

        usuarioRepository.deleteById(id);
        return ResponseEntity.noContent().build();

    }

    @GetMapping
    public List<Usuario> listar(){
        return usuarioRepository.findAll();
    }

}
