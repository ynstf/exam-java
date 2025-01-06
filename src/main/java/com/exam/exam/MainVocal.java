package com.exam.exam;

import com.exam.exam.models.AssistantVocal;

public class MainVocal {
    public static void main(String[] args) {
        // Créer une instance de l'assistant vocal
        AssistantVocal assistant = new AssistantVocal();

        // Simuler la capture audio d'une commande
        String audio = assistant.capturerCommandeAudio();
        System.out.println("Commande audio simulée : " + audio);

        // Transcrire l'audio en texte
        String commande = assistant.transcrireAudioTexte(audio);
        System.out.println("Commande transcrite : " + commande);

        // Traiter la commande (l'ajouter à la liste des commandes existantes)
        assistant.traiterCommande(commande);

        // Afficher toutes les commandes existantes
        System.out.println("\nListe des commandes existantes :");
        assistant.afficherCommandes();
    }
}