package com.smartcampus;

public class LoginService {
    
    private String validEmail = "etudiant@ensak.ac.ma";
    private String validPassword = "SmartCampus2026!";
    
    private int failedAttempts = 0;
    private boolean isBlocked = false;
    private long blockTime = 0; 
    private final long LOCKOUT_DURATION = 5 * 60 * 1000; 
    
    // SC-16 : Variable pour simuler l'état de connexion
    private boolean isLoggedIn = false;

    public boolean authenticate(String email, String password) {
        if (isBlocked) {
            if (System.currentTimeMillis() - blockTime > LOCKOUT_DURATION) {
                isBlocked = false;
                failedAttempts = 0;
            } else {
                return false;
            }
        }

        if (email == null || password == null || email.isEmpty() || password.isEmpty()) return false;

        if (email.equals(validEmail) && password.equals(validPassword)) {
            failedAttempts = 0;
            isLoggedIn = true; // SC-16 : L'utilisateur est connecté
            return true;
        } else {
            failedAttempts++;
            if (failedAttempts >= 3) {
                isBlocked = true;
                blockTime = System.currentTimeMillis();
            }
            return false;
        }
    }

    public String getErrorMessage() {
        if (isBlocked) return "Votre compte est bloqué temporairement.";
        if (failedAttempts > 0) return "Identifiant ou mot de passe incorrect. Tentative " + failedAttempts + "/3.";
        return "Identifiant ou mot de passe incorrect.";
    }

    public boolean changePassword(String email, String oldPassword, String newPassword) {
        if (!email.equals(validEmail) || !oldPassword.equals(validPassword)) return false;
        if (newPassword == null || newPassword.length() < 8) return false;
        this.validPassword = newPassword;
        return true;
    }

    // SC-16 : Méthode de déconnexion
    public void logout() {
        if (isLoggedIn) {
            isLoggedIn = false;
            failedAttempts = 0;
            System.out.println("Déconnexion réussie. Vous avez été redirigé vers la page d'accueil.");
        } else {
            System.out.println("Vous n'êtes pas connecté.");
        }
    }
}