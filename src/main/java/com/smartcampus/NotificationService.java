package com.smartcampus;

import java.util.ArrayList;
import java.util.List;

public class RoomService {
    
    private List<String> rooms;
    private List<String> disabledRooms;

    public RoomService() {
        rooms = new ArrayList<>();
        disabledRooms = new ArrayList<>();
        
        rooms.add("Amphi A - 200 places");
        rooms.add("Salle TD1 - 30 places");
        rooms.add("Salle TP Info - 20 places");
        rooms.add("Salle Réunion - 10 places");
    }

    public void exportRoomList() {
        System.out.println("=== EXPORT DE LA LISTE DES SALLES ===");
        for (String room : rooms) {
            System.out.println("- " + room);
        }
        System.out.println("Total : " + rooms.size() + " salles disponibles.");
        System.out.println("=====================================");
    }

    public void disableRoom(String roomName) {
        if (rooms.remove(roomName)) {
            disabledRooms.add(roomName);
            System.out.println("La salle '" + roomName + "' a été désactivée.");
        } else {
            System.out.println("Salle introuvable.");
        }
    }

    public void reactivateRoom(String roomName) {
        if (disabledRooms.remove(roomName)) {
            rooms.add(roomName);
            System.out.println("La salle '" + roomName + "' a été réactivée.");
        } else {
            System.out.println("Salle introuvable.");
        }
    }

    public void updateRoomInfo(String oldRoomName, String newRoomInfo) {
        int index = rooms.indexOf(oldRoomName);
        if (index != -1) {
            rooms.set(index, newRoomInfo);
            System.out.println("Informations modifiées : '" + oldRoomName + "' -> '" + newRoomInfo + "'");
        } else {
            System.out.println("Salle introuvable pour la modification.");
        }
    }

    // SC-41 : Rechercher une salle par mot-clé
    public void searchRoom(String keyword) {
        System.out.println("=== RÉSULTATS DE RECHERCHE POUR '" + keyword + "' ===");
        boolean found = false;
        for (String room : rooms) {
            if (room.toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println("- " + room);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Aucune salle ne correspond à votre recherche.");
        }
        System.out.println("========================================");
    }
}