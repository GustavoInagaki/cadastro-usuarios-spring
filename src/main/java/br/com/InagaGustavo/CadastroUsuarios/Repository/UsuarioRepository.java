package br.com.InagaGustavo.CadastroUsuarios.Repository;


import br.com.InagaGustavo.CadastroUsuarios.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository <Usuario, Long> {


}
