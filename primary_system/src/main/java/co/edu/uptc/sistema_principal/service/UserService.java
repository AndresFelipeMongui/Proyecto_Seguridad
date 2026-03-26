package co.edu.uptc.sistema_principal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.autoconfigure.WebMvcProperties.Apiversion.Use;
import org.springframework.stereotype.Service;

import co.edu.uptc.sistema_principal.dto.Login;
import co.edu.uptc.sistema_principal.dto.LoginResponse;
import co.edu.uptc.sistema_principal.dto.UserRegister;
import co.edu.uptc.sistema_principal.model.User;
import co.edu.uptc.sistema_principal.repository.UserRepository;

@Service
public class UserService {

   
    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }


    public User save(UserRegister user){
       if(userRepository.existsByUserName(user.getUserName())){
        throw new RuntimeException("Nombre de usuario ya existente");
       }
       User user2=new User();
       user2.setName(user.getName());
       user2.setUserName(user.getUserName());
       user2.setPassword(user.getPassword());

       return userRepository.save(user2);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public LoginResponse login(Login user){
   
        
             User user2=userRepository.findByUserName(user.getUserName()).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        
    if(!user2.getPassword().equals(user.getPassword())){
        return new LoginResponse("Contraseña incorrecta", false);
    }

    return new LoginResponse("Inicio de sesion correcyo", true);
    }



}
