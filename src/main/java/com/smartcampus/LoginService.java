package com.smartcampus;

public class LoginService {
    
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