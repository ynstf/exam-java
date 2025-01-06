package com.exam.exam.dao;
import com.exam.exam.models.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;


public class ClientDAOImpl implements ClientDAO {


        public static void main(String[] args) {
            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/resto", "root", "");
                ClientDAO clientDAO = new ClientDAOImpl(connection);

                // Créer un client
                Client client = new Client(0, "Alice", "alice@example.com", "0123456789", "123 Rue A");
                clientDAO.create(client);

                // Lire un client
                Client retrievedClient = clientDAO.read(1);
                if (retrievedClient != null) {
                    System.out.println("Client trouvé : " + retrievedClient);
                }

                // Mettre à jour un client
                if (retrievedClient != null) {
                    retrievedClient.setNom("Alice Updated");
                    clientDAO.update(retrievedClient);
                }

                // Afficher tous les clients
                clientDAO.afficherClients();

                // Supprimer un client
                clientDAO.delete(1);

            } catch (Exception e) {
                System.out.println("Erreur : " + e.getMessage());
            }

    }

    private Connection connection;

    // Constructor to initialize the database connection
    public ClientDAOImpl(Connection connection) {
        this.connection = connection;
    }

    // CREATE : Ajouter un client
    @Override
    public void create(Client client) {
        String query = "INSERT INTO Client (nom, email, telephone, adresse) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, client.getNom());
            stmt.setString(2, client.getEmail());
            stmt.setString(3, client.getTelephone());
            stmt.setString(4, client.getAdresse());
            stmt.executeUpdate();
            System.out.println("Client ajouté avec succès.");
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout du client : " + e.getMessage());
        }
    }

    // READ : Trouver un client par ID
    @Override
    public Client read(int id) {
        String query = "SELECT * FROM Client WHERE id = ?";
        Client client = null;

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                client = new Client(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("email"),
                        rs.getString("telephone"),
                        rs.getString("adresse")
                );
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération du client : " + e.getMessage());
        }

        return client;
    }

    // UPDATE : Mettre à jour un client
    @Override
    public boolean update(Client client) {
        String query = "UPDATE Client SET nom = ?, email = ?, telephone = ?, adresse = ? WHERE id = ?";
        boolean isUpdated = false;

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, client.getNom());
            stmt.setString(2, client.getEmail());
            stmt.setString(3, client.getTelephone());
            stmt.setString(4, client.getAdresse());
            stmt.setInt(5, client.getId());

            int rowsAffected = stmt.executeUpdate();
            isUpdated = rowsAffected > 0;

            if (isUpdated) {
                System.out.println("Client mis à jour avec succès.");
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la mise à jour du client : " + e.getMessage());
        }

        return isUpdated;
    }

    // DELETE : Supprimer un client
    @Override
    public boolean delete(int id) {
        String query = "DELETE FROM Client WHERE id = ?";
        boolean isDeleted = false;

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            isDeleted = rowsAffected > 0;

            if (isDeleted) {
                System.out.println("Client supprimé avec succès.");
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression du client : " + e.getMessage());
        }

        return isDeleted;
    }

    // Afficher tous les clients
    @Override
    public void afficherClients() {
        String query = "SELECT * FROM Client";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Nom: " + rs.getString("nom") +
                        ", Email: " + rs.getString("email") +
                        ", Téléphone: " + rs.getString("telephone") +
                        ", Adresse: " + rs.getString("adresse"));
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'affichage des clients : " + e.getMessage());
        }
    }
}
