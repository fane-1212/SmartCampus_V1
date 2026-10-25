package com.smartcampus;

public class LoginService {
    
    private final String VALID_EMAIL = "etudiant@ensak.ac.ma";
    private final String VALID_PASSWORD = "SmartCampus2026!";

    public boolean authenticate(String email, String password) {
        if (email == null || password == null || email.isEmpty() || password.isEmpty()) {
            return false;
        }
        boolean emailMatches = email.equals(VALID_EMAIL);
        boolean passwordMatches = password.equals(VALID_PASSWORD);
        
        return emailMatches && passwordMatches;
    }

    public String getErrorMessage() {
        return "Identifiant ou mot de passe incorrect.";
    }
}