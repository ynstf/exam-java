package com.exam.exam;

import com.exam.exam.models.AssistantVocal;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AssistantVocalScene {

    private AssistantVocal assistantVocal = new AssistantVocal();

    /**
     * Crée et retourne la scène de l'assistant vocal.
     * @return La scène JavaFX pour l'assistant vocal.
     */
    public Scene createScene() {
        // Composants de l'interface
        Label titleLabel = new Label("Assistant Vocal - Serveur Plat");
        Button startButton = new Button("Démarrer l'enregistrement");
        TextArea commandTextArea = new TextArea();
        commandTextArea.setEditable(false);

        // Action du bouton "Démarrer l'enregistrement"
        startButton.setOnAction(e -> {
            // Simuler la capture audio
            String audio = assistantVocal.capturerCommandeAudio();

            // Transcrire l'audio en texte
            String commande = assistantVocal.transcrireAudioTexte(audio);

            // Afficher la commande dans la zone de texte
            commandTextArea.setText("Commande détectée : " + commande);

            // Traiter la commande
            assistantVocal.traiterCommande(commande);
        });

        // Layout
        VBox layout = new VBox(10);
        layout.getChildren().addAll(titleLabel, startButton, commandTextArea);

        // Créer la scène
        Scene scene = new Scene(layout, 400, 300);
        return scene;
    }
}