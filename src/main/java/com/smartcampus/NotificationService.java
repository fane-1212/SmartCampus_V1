package com.smartcampus;

public class NotificationService {
    
    // SC-85 : Méthode pour notifier un utilisateur de son changement de rôle
    public void sendRoleChangeNotification(String email, String newRole) {
        if (email == null || newRole == null) {
            return;
        }
        
        System.out.println("--- NOTIFICATION ENVOYÉE ---");
        System.out.println("À : " + email);
        System.out.println("Objet : Modification de votre rôle sur SmartCampus");
        System.out.println("Message : Bonjour, votre rôle a été mis à jour. Vous êtes désormais : " + newRole);
        System.out.println("----------------------------");
    }

    // SC-63 : Méthode pour notifier une annulation de réservation
    public void sendCancellationNotification(String email, String roomName, String date) {
        if (email == null || roomName == null || date == null) {
            return;
        }
        
        System.out.println("--- NOTIFICATION D'ANNULATION ---");
        System.out.println("À : " + email);
        System.out.println("Objet : Annulation de votre réservation");
        System.out.println("Message : Votre réservation pour la salle " + roomName + " le " + date + " a bien été annulée.");
        System.out.println("---------------------------------");
    }
}