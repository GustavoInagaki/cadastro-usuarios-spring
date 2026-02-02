package br.com.InagaGustavo.CadastroUsuarios.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Data
public class ValidationErrorResponse {

    private int status;
    private List<FieldErrorDTO> erros;
    private LocalDateTime timestamp;



}
