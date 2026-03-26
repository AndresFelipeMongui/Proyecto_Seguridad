package co.edu.uptc.sistema_principal.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Login {
    

    @NotBlank
    private String userName;
    @NotBlank
    private String password;
}
