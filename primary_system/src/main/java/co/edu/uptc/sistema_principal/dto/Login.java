package co.edu.uptc.sistema_principal.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
//Recibe el login usuario y contraseña
@Data
public class Login {
    

    @NotBlank
    private String userName;
    @NotBlank
    private String password;
}
