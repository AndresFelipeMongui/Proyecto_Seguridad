package co.edu.uptc.sistema_principal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//Devuelve el resultado del login si las credenciales son incorrectas o si se requiere segundo factor
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
    private String message;
    private boolean autenticated;
    private boolean secondFactor;
    private String code;
}
