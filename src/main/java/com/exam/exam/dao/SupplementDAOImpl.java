package com.exam.exam.dao;


import com.exam.exam.models.Supplement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SupplementDAOImpl implements SupplementDAO {

    private Connection connection;

    public SupplementDAOImpl(Connection connection) {
        this.connection = connection;
    }

    // CREATE : Ajouter un supplément
    @Override
    public void create(Supplement supplement) {
        String query = "INSERT INTO Supplement (nom, prix, description) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, supplement.getNom());
            stmt.setDouble(2, supplement.getPrix());
            stmt.setString(3, supplement.getDescription());
            stmt.executeUpdate();
            System.out.println("Supplément ajouté avec succès.");
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout du supplément : " + e.getMessage());
        }
    }

    // READ : Trouver un supplément par ID
    @Override
    public Supplement read(int id) {
        String query = "SELECT * FROM Supplement WHERE id = ?";
        Supplement supplement = null;
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                supplement = new Supplement(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getDouble("prix"),
                        rs.getString("description")
                );
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération du supplément : " + e.getMessage());
        }
        return supplement;
    }

    // UPDATE : Mettre à jour un supplément
    @Override
    public boolean update(Supplement supplement) {
        String query = "UPDATE Supplement SET nom = ?, prix = ?, description = ? WHERE id = ?";
        boolean isUpdated = false;

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, supplement.getNom());
            stmt.setDouble(2, supplement.getPrix());
            stmt.setString(3, supplement.getDescription());
            stmt.setInt(4, supplement.getId());

            int rowsAffected = stmt.executeUpdate();
            isUpdated = rowsAffected > 0;

            if (isUpdated) {
                System.out.println("Supplément mis à jour avec succès.");
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la mise à jour du supplément : " + e.getMessage());
        }

        return isUpdated;
    }

    // DELETE : Supprimer un supplément
    @Override
    public boolean delete(int id) {
        String query = "DELETE FROM Supplement WHERE id = ?";
        boolean isDeleted = false;

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            isDeleted = rowsAffected > 0;

            if (isDeleted) {
                System.out.println("Supplément supprimé avec succès.");
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression du supplément : " + e.getMessage());
        }

        return isDeleted;
    }

    // Afficher tous les suppléments
    @Override
    public void afficherSupplements() {
        String query = "SELECT * FROM Supplement";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Supplement supplement = new Supplement(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getDouble("prix"),
                        rs.getString("description")
                );
                System.out.println(supplement);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'affichage des suppléments : " + e.getMessage());
        }
    }
}
