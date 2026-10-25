package com.smartcampus;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LoginServiceTest {
    private final LoginService service = new LoginService();

    @Test
    void acceptsValidCredentials() {
        assertTrue(service.authenticate("etudiant@ensak.ac.ma", "SmartCampus2026!"));
    }

    @Test
    void rejectsInvalidCredentials() {
        assertFalse(service.authenticate("etudiant@ensak.ac.ma", "MauvaisMotDePasse"));
    }

    @Test
    void rejectsEmptyFields() {
        assertFalse(service.authenticate("", ""));
        assertFalse(service.authenticate(null, "password"));
    }
}