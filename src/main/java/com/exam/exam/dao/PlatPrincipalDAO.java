package com.exam.exam.dao;


import com.exam.exam.models.Ingredient;
import com.exam.exam.models.PlatPrincipal;
import java.util.List;

public interface PlatPrincipalDAO {

    // CREATE : Ajouter un plat principal
    void create(PlatPrincipal platPrincipal);

    // READ : Trouver un plat principal par ID
    PlatPrincipal read(int id);

    // UPDATE : Mettre à jour un plat principal
    boolean update(PlatPrincipal platPrincipal);

    // DELETE : Supprimer un plat principal
    boolean delete(int id);

    // Afficher tous les plats principaux
    void afficherPlatsPrincipaux();

    // Obtenir la liste des ingrédients associés à un plat principal
    List<Ingredient> getIngredientsForPlat(int platId);
}
