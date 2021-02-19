package nl.novi.lindeboom.web2packflow.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    public String generatePublicContent() {
        return "Public Content.";
    }


    public String generateUserContent() {
        return "User Content.";
    }


    public String generateEditContent() {
        return "Editor Content.";
    }


    public String generateAdminContent() {
        return "Admin Content.";
    }

}
