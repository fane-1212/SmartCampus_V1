package com.smartcampus;

public class LoginService {
    
    private String validEmail = "etudiant@ensak.ac.ma";
    private String validPassword = "SmartCampus2026!";

    public boolean authenticate(String email, String password) {
        if (email == null || password == null || email.isEmpty() || password.isEmpty()) {
            return false;
        }
        return email.equals(validEmail) && password.equals(validPassword);
    }

    public String getErrorMessage() {
        return "Identifiant ou mot de passe incorrect.";
    }

    // SC-21 : Méthode pour changer le mot de passe
    public boolean changePassword(String email, String oldPassword, String newPassword) {
        // Vérification de l'identité
        if (!email.equals(validEmail) || !oldPassword.equals(validPassword)) {
            System.out.println("Erreur : Ancien mot de passe incorrect.");
            return false;
        }

        // SC-21 : Vérification de la politique de sécurité du nouveau mot de passe
        if (newPassword == null || newPassword.length() < 8) {
            System.out.println("Erreur : Le nouveau mot de passe doit contenir au moins 8 caractères.");
            return false;
        }

        // Mise à jour du mot de passe
        this.validPassword = newPassword;
        System.out.println("Succès : Votre mot de passe a bien été modifié.");
        return true;
    }
}