package com.exam.exam.dao;
import com.exam.exam.models.Client;

public interface ClientDAO {

    // CREATE : Ajouter un client
    void create(Client client);

    // READ : Trouver un client par ID
    Client read(int id);

    // UPDATE : Mettre à jour un client
    boolean update(Client client);

    // DELETE : Supprimer un client
    boolean delete(int id);

    // Afficher tous les clients
    void afficherClients();
}
