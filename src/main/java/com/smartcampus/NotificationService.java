package com.smartcampus;

public class LoginService {
    
    private String validEmail = "etudiant@ensak.ac.ma";
    private String validPassword = "SmartCampus2026!";
    
    // SC-13 : Variables pour gérer le bug des 3 échecs
    private int failedAttempts = 0;
    private boolean isBlocked = false;

    public boolean authenticate(String email, String password) {
        if (isBlocked) {
            System.out.println("Compte bloqué. Veuillez contacter l'administrateur.");
            return false;
        }

        if (email == null || password == null || email.isEmpty() || password.isEmpty()) {
            return false;
        }

        if (email.equals(validEmail) && password.equals(validPassword)) {
            failedAttempts = 0; // On remet le compteur à zéro en cas de succès
            return true;
        } else {
            failedAttempts++;
            if (failedAttempts >= 3) {
                isBlocked = true;
            }
            return false;
        }
    }

    // SC-13 : Message corrigé qui change selon le nombre d'échecs
    public String getErrorMessage() {
        if (isBlocked) {
            return "Votre compte est bloqué suite à 3 tentatives échouées.";
        } else if (failedAttempts > 0) {
            return "Identifiant ou mot de passe incorrect. Tentative " + failedAttempts + "/3.";
        }
        return "Identifiant ou mot de passe incorrect.";
    }

    public boolean changePassword(String email, String oldPassword, String newPassword) {
        if (!email.equals(validEmail) || !oldPassword.equals(validPassword)) {
            System.out.println("Erreur : Ancien mot de passe incorrect.");
            return false;
        }
        if (newPassword == null || newPassword.length() < 8) {
            System.out.println("Erreur : Le nouveau mot de passe doit contenir au moins 8 caractères.");
            return false;
        }
        this.validPassword = newPassword;
        System.out.println("Succès : Votre mot de passe a bien été modifié.");
        return true;
    }
}