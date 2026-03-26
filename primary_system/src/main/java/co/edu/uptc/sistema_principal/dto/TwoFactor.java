package co.edu.uptc.sistema_principal.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
//establece lo que debe recibir la validacion del token
public class TwoFactor {
    @NotBlank
    private String userName;

    @NotBlank
    private String code;
}
