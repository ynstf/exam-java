package com.exam.exam.dao;

import com.exam.exam.models.Ingredient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IngredientDAOImpl implements IngredientDAO {
    public static void main(String[] args) {
        try {
            // Établir la connexion à la base de données
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/resto", "root", "");
            IngredientDAO ingredientDAO = new IngredientDAOImpl();

            // ✅ Créer un ingrédient
            Ingredient ingredient = new Ingredient(0, "Tomate", 0.5, 10);
            ingredientDAO.create(ingredient);
            System.out.println("✅ Ingrédient ajouté avec succès!");


        } catch (Exception e) {
            System.out.println("❌ Erreur : " + e.getMessage());
        }
    }
    private final String url = "jdbc:mysql://localhost:3306/resto";
    private final String user = "root";
    private final String password = "";

    // CREATE : Ajouter un ingrédient
    @Override
    public void create(Ingredient ingredient) {
        String sql = "INSERT INTO ingredient (nom, prix, quantiteDisponible) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, ingredient.getNom());
            stmt.setDouble(2, ingredient.getPrixUnitaire());
            stmt.setInt(3, ingredient.getQuantite());
            stmt.executeUpdate();
            System.out.println("Ingrédient ajouté avec succès !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de l'ingrédient : " + e.getMessage());
        }
    }

    // READ : Trouver un ingrédient par ID
    @Override
    public Ingredient read(int id) {
        String sql = "SELECT * FROM ingredient WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Ingredient(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getDouble("prix"),
                        rs.getInt("quantiteDisponible")
                );
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la lecture de l'ingrédient : " + e.getMessage());
        }
        return null;
    }

    // UPDATE : Mettre à jour un ingrédient
    @Override
    public boolean update(Ingredient ingredient) {
        String sql = "UPDATE ingredient SET nom = ?, prix = ?, quantiteDisponible = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, ingredient.getNom());
            stmt.setDouble(2, ingredient.getPrixUnitaire());
            stmt.setInt(3, ingredient.getQuantite());
            stmt.setInt(4, ingredient.getId());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Erreur lors de la mise à jour de l'ingrédient : " + e.getMessage());
        }
        return false;
    }

    // DELETE : Supprimer un ingrédient
    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM Ingredient WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression de l'ingrédient : " + e.getMessage());
        }
        return false;
    }

    // Afficher tous les ingrédients
    @Override
    public List<Ingredient> getAllIngredients() {
        List<Ingredient> ingredients = new ArrayList<>();
        String sql = "SELECT * FROM ingredient";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                ingredients.add(new Ingredient(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getDouble("prix"),
                        rs.getInt("quantiteDisponible")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération des ingrédients : " + e.getMessage());
        }
        return ingredients;
    }
}
