package co.edu.uptc.sistema_principal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uptc.sistema_principal.dto.Login;
import co.edu.uptc.sistema_principal.dto.LoginResponse;
import co.edu.uptc.sistema_principal.dto.UserRegister;
import co.edu.uptc.sistema_principal.model.User;
import co.edu.uptc.sistema_principal.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    
    UserService userService;

public UserController(UserService userService){
    this.userService=userService;
}

    @PostMapping("/save")
    public ResponseEntity<User> save(@RequestBody UserRegister request){
        return ResponseEntity.ok(userService.save(request));
    }
@GetMapping
    public ResponseEntity<List<User>> getUsers(){
        var user=userService.getUsers();
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Validated @RequestBody Login user){
        return ResponseEntity.ok(userService.login(user));
    }

}
