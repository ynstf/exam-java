package com.exam.exam.models;

import java.util.ArrayList;
import java.util.List;

public class AssistantVocal {

    // Liste des commandes existantes
    private List<String> commandesExistantes = new ArrayList<>();

    public String capturerCommandeAudio() {
        // Simule une commande audio
        return "Ajouter 2 plats de pâtes";
    }

    public String transcrireAudioTexte(String audio) {
        // Simule la transcription de l'audio en texte
        return audio; // Dans une vraie application, on utiliserait une API de reconnaissance vocale
    }

    public void traiterCommande(String commande) {
        commandesExistantes.add(commande);
        System.out.println("Commande traitée : " + commande);
    }

    public void afficherCommandes() {
        System.out.println("Commandes existantes :");
        for (String commande : commandesExistantes) {
            System.out.println("- " + commande);
        }
    }
}