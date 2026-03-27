package co.edu.uptc.sistema_principal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//El objeto o body que se ennvia desde el sistema principal al sistema secundario
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageUtil {
    private String remitter;
    private String content;
    private String hash;
}
