package co.edu.uptc.sistema_principal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import co.edu.uptc.sistema_principal.model.Token;
import jakarta.transaction.Transactional;

@Repository
public interface TokenRepository extends JpaRepository<Token,Long> {
    
    Optional<Token> findByUserName(String userName);

    @Modifying
    @Transactional
    void deleteByUserName(String userName);
}
