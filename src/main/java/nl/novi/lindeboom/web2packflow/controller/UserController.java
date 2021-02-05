package nl.novi.lindeboom.web2packflow.controller;


import nl.novi.lindeboom.web2packflow.domain.User;
import nl.novi.lindeboom.web2packflow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/users")
public class UserController {

    //todo

//    @Autowired
//    private UserService userService;
//
//    @PutMapping(value = "/{username}")
//    public ResponseEntity<Object> updateUser(@PathVariable("username") String username, @RequestBody User user) {
//        userService.updateUser(username, user);
//        return ResponseEntity.noContent().build();
//    }

}
