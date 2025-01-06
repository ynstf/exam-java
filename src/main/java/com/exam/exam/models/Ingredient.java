package com.exam.exam.models;

public class Ingredient {
    private int id;
    private String nom;
    private double prixUnitaire;
    private int quantite;

    // Constructeur par défaut
    public Ingredient() {}

    // Constructeur avec paramètres
    public Ingredient(int id, String nom, double prixUnitaire, int quantite) {
        this.id = id;
        this.nom = nom;
        this.prixUnitaire = prixUnitaire;
        this.quantite = quantite;
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

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    // Méthode pour calculer le coût total de l'ingrédient (prix unitaire * quantité)
    public double calculerCout() {
        return prixUnitaire * quantite;
    }

    // Méthode toString pour afficher les informations de l'ingrédient
    @Override
    public String toString() {
        return "Ingredient {" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prixUnitaire=" + prixUnitaire +
                ", quantite=" + quantite +
                ", coût total=" + calculerCout() +
                '}';
    }
}
