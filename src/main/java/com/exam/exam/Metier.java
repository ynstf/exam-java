package com.exam.exam;

import com.exam.exam.models.Ingredient;
import com.exam.exam.models.PlatPrincipal;
import com.exam.exam.models.Repas;
import com.exam.exam.models.Supplement;

import java.util.List;

public class Metier {
    public static void main(String[] args) {
        // Ingredients pour les plats
        Ingredient ingredient1 = new Ingredient(1, "Viande", 5.0, 250);
        Ingredient ingredient2 = new Ingredient(2, "Pruneaux", 2.0, 100);
        Ingredient ingredient3 = new Ingredient(3, "Poisson", 6.0, 250);
        Ingredient ingredient4 = new Ingredient(4, "Carotte", 1.0, 100);
        Ingredient ingredient5 = new Ingredient(5, "Pomme de terre", 0.5, 100);
        Ingredient ingredient6 = new Ingredient(6, "Olive", 3.0, 50);

        // Suppléments
        Supplement supplement1 = new Supplement(1, "Frites", 11.0,"wow");
        Supplement supplement2 = new Supplement(2, "Boisson", 12.0,"wow");
        Supplement supplement3 = new Supplement(3, "Jus d'orange", 13.0,"wow");
        Supplement supplement4 = new Supplement(4, "Salade nicoise", 14.0,"wow");

        // PlatPrincipal
        PlatPrincipal platPrincipal1 = new PlatPrincipal(1, "Tajine de viande & Pruneaux", "Plat à base de viande et pruneaux", List.of(ingredient1, ingredient2));
        PlatPrincipal platPrincipal2 = new PlatPrincipal(2, "Tajine de poulet & légumes", "Plat à base de poulet et légumes", List.of(ingredient3, ingredient4, ingredient5, ingredient6));

        // Repas
        Repas repas1 = new Repas(1, platPrincipal1, List.of(ingredient1, ingredient2), List.of(supplement1, supplement2));
        Repas repas2 = new Repas(2, platPrincipal2, List.of(ingredient3, ingredient4, ingredient5, ingredient6), List.of(supplement3, supplement4));

        // Affichage du ticket
        System.out.println("**************************************");
        System.out.println("          TICKET DE COMMANDE          ");
        System.out.println("**************************************");
        System.out.println("Bienvenue Ali baba");
        System.out.println("TICKET");
        System.out.println("Nom: Ali baba");
        System.out.println("Nombre de repas: 2");
        System.out.println("Repas N°1: " + repas1.getPlatPrincipal().getNom());
        System.out.println("Ingrédients:");
        for (Ingredient ingredient : repas1.getIngredients()) {
            System.out.println(ingredient.getNom() + ": " + ingredient.getQuantite() + " gramme");
        }
        System.out.println("Suppléments:");
        for (Supplement supplement : repas1.getSupplements()) {
            System.out.println(supplement.getPrix());
        }
        System.out.println("Repas N°2: " + repas2.getPlatPrincipal().getNom());
        System.out.println("Ingrédients:");
        for (Ingredient ingredient : repas2.getIngredients()) {
            System.out.println(ingredient.getNom() + ": " + ingredient.getQuantite() + " gramme");
        }
        System.out.println("Suppléments:");
        for (Supplement supplement : repas2.getSupplements()) {
            System.out.println(supplement.getPrix());
        }
        System.out.println("Total: " + (repas1.calculerPrixTotal() + repas2.calculerPrixTotal()));
    }
}
