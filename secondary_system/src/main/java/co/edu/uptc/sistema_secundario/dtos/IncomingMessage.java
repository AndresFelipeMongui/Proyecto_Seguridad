package co.edu.uptc.sistema_secundario.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
// Representa el sistema recibido
@Data
public class IncomingMessage {
    

    @NotBlank
    private String remitter;
@NotBlank
    private String content;
@NotBlank
    private String hash;
}
