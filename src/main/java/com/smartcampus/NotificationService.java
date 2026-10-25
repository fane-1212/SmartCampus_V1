package com.smartcampus;

import java.util.ArrayList;
import java.util.List;

public class RoomService {
    
    // SC-49 : Simulation de la base de données des salles
    private List<String> rooms;

    public RoomService() {
        rooms = new ArrayList<>();
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
        System.out.println("Total : " + rooms.size() + " salles.");
        System.out.println("=====================================");
    }
}