package co.edu.uptc.sistema_secundario.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uptc.sistema_secundario.dtos.IncomingMessage;
import co.edu.uptc.sistema_secundario.dtos.IntegrityResponse;
import co.edu.uptc.sistema_secundario.service.MessageReceive;

@RestController
@RequestMapping("/message")
public class MessageContorller {

    MessageReceive messageReceive;

    public MessageContorller(MessageReceive messageReceive){
        this.messageReceive=messageReceive;
    }
//http://localhost:8082/message/receive
    @PostMapping("/receive")
        public ResponseEntity<IntegrityResponse> receiveMessage(@RequestBody IncomingMessage request){
            return ResponseEntity.ok(messageReceive.proccesMessage(request));
        }
    
}
