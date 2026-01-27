package br.com.InagaGustavo.CadastroUsuarios.exception;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
public class ErroResponse {

    private int status;
    private String mensagem;
    private LocalDateTime timestamp;

    public ErroResponse(int status, String mensagem, LocalDateTime timestamp) {
        this.status = status;
        this.mensagem = mensagem;
        this.timestamp = timestamp;
    }

}
