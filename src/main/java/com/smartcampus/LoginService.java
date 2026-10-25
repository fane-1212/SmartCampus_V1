package com.smartcampus;

public class LoginService {
    
    public boolean authenticate(String email, String password) {
        // Critère d'acceptation 1 : vérifier que les champs ne sont pas vides
        if (email == null || password == null || email.isEmpty() || password.isEmpty()) {
            return false;
        }
        
        // Critère d'acceptation 2 : vérifier les identifiants (simulation)
        // On imagine que l'étudiant a ce compte dans la base de données
        if (email.equals("etudiant@ensak.ac.ma") && password.equals("SmartCampus2026!")) {
            return true; // Connexion réussie
        }
        
        return false; // Échec de connexion
    }
}