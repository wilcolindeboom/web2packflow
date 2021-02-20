package nl.novi.lindeboom.web2packflow.payload.request;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Validated
public class LoginRequest {

    @NotBlank(message = "username cannot be empty")
    @Size(min = 3, max = 20,message = "username should have minimum 3 and maximum 20 characters")
    private String username;

    @NotNull(message = "password cannot be empty")
    @Size(min = 6, max = 40,message = "password should have minimum 6 and maximum 40 characters")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
