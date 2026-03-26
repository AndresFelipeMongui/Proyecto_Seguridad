package co.edu.uptc.sistema_principal.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uptc.sistema_principal.dto.MessageRequest;
import co.edu.uptc.sistema_principal.service.IntegrityResponse;
import co.edu.uptc.sistema_principal.service.MessageService;

@RestController
@RequestMapping("/message")
public class MessageController {
    MessageService messageService;

    public MessageController(MessageService messageService){
        this.messageService=messageService;
    }

    @PostMapping("/send")
    public ResponseEntity<IntegrityResponse> send(@RequestBody MessageRequest messageRequest){
        return ResponseEntity.ok(messageService.sendMessage(messageRequest));
    }

    @PostMapping("/sendAltered")
     public ResponseEntity<IntegrityResponse> sendAlter(@RequestBody MessageRequest messageRequest){
        return ResponseEntity.ok(messageService.sendMessageAltered(messageRequest));
    }


}
