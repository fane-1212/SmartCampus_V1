package com.smartcampus;

public class StatisticsService {
    private int successfulLogins = 0;
    private int failedLogins = 0;

    public void recordSuccess() {
        successfulLogins++;
    }

    public void recordFailure() {
        failedLogins++;
    }

    // SC-71 : Méthode pour exporter les statistiques
    public void exportStatistics() {
        System.out.println("=== EXPORT DES STATISTIQUES ===");
        System.out.println("Connexions réussies : " + successfulLogins);
        System.out.println("Connexions échouées : " + failedLogins);
        System.out.println("Total des tentatives : " + (successfulLogins + failedLogins));
        System.out.println("===============================");
    }
}