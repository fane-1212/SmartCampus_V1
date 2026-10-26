package com.smartcampus;

public class LoginService {
    
    private final String VALID_EMAIL = "etudiant@ensak.ac.ma";
    private final String VALID_PASSWORD = "SmartCampus2026!";

    public boolean authenticate(String email, String password) {
        // SC-75 : Validation des entrées de l'API
        if (email == null || password == null || email.isEmpty() || password.isEmpty()) {
            return false;
        }
        
        // Validation du format de l'email (doit contenir @ et .)
        if (!email.contains("@") || !email.contains(".")) {
            System.out.println("Erreur: Format d'email invalide.");
            return false;
        }

        // Validation de la longueur du mot de passe (minimum 8 caractères)
        if (password.length() < 8) {
            System.out.println("Erreur: Le mot de passe doit contenir au moins 8 caractères.");
            return false;
        }
        
        boolean emailMatches = email.equals(VALID_EMAIL);
        boolean passwordMatches = password.equals(VALID_PASSWORD);
        
        return emailMatches && passwordMatches;
    }

    public String getErrorMessage() {
        return "Identifiant ou mot de passe incorrect.";
    private String validEmail = "etudiant@ensak.ac.ma";
    private String validPassword = "SmartCampus2026!";
    
    // Demande 2 de Samira : Compter les tentatives échouées
    private int failedAttempts = 0;
    private String errorMessage = "";

    public boolean authenticate(String email, String password) {
        if (email == null || password == null || email.isEmpty() || password.isEmpty()) {
            this.errorMessage = "E-mail et mot de passe sont obligatoires.";
            return false;
        }

        if (email.equals(validEmail) && password.equals(validPassword)) {
            failedAttempts = 0; // Réinitialisation en cas de succès
            this.errorMessage = "";
            return true;
        } else {
            failedAttempts++;
            // Demande 1 de Samira : Message clair au lieu d'un simple booléen
            if (failedAttempts >= 3) {
                this.errorMessage = "Compte bloqué suite à 3 tentatives échouées.";
            } else {
                this.errorMessage = "E-mail ou mot de passe incorrect.";
            }
            return false;
        }
    }

    // Méthode pour récupérer le message clair
    public String getErrorMessage() {
        return this.errorMessage;
    }
}