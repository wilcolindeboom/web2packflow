package nl.novi.lindeboom.web2packflow.controller;

import nl.novi.lindeboom.web2packflow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

}
