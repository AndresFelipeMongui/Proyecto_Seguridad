package co.edu.uptc.sistema_principal.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
//Recibe los datos cuando se realiza el registro
@Data
public class UserRegister {
    @NotBlank
    private String name;
 @NotBlank
    private String userName;
 @NotBlank
    private String password;
}
