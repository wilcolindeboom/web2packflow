package nl.novi.lindeboom.web2packflow.payload.request;

import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Validated
public class SignupRequest extends LoginRequest{

    @NotBlank(message = "email cannot be empty")
    @Size(max = 50,message = "email should have maximum 50 characters")
    @Email
    private String email;

    private Set<String> role;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<String> getRole() {
        return this.role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }
}
