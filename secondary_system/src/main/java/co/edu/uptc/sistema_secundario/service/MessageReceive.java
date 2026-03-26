package co.edu.uptc.sistema_secundario.service;

import org.springframework.stereotype.Service;

import co.edu.uptc.sistema_secundario.dtos.IncomingMessage;
import co.edu.uptc.sistema_secundario.dtos.IntegrityResponse;

@Service
public class MessageReceive {
    private HashService hashService;

    public MessageReceive(HashService hashService){
        this.hashService=hashService;

    }

    /**
     * Procesa el mensage de entrada comparando el hash
     * @param request contiene el contenido del mensage y el hash original
     * @return El mensage que nos dice si el hash fue modificado o no
     */

    public IntegrityResponse proccesMessage(IncomingMessage request){
        String calculatedHash=hashService.generateHash(request.getContent());

        if(!calculatedHash.equals(request.getHash())){
            return new IntegrityResponse("Mensaje rechazado", false);
        }

        return new IntegrityResponse("Mensage aceptado", true);
    }
}
