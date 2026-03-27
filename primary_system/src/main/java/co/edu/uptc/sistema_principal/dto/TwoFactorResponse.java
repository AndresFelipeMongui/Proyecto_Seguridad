package co.edu.uptc.sistema_principal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//Devurlve si el segundo factor de autenticacion fue correcto o no
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TwoFactorResponse {

    private String message;
    private boolean accesGranted;
    
}
