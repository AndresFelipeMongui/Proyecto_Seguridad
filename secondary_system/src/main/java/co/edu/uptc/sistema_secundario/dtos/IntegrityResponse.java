package co.edu.uptc.sistema_secundario.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IntegrityResponse {
    
    @NotBlank
    private String message;
    @NotBlank
    private boolean accepted;

    

}
