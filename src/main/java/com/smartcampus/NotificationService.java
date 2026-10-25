package com.smartcampus;

import java.util.ArrayList;
import java.util.List;

public class ReservationService {
    
    // SC-58 : Liste pour stocker les étudiants en attente
    private List<String> waitingList = new ArrayList<>();

    // SC-58 : Méthode pour s'inscrire en liste d'attente
    public void joinWaitingList(String email, String roomName) {
        if (email == null || roomName == null || email.isEmpty()) {
            return;
        }
        
        String entry = email + " attend la salle " + roomName;
        waitingList.add(entry);
        
        System.out.println("--- LISTE D'ATTENTE ---");
        System.out.println("L'utilisateur " + email + " a été ajouté à la liste d'attente pour la salle : " + roomName);
        System.out.println("Position dans la file d'attente : " + waitingList.size());
        System.out.println("-----------------------");
    }

    public List<String> getWaitingList() {
        return waitingList;
    }
}