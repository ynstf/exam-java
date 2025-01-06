package com.exam.exam.models;

import java.util.List;

public class Commande {
    private int id;
    private Client client;
    private List<Repas> repas;

    // Constructeur par défaut
    public Commande() {}

    // Constructeur avec paramètres
    public Commande(int id, Client client, List<Repas> repas) {
        this.id = id;
        this.client = client;
        this.repas = repas;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Repas> getRepas() {
        return repas;
    }

    public void setRepas(List<Repas> repas) {
        this.repas = repas;
    }

    // Méthode pour calculer le total de la commande
    public double calculerTotalCommande() {
        double total = 0;
        if (repas != null) {
            for (Repas repasItem : repas) {
                total += repasItem.calculerPrixTotal();
            }
        }
        return total;
    }
}

//public class Commande {
//    private int id;
//    private List<Repas> repas; // Liste des repas associés à la commande
//
//    // Constructeur par défaut
//    public Commande() {}
//
//    // Constructeur avec paramètres
//    public Commande(int id, List<Repas> repas) {
//        this.id = id;
//        this.repas = repas;
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
//    public List<Repas> getRepas() {
//        return repas;
//    }
//
//    public void setRepas(List<Repas> repas) {
//        this.repas = repas;
//    }
//
//    // Méthode pour calculer le prix total de la commande
//    public double calculerPrixTotalCommande() {
//        double prixTotalCommande = 0.0;
//        if (repas != null) {
//            for (Repas repasItem : repas) {
//                prixTotalCommande += repasItem.calculerPrixTotal();
//            }
//        }
//        return prixTotalCommande;
//    }
//
//    // Méthode toString pour afficher les informations de la commande
//    @Override
//    public String toString() {
//        return "Commande {" +
//                "id=" + id +
//                ", prixTotalCommande=" + calculerPrixTotalCommande() +
//                '}';
//    }
//}
