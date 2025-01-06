package com.exam.exam.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnexionDB {

    private static Connection connexion = null;

    private SingletonConnexionDB() {
    }

    public static Connection getConnexion() throws SQLException {
        if (connexion == null || connexion.isClosed()) {
            try {
                // Charger le driver MySQL
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Connexion à la base de données
                String url = "jdbc:mysql://localhost:3306/resto";
                String user = "root";  // Remplacez par votre utilisateur
                String password = "";  // Remplacez par votre mot de passe
                connexion = DriverManager.getConnection(url, user, password);
                System.out.println("connected");
            } catch (ClassNotFoundException e) {
                throw new SQLException("Driver MySQL non trouvé", e);
            }
        }
        return connexion;
    }

    // Méthode pour fermer la connexion
    public static void closeConnexion() {
        if (connexion != null) {
            try {
                connexion.close();
                System.out.println("Connexion fermée.");
            } catch (SQLException e) {
                System.out.println("Erreur lors de la fermeture de la connexion : " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) throws SQLException {
        SingletonConnexionDB conn = new SingletonConnexionDB();
        conn.getConnexion();

    }
}
