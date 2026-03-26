package co.edu.uptc.sistema_secundario.service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

import org.springframework.stereotype.Service;

@Service
public class HashService {
    

    /**
     * Metodo que genera u hash del contenido que resibe
     * Toma la cadena de texto y la convierte a bytes para con ello calcular el hash
     * @param content Cadena de entrada a la cual se le calculara el hash
     * 
     * @return una cadena que representa el hash 
     */
    public String generateHash(String content){
        try {
            MessageDigest digest=MessageDigest.getInstance("SHA-256");
            byte[] hashBytes=digest.digest(content.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString=new StringBuilder();
            for(byte b: hashBytes){
                String hex = Integer.toHexString(0xff & b);
                if (hex.length()==1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();

        } catch (Exception e) {
            // TODO: handle exception
            throw new RuntimeException("Error generando hash",e);
        }
    }
}
