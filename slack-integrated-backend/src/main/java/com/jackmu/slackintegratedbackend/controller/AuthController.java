package com.jackmu.slackintegratedbackend.controller;

import com.jackmu.slackintegratedbackend.jwt.JwtTokenProvider;
import com.jackmu.slackintegratedbackend.model.security.JwtAuthResponse;
import com.jackmu.slackintegratedbackend.model.security.LoginDTO;
import com.jackmu.slackintegratedbackend.model.security.RegisterDTO;
import com.jackmu.slackintegratedbackend.service.security.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthService authService;
    private static final Logger LOGGER = Logger.getLogger(AuthController.class.getName());

    @GetMapping(value="/")
    public String healthCheck(){
        return "OK";
    }

    @PostMapping(value = {"/login", "/signin"})
    public ResponseEntity<JwtAuthResponse> login(@RequestBody LoginDTO loginDTO){
        LOGGER.info("HI");
        LOGGER.info(loginDTO.getUsernameOrEmail());
        String token = authService.login(loginDTO);

        JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
        jwtAuthResponse.setAccessToken(token);

        return ResponseEntity.ok(jwtAuthResponse);
    }

    @PostMapping(value = {"/register", "/signup"})
    public ResponseEntity<String> register(@RequestBody RegisterDTO registerDTO) throws Exception{
        return authService.register(registerDTO);
    }
}
