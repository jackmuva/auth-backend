package com.jackmu.slackintegratedbackend.security;


import com.jackmu.slackintegratedbackend.model.security.LoginDTO;
import com.jackmu.slackintegratedbackend.model.security.RegisterDTO;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    String login(LoginDTO loginDto);
    ResponseEntity<String> register(RegisterDTO registerDTO) throws Exception;
}
