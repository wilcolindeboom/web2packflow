package nl.novi.lindeboom.web2packflow.controller;

import nl.novi.lindeboom.web2packflow.payload.request.LoginRequest;
import nl.novi.lindeboom.web2packflow.payload.request.SignupRequest;
import nl.novi.lindeboom.web2packflow.payload.response.JwtResponse;
import nl.novi.lindeboom.web2packflow.payload.response.MessageResponse;
import nl.novi.lindeboom.web2packflow.service.AuthorizationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * Uitleg over CrossOrigin en CORS:
 * https://medium.com/@baphemot/understanding-cors-18ad6b478e2b
 *
 * Gebruik in Spring-boot (op controller en globally)
 * https://www.tutorialspoint.com/spring_boot/spring_boot_cors_support.htm
 *
 * Zoals je hieronder ziet, kun je ook op klasse-niveau een adres configureren. Iaw alle methodes hieronder, hebben
 * /api/auth voor de link staan.
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    AuthorizationService authorizationService;

    @PostMapping("/signin")
    public ResponseEntity<JwtResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        return authorizationService.authenticateUser(loginRequest);
    }

    @PostMapping("/signup")
    public ResponseEntity<MessageResponse> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        return authorizationService.registerUser(signUpRequest);
    }


}
