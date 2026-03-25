package co.edu.uptc.sistema_principal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.uptc.sistema_principal.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
}
