package br.com.InagaGustavo.CadastroUsuarios.exception;

public class UsuarioNaoEncontradoException extends RuntimeException{

    public UsuarioNaoEncontradoException(Long id){
        super("Usuário com id " + id + " não encontrado");
    }
}
