package com.exam.exam.dao;

import com.exam.exam.models.Ingredient;

import java.util.List;

public interface IngredientDAO {
    // CREATE : Ajouter un ingrédient
    void create(Ingredient ingredient);

    // READ : Trouver un ingrédient par ID
    Ingredient read(int id);

    // UPDATE : Mettre à jour un ingrédient
    boolean update(Ingredient ingredient);

    // DELETE : Supprimer un ingrédient
    boolean delete(int id);

    // Afficher tous les ingrédients
    List<Ingredient> getAllIngredients();
}
