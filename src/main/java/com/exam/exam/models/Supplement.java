package com.exam.exam.models;
//

public class Supplement {
    private int id;
    private String nom;
    private double prix;
    private String description;

    // Constructeur par défaut
    public Supplement() {}

    // Constructeur avec paramètres
    public Supplement(int id, String nom, double prix, String description) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.description = description;
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

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Méthode toString pour afficher les informations du supplément
    @Override
    public String toString() {
        return "Supplement {" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prix=" + prix +
                ", description='" + description + '\'' +
                '}';
    }
}
