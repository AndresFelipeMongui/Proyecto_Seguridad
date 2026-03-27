package co.edu.uptc.sistema_principal.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
// Contenido que el sistema principal quiere enviar
@Data
public class MessageRequest {
    @NotBlank
    private String remitter;
    @NotBlank
    private String content;
}
