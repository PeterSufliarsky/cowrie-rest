package sk.sufliarsky.peter.cowrierest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.sufliarsky.peter.cowrierest.entity.Auth;
import sk.sufliarsky.peter.cowrierest.repository.AuthRepository;

import java.util.List;

@Service
public class AuthService {

    @Autowired
    private AuthRepository authRepository;

    public List<Auth> findBySessionId(String sessionId) {
        return authRepository.findBySessionId(sessionId);
    }
}
