package com.smartcampus;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LoginServiceTest {
    
    @Test
    void testSuccessfulLogin() {
        LoginService service = new LoginService();
        assertTrue(service.authenticate("etudiant@ensak.ac.ma", "SmartCampus2026!"));
    }

    @Test
    void testFailedLogin() {
        LoginService service = new LoginService();
        assertFalse(service.authenticate("etudiant@ensak.ac.ma", "MauvaisMotDePasse"));
    }

    @Test
    void testAccountBlockedAfterThreeFailures() {
        LoginService service = new LoginService();
        
        // 1er échec
        service.authenticate("etudiant@ensak.ac.ma", "Faux1");
        // 2ème échec
        service.authenticate("etudiant@ensak.ac.ma", "Faux2");
        // 3ème échec
        service.authenticate("etudiant@ensak.ac.ma", "Faux3");
        
        // Le 4ème essai, même avec le bon mot de passe, doit échouer car le compte est bloqué
        assertFalse(service.authenticate("etudiant@ensak.ac.ma", "SmartCampus2026!"));
        assertTrue(service.getErrorMessage().contains("bloqué"));
    }

    @Test
    void testChangePassword() {
        LoginService service = new LoginService();
        
        // On change le mot de passe
        assertTrue(service.changePassword("etudiant@ensak.ac.ma", "SmartCampus2026!", "NouveauMotDePasse123"));
        
        // On vérifie que l'ancien ne marche plus et que le nouveau marche
        assertFalse(service.authenticate("etudiant@ensak.ac.ma", "SmartCampus2026!"));
        assertTrue(service.authenticate("etudiant@ensak.ac.ma", "NouveauMotDePasse123"));
    }
}