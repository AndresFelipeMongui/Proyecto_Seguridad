package co.edu.uptc.sistema_principal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageUtil {
    private String remitter;
    private String content;
    private String hash;
}
