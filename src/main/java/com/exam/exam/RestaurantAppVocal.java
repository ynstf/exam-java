package com.exam.exam;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RestaurantAppVocal extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Restaurant Application");

        // Bouton pour ouvrir l'assistant vocal
        Button assistantVocalButton = new Button("Ouvrir l'Assistant Vocal");
        assistantVocalButton.setOnAction(e -> {
            // Créer une nouvelle fenêtre pour l'assistant vocal
            Stage assistantStage = new Stage();
            assistantStage.setTitle("Assistant Vocal");

            // Créer la scène de l'assistant vocal
            AssistantVocalScene assistantVocalScene = new AssistantVocalScene();
            Scene scene = assistantVocalScene.createScene();

            // Afficher la scène
            assistantStage.setScene(scene);
            assistantStage.show();
        });

        // Layout de l'interface principale
        VBox layout = new VBox(10);
        layout.getChildren().add(assistantVocalButton);

        // Scene principale
        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}