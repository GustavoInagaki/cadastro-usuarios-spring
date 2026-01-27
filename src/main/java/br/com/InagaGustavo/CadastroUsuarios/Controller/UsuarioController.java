package br.com.InagaGustavo.CadastroUsuarios.Controller;

import br.com.InagaGustavo.CadastroUsuarios.Repository.UsuarioRepository;
import br.com.InagaGustavo.CadastroUsuarios.dto.UsuarioRequestDTO;
import br.com.InagaGustavo.CadastroUsuarios.dto.UsuarioResponseDTO;
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
    public ResponseEntity<UsuarioResponseDTO> criar(
            @Valid @RequestBody UsuarioRequestDTO dto) {

        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setIdade(dto.getIdade());

        Usuario salvo = usuarioRepository.save(usuario);

        UsuarioResponseDTO response = new UsuarioResponseDTO(
                salvo.getId(),
                salvo.getNome(),
                salvo.getEmail(),
                salvo.getIdade()
        );

        return ResponseEntity.status(201).body(response);
    }


    @GetMapping({"/{id}"})
    public ResponseEntity<UsuarioResponseDTO> buscarPorId(@PathVariable Long id){

        return usuarioRepository.findById(id)
                .map(usuario -> new UsuarioResponseDTO(
                        usuario.getId(),
                        usuario.getNome(),
                        usuario.getEmail(),
                        usuario.getIdade()
                ))
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
    public ResponseEntity<List<UsuarioResponseDTO>> listar(){

        List<UsuarioResponseDTO> lista = usuarioRepository.findAll()
                .stream()
                .map(u -> new UsuarioResponseDTO(
                        u.getId(),
                        u.getNome(),
                        u.getEmail(),
                        u.getIdade()
                ))
                .toList();

        return ResponseEntity.ok(lista);

    }



}
