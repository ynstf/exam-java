package com.exam.exam.models;

import java.util.List;

public class PlatPrincipal {
    private int id;
    private String nom;
    private String description;
    private List<Ingredient> ingredients; // Liste des ingrédients associés au plat

    // Constructeur par défaut
    public PlatPrincipal() {}

    // Constructeur avec paramètres
    public PlatPrincipal(int id, String nom, String description, List<Ingredient> ingredients) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.ingredients = ingredients;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    // Méthode pour calculer le prix du plat selon sa composition
    public double calculerPrix() {
        double prixTotal = 0.0;
        if (ingredients != null) {
            for (Ingredient ingredient : ingredients) {
                prixTotal += ingredient.getPrixUnitaire() * ingredient.getQuantite();
            }
        }
        return prixTotal;
    }

    // Méthode toString pour afficher les informations du plat
    @Override
    public String toString() {
        return "PlatPrincipal {" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", prixTotal=" + calculerPrix() +
                '}';
    }
}
