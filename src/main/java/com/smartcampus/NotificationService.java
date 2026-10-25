package com.smartcampus;

public class LoginService {
    
    private String validEmail = "etudiant@ensak.ac.ma";
    private String validPassword = "SmartCampus2026!";
    
    private int failedAttempts = 0;
    private boolean isBlocked = false;
    
    // SC-19 : Variables pour la protection temporelle
    private long blockTime = 0; 
    private final long LOCKOUT_DURATION = 5 * 60 * 1000; // 5 minutes en millisecondes

    public boolean authenticate(String email, String password) {
        // SC-19 : Vérifier si la période de blocage est terminée
        if (isBlocked) {
            if (System.currentTimeMillis() - blockTime > LOCKOUT_DURATION) {
                isBlocked = false;
                failedAttempts = 0; // On réinitialise
                System.out.println("Le temps de blocage est écoulé. Vous pouvez réessayer.");
            } else {
                System.out.println("Compte temporairement bloqué. Veuillez patienter.");
                return false;
            }
        }

        if (email == null || password == null || email.isEmpty() || password.isEmpty()) {
            return false;
        }

        if (email.equals(validEmail) && password.equals(validPassword)) {
            failedAttempts = 0; // Succès, on remet à zéro
            return true;
        } else {
            failedAttempts++;
            if (failedAttempts >= 3) {
                isBlocked = true;
                blockTime = System.currentTimeMillis(); // SC-19 : On enregistre l'heure du blocage
            }
            return false;
        }
    }

    public String getErrorMessage() {
        if (isBlocked) {
            return "Votre compte est bloqué temporairement suite à 3 tentatives échouées.";
        } else if (failedAttempts > 0) {
            return "Identifiant ou mot de passe incorrect. Tentative " + failedAttempts + "/3.";
        }
        return "Identifiant ou mot de passe incorrect.";
    }

    public boolean changePassword(String email, String oldPassword, String newPassword) {
        if (!email.equals(validEmail) || !oldPassword.equals(validPassword)) return false;
        if (newPassword == null || newPassword.length() < 8) return false;
        this.validPassword = newPassword;
        return true;
    }
}