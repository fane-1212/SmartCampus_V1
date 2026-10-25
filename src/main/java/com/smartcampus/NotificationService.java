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

    // SC-45 : Modifier les informations d'une salle
    public void updateRoomInfo(String oldRoomName, String newRoomInfo) {
        int index = rooms.indexOf(oldRoomName);
        if (index != -1) {
            rooms.set(index, newRoomInfo);
            System.out.println("Les informations de la salle ont été modifiées : '" + oldRoomName + "' -> '" + newRoomInfo + "'");
        } else {
            // On vérifie si elle se trouve dans les salles désactivées
            int disabledIndex = disabledRooms.indexOf(oldRoomName);
            if (disabledIndex != -1) {
                disabledRooms.set(disabledIndex, newRoomInfo);
                System.out.println("Les informations de la salle désactivée ont été modifiées : '" + oldRoomName + "' -> '" + newRoomInfo + "'");
            } else {
                System.out.println("Salle introuvable pour la modification.");
            }
        }
    }
}