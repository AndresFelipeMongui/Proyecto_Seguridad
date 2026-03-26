package co.edu.uptc.sistema_principal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TwoFactorResponse {

    private String message;
    private boolean accesGranted;
    
}
