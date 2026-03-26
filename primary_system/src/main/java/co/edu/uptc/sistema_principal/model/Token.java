package co.edu.uptc.sistema_principal.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tokens")
@Data
@NoArgsConstructor
@AllArgsConstructor

//Clase que se encarga de guardar temporalmente el token para el segundo paso de autenticacion
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String userName;

    private String code;


    
}
