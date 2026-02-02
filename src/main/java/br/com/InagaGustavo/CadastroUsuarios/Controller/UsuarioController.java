package br.com.InagaGustavo.CadastroUsuarios.Controller;

import br.com.InagaGustavo.CadastroUsuarios.Repository.UsuarioRepository;
import br.com.InagaGustavo.CadastroUsuarios.dto.UsuarioRequestDTO;
import br.com.InagaGustavo.CadastroUsuarios.dto.UsuarioResponseDTO;
import br.com.InagaGustavo.CadastroUsuarios.model.Usuario;
import br.com.InagaGustavo.CadastroUsuarios.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> criar(
            @Valid @RequestBody UsuarioRequestDTO dto) {

        UsuarioResponseDTO response = usuarioService.criar(dto);
        return ResponseEntity.status(201).body(response);
    }


    @GetMapping({"/{id}"})
    public ResponseEntity<UsuarioResponseDTO> buscarPorId(@PathVariable Long id){

        return ResponseEntity.ok(usuarioService.buscarPorId(id));

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Usuario> deletar(@PathVariable Long id){

        usuarioService.deletar(id);
        return ResponseEntity.noContent().build();

    }

    @GetMapping
    public ResponseEntity<Page<UsuarioResponseDTO>> listar(
            @PageableDefault(
                    page = 0,
                    size = 5,
                    sort = "nome",
                    direction = Sort.Direction.ASC
            )Pageable pageable
    ) {
        return ResponseEntity.ok(usuarioService.listar(pageable));
    }



}
