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
//Logica de registro
@Service
public class UserService {

   
    private UserRepository userRepository;
    private TwoFactorService twoFactorService;

    public UserService(UserRepository userRepository, TwoFactorService twoFactorService){
        this.userRepository=userRepository;
        this.twoFactorService=twoFactorService;
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
   
        
             User user2=userRepository.findByUserName(user.getUserName()).orElse(null);
        
             if (user2==null){
                return new LoginResponse("Usuario no existente", false,false,null);
             }
    if(!user2.getPassword().equals(user.getPassword())){
        return new LoginResponse("Contraseña incorrecta", false,false,null);
    }
String code=twoFactorService.generateCode(user2.getUserName());
    return new LoginResponse("Inicio de sesion correcto", false,true,code);
    }



}
