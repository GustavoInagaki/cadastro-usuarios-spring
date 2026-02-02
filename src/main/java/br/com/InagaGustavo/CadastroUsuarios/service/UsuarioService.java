package br.com.InagaGustavo.CadastroUsuarios.service;


import br.com.InagaGustavo.CadastroUsuarios.Repository.UsuarioRepository;
import br.com.InagaGustavo.CadastroUsuarios.dto.UsuarioRequestDTO;
import br.com.InagaGustavo.CadastroUsuarios.dto.UsuarioResponseDTO;
import br.com.InagaGustavo.CadastroUsuarios.exception.UsuarioNaoEncontradoException;
import br.com.InagaGustavo.CadastroUsuarios.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;




@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioResponseDTO criar(UsuarioRequestDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setIdade(dto.getIdade());

        Usuario salvo = usuarioRepository.save(usuario);

        return new UsuarioResponseDTO(
                salvo.getId(),
                salvo.getNome(),
                salvo.getEmail(),
                salvo.getIdade()
        );
    }

    public UsuarioResponseDTO buscarPorId(Long id) {
        return usuarioRepository.findById(id)
                .map(usuario -> new UsuarioResponseDTO(
                        usuario.getId(),
                        usuario.getNome(),
                        usuario.getEmail(),
                        usuario.getIdade()
                ))
                .orElseThrow(() -> new UsuarioNaoEncontradoException(id));
    }

    public Page<UsuarioResponseDTO> listar(Pageable pageable) {
        return usuarioRepository
                .findAll(pageable)
                .map(usuario -> new UsuarioResponseDTO(
                        usuario.getId(),
                        usuario.getNome(),
                        usuario.getEmail(),
                        usuario.getIdade()
                ));
    }

    public void deletar(Long id) {
        usuarioRepository.deleteById(id);
    }
}
