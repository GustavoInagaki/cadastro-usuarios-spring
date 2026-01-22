package br.com.InagaGustavo.CadastroUsuarios.Controller;

import br.com.InagaGustavo.CadastroUsuarios.Repository.UsuarioRepository;
import br.com.InagaGustavo.CadastroUsuarios.model.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    @PostMapping
    public Usuario criar(@RequestBody Usuario usuario){

        return usuarioRepository.save(usuario);
    }

    @GetMapping({"/{id}"})
    public Usuario buscarPorId(@PathVariable Long id) {
        return usuarioRepository.findById(id).orElse(null);

    }

    @DeleteMapping("{id}")
    public void deletar(@PathVariable Long id){

        usuarioRepository.deleteById(id);
    }

    @GetMapping
    public List<Usuario> listar(){
        return usuarioRepository.findAll();
    }

}
