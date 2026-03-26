package co.edu.uptc.sistema_principal.service;

import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Service;

import co.edu.uptc.sistema_principal.dto.TwoFactor;
import co.edu.uptc.sistema_principal.dto.TwoFactorResponse;
import co.edu.uptc.sistema_principal.model.Token;
import co.edu.uptc.sistema_principal.repository.TokenRepository;
import jakarta.transaction.Transactional;
@Service
public class TwoFactorService {

    private final TokenRepository tokenRepository;

    public TwoFactorService(TokenRepository tokenRepository){
        this.tokenRepository=tokenRepository;
    }
    
@Transactional
    public String generateCode(String userName){
       Token optionalToken=tokenRepository.findByUserName(userName).orElse(null);
        
       if (optionalToken != null) {
    
    tokenRepository.deleteByUserName(userName);
}
        String code=String.format("%06d",new Random().nextInt(999999));

        Token token=new Token();
        token.setUserName(userName);
        token.setCode(code);

        tokenRepository.save(token);

        System.out.println("Codigo para" + userName + ":" + code);
        return code;

    }
    
    
public TwoFactorResponse validateCode(TwoFactor request){
    
Token token=tokenRepository.findByUserName(request.getUserName()).orElse(null);

if(token==null){
    return new TwoFactorResponse("No existe codigo para el usuario",false);
}
if (!token.getCode().equals(request.getCode())) {
    return new TwoFactorResponse("Codigo incorrecto",false);
}

tokenRepository.deleteByUserName(request.getUserName());
return new TwoFactorResponse("Acceso permitido",true);
    }


}
