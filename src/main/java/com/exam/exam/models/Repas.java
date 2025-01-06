package com.exam.exam.models;


import java.util.List;

import java.util.List;

public class Repas {
    private int id;
    private PlatPrincipal platPrincipal;  // Plat principal du repas
    private List<Ingredient> ingredients;  // Liste des ingrédients spécifiques
    private List<Supplement> supplements;  // Liste des suppléments du repas

    // Constructeur par défaut
    public Repas() {}

    // Constructeur avec paramètres
    public Repas(int id, PlatPrincipal platPrincipal, List<Ingredient> ingredients, List<Supplement> supplements) {
        this.id = id;
        this.platPrincipal = platPrincipal;
        this.ingredients = ingredients;
        this.supplements = supplements;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PlatPrincipal getPlatPrincipal() {
        return platPrincipal;
    }

    public void setPlatPrincipal(PlatPrincipal platPrincipal) {
        this.platPrincipal = platPrincipal;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Supplement> getSupplements() {
        return supplements;
    }

    public void setSupplements(List<Supplement> supplements) {
        this.supplements = supplements;
    }

    // Méthode pour calculer le prix total du repas, incluant les ingrédients et suppléments
    public double calculerPrixTotal() {
        double prixTotal = platPrincipal.calculerPrix(); // Ajouter le prix du plat principal

        if (ingredients != null) {
            for (Ingredient ingredient : ingredients) {
                prixTotal += ingredient.getPrixUnitaire() * ingredient.getQuantite();
            }
        }

        if (supplements != null) {
            for (Supplement supplement : supplements) {
                prixTotal += supplement.getPrix();
            }
        }

        return prixTotal;
    }

    // Méthode toString pour afficher les informations du repas
    @Override
    public String toString() {
        return "Repas {" +
                "id=" + id +
                ", platPrincipal=" + platPrincipal.getNom() +
                ", prixTotal=" + calculerPrixTotal() +
                '}';
    }
}

//public class Repas {
//    private int id;
//    private PlatPrincipal platPrincipal; // Plat principal du repas
//    private List<Ingredient> ingredients; // Liste des ingrédients associés au repas
//    private List<Supplement> supplements; // Liste des suppléments associés au repas
//
//    // Constructeur par défaut
//    public Repas() {}
//
//    // Constructeur avec paramètres
//    public Repas(int id, PlatPrincipal platPrincipal, List<Ingredient> ingredients, List<Supplement> supplements) {
//        this.id = id;
//        this.platPrincipal = platPrincipal;
//        this.ingredients = ingredients;
//        this.supplements = supplements;
//    }
//
//    // Getters et Setters
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public PlatPrincipal getPlatPrincipal() {
//        return platPrincipal;
//    }
//
//    public void setPlatPrincipal(PlatPrincipal platPrincipal) {
//        this.platPrincipal = platPrincipal;
//    }
//
//    public List<Ingredient> getIngredients() {
//        return ingredients;
//    }
//
//    public void setIngredients(List<Ingredient> ingredients) {
//        this.ingredients = ingredients;
//    }
//
//    public List<Supplement> getSupplements() {
//        return supplements;
//    }
//
//    public void setSupplements(List<Supplement> supplements) {
//        this.supplements = supplements;
//    }
//
//    // Méthode pour calculer le prix total du repas
//    public double calculerPrixTotal() {
//        double prixTotal = platPrincipal.calculerPrix(); // Prix du plat principal
//        if (ingredients != null) {
//            for (Ingredient ingredient : ingredients) {
//                prixTotal += ingredient.getPrixUnitaire() * ingredient.getQuantite();
//            }
//        }
//        if (supplements != null) {
//            for (Supplement supplement : supplements) {
//                prixTotal += supplement.getPrix();
//            }
//        }
//        return prixTotal;
//    }
//
//    // Méthode toString pour afficher les informations du repas
//    @Override
//    public String toString() {
//        return "Repas {" +
//                "id=" + id +
//                ", platPrincipal=" + platPrincipal +
//                ", prixTotal=" + calculerPrixTotal() +
//                '}';
//    }
//}
