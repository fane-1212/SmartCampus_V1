package com.smartcampus;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class ReservationService {
    
    private List<String> waitingList = new ArrayList<>();
    
    // SC-52 : Simulation d'une base de données des réservations (Email -> Liste de salles)
    private Map<String, List<String>> userReservations = new HashMap<>();

    // SC-58 : S'inscrire en liste d'attente
    public void joinWaitingList(String email, String roomName) {
        if (email == null || roomName == null || email.isEmpty()) return;
        waitingList.add(email + " attend la salle " + roomName);
        System.out.println("L'utilisateur " + email + " a été ajouté à la liste d'attente pour la salle : " + roomName);
    }

    public List<String> getWaitingList() {
        return waitingList;
    }

    // SC-54 : Annuler une réservation
    public void cancelReservation(String email, String roomName) {
        if (email == null || roomName == null || email.isEmpty()) return;
        
        if (userReservations.containsKey(email)) {
            userReservations.get(email).remove(roomName);
        }
        
        System.out.println("La réservation de " + email + " pour la salle " + roomName + " a été annulée.");
        if (!waitingList.isEmpty()) {
            String nextUser = waitingList.remove(0);
            System.out.println("-> La place a été attribuée automatiquement à : " + nextUser);
        }
    }

    // SC-52 : Ajouter une réservation (nécessaire pour pouvoir la consulter après)
    public void addReservation(String email, String roomName) {
        userReservations.computeIfAbsent(email, k -> new ArrayList<>()).add(roomName);
        System.out.println("Réservation confirmée pour " + email + " : " + roomName);
    }

    // SC-52 : Consulter les réservations d'un utilisateur
    public void displayUserReservations(String email) {
        List<String> reservations = userReservations.getOrDefault(email, new ArrayList<>());
        
        System.out.println("=== MES RÉSERVATIONS (" + email + ") ===");
        if (reservations.isEmpty()) {
            System.out.println("Vous n'avez aucune réservation active.");
        } else {
            for (String room : reservations) {
                System.out.println("- Salle : " + room);
            }
        }
        System.out.println("=================================");
    }
}