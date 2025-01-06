package com.exam.exam.dao;

import com.exam.exam.models.Supplement;
import java.util.List;

public interface SupplementDAO {

    // CREATE : Ajouter un supplément
    void create(Supplement supplement);

    // READ : Trouver un supplément par ID
    Supplement read(int id);

    // UPDATE : Mettre à jour un supplément
    boolean update(Supplement supplement);

    // DELETE : Supprimer un supplément
    boolean delete(int id);

    // Afficher tous les suppléments
    void afficherSupplements();
}
