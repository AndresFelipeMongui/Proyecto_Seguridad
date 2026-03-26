package co.edu.uptc.sistema_principal.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import co.edu.uptc.sistema_principal.dto.MessageRequest;
import co.edu.uptc.sistema_principal.dto.MessageUtil;

@Service
public class MessageService {
    HashService hashService;
    RestTemplate restTemplate;

    public MessageService (HashService hashService,RestTemplate restTemplate){
        this.hashService=hashService;
        this.restTemplate=restTemplate;
    }

    /**
     * Envia un mensaje al sistema secundario para su validacion
     * @param request objeto que contiene aal remitente del mensage y el contenido 
     * @return Objeto que muestra el resultado de la validacion
     */
    public IntegrityResponse sendMessage(MessageRequest request){
        String hash=hashService.generateHash(request.getContent());
        MessageUtil messaje=new MessageUtil(request.getRemitter(),request.getContent(),hash);

        String urlDestination="http://localhost:8082/message/receive";

        ResponseEntity<IntegrityResponse> response=restTemplate.postForEntity(urlDestination,messaje,IntegrityResponse.class);
        return response.getBody();
    }

/**
 * 
 Metodo que envia un mensage al sistema secundario y ejecuta un cambio en el mensage 
 * @param request Objeto que contiene el remietente y el contenido del mensaje
 * @return Objeto que muestra el resultado de la validacion 
 */
     public IntegrityResponse sendMessageAltered(MessageRequest request){
        String hashOriginal=hashService.generateHash(request.getContent());

        String contentAltered=request.getContent() + "Contenido alerado";
        MessageUtil messaje=new MessageUtil(request.getRemitter(),contentAltered,hashOriginal);

        String urlDestination="http://localhost:8082/message/receive";

        ResponseEntity<IntegrityResponse> response=restTemplate.postForEntity(urlDestination,messaje,IntegrityResponse.class);
        return response.getBody();
    }


}

