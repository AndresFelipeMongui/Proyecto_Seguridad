package co.edu.uptc.sistema_principal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uptc.sistema_principal.model.User;
import co.edu.uptc.sistema_principal.service.UserService;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/save")
    public User save(@RequestBody User user){
        return this.userService.save(user);
    }

    public ResponseEntity<List<User>> getUsers(){
        var user=userService.getUsers();
        return ResponseEntity.ok(user);
    }

}
