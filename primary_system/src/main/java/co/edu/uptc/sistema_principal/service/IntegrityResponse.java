package co.edu.uptc.sistema_principal.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IntegrityResponse {
    
    private String message;
    private boolean accepted;
}
