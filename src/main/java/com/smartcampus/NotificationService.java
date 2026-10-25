package com.smartcampus;

import java.util.ArrayList;
import java.util.List;

public class ReservationService {
    
    // SC-58 : Liste pour stocker les étudiants en attente
    private List<String> waitingList = new ArrayList<>();

    // SC-58 : Méthode pour s'inscrire en liste d'attente
    public void joinWaitingList(String email, String roomName) {
        if (email == null || roomName == null || email.isEmpty()) return;
        String entry = email + " attend la salle " + roomName;
        waitingList.add(entry);
        System.out.println("L'utilisateur " + email + " a été ajouté à la liste d'attente pour la salle : " + roomName);
    }

    public List<String> getWaitingList() {
        return waitingList;
    }

    // SC-54 : Méthode pour annuler une réservation
    public void cancelReservation(String email, String roomName) {
        if (email == null || roomName == null || email.isEmpty()) return;
        
        System.out.println("--- ANNULATION DE RÉSERVATION ---");
        System.out.println("La réservation de " + email + " pour la salle " + roomName + " a été annulée avec succès.");
        
        // Si quelqu'un attend, on lui donne la place libérée
        if (!waitingList.isEmpty()) {
            String nextUser = waitingList.remove(0);
            System.out.println("-> La place a été attribuée automatiquement à : " + nextUser);
        }
        System.out.println("---------------------------------");
    }
}