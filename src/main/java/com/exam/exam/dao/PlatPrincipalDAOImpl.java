package com.exam.exam.dao;

import com.exam.exam.models.PlatPrincipal;
import com.exam.exam.models.Ingredient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlatPrincipalDAOImpl implements PlatPrincipalDAO {

    private Connection connection;

    public PlatPrincipalDAOImpl(Connection connection) {
        this.connection = connection;
    }

    // CREATE : Ajouter un plat principal
    @Override
    public void create(PlatPrincipal platPrincipal) {
        String query = "INSERT INTO PlatPrincipal (nom, description) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, platPrincipal.getNom());
            stmt.setString(2, platPrincipal.getDescription());
            stmt.executeUpdate();
            System.out.println("Plat principal ajouté avec succès.");
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout du plat principal : " + e.getMessage());
        }
    }

    // READ : Trouver un plat principal par ID
    @Override
    public PlatPrincipal read(int id) {
        String query = "SELECT * FROM PlatPrincipal WHERE id = ?";
        PlatPrincipal platPrincipal = null;
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                platPrincipal = new PlatPrincipal(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("description"),
                        getIngredientsForPlat(id) // Obtenir les ingrédients du plat
                );
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération du plat principal : " + e.getMessage());
        }
        return platPrincipal;
    }

    // UPDATE : Mettre à jour un plat principal
    @Override
    public boolean update(PlatPrincipal platPrincipal) {
        String query = "UPDATE PlatPrincipal SET nom = ?, description = ? WHERE id = ?";
        boolean isUpdated = false;

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, platPrincipal.getNom());
            stmt.setString(2, platPrincipal.getDescription());
            stmt.setInt(3, platPrincipal.getId());

            int rowsAffected = stmt.executeUpdate();
            isUpdated = rowsAffected > 0;

            if (isUpdated) {
                System.out.println("Plat principal mis à jour avec succès.");
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la mise à jour du plat principal : " + e.getMessage());
        }

        return isUpdated;
    }

    // DELETE : Supprimer un plat principal
    @Override
    public boolean delete(int id) {
        String query = "DELETE FROM PlatPrincipal WHERE id = ?";
        boolean isDeleted = false;

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            isDeleted = rowsAffected > 0;

            if (isDeleted) {
                System.out.println("Plat principal supprimé avec succès.");
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression du plat principal : " + e.getMessage());
        }

        return isDeleted;
    }

    // Afficher tous les plats principaux
    @Override
    public void afficherPlatsPrincipaux() {
        String query = "SELECT * FROM PlatPrincipal";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                PlatPrincipal platPrincipal = new PlatPrincipal(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("description"),
                        getIngredientsForPlat(rs.getInt("id"))
                );
                System.out.println(platPrincipal);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'affichage des plats principaux : " + e.getMessage());
        }
    }

    // Obtenir la liste des ingrédients associés à un plat principal
    @Override
    public List<Ingredient> getIngredientsForPlat(int platId) {
        String query = "SELECT i.* FROM Ingredient i " +
                "JOIN Plat_Ingredient pi ON i.id = pi.ingredient_id " +
                "WHERE pi.plat_id = ?";
        List<Ingredient> ingredients = new ArrayList<>();

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, platId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Ingredient ingredient = new Ingredient(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getDouble("prix"),
                        rs.getInt("quantiteDisponible")
                );
                ingredients.add(ingredient);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération des ingrédients : " + e.getMessage());
        }

        return ingredients;
    }
}
