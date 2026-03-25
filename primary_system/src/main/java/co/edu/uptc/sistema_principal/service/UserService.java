package co.edu.uptc.sistema_principal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uptc.sistema_principal.model.User;
import co.edu.uptc.sistema_principal.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(User user){
        return this.userRepository.save(user);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }




}
