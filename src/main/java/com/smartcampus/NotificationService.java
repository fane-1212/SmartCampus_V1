package com.smartcampus;

import java.util.ArrayList;
import java.util.List;

public class RoomService {
    
    private List<String> rooms;
    // SC-46 : Liste pour stocker les salles en maintenance/désactivées
    private List<String> disabledRooms;

    public RoomService() {
        rooms = new ArrayList<>();
        disabledRooms = new ArrayList<>();
        
        rooms.add("Amphi A - 200 places");
        rooms.add("Salle TD1 - 30 places");
        rooms.add("Salle TP Info - 20 places");
        rooms.add("Salle Réunion - 10 places");
    }

    // SC-49 : Méthode pour exporter et afficher la liste des salles
    public void exportRoomList() {
        System.out.println("=== EXPORT DE LA LISTE DES SALLES ===");
        if (rooms.isEmpty()) {
            System.out.println("Aucune salle disponible.");
        } else {
            for (int i = 0; i < rooms.size(); i++) {
                System.out.println((i + 1) + ". " + rooms.get(i));
            }
        }
        System.out.println("Total : " + rooms.size() + " salles disponibles.");
        System.out.println("=====================================");
    }

    // SC-46 : Désactiver une salle
    public void disableRoom(String roomName) {
        if (rooms.remove(roomName)) {
            disabledRooms.add(roomName);
            System.out.println("La salle '" + roomName + "' a été désactivée (ex: travaux).");
        } else {
            System.out.println("Salle introuvable dans la liste des salles actives.");
        }
    }

    // SC-46 : Réactiver une salle
    public void reactivateRoom(String roomName) {
        if (disabledRooms.remove(roomName)) {
            rooms.add(roomName);
            System.out.println("La salle '" + roomName + "' a été réactivée avec succès.");
        } else {
            System.out.println("Salle introuvable dans la liste des salles désactivées.");
        }
    }
}