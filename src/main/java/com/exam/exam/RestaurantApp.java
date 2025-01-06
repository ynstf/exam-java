package com.exam.exam;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class RestaurantApp extends Application {

    private double totalPrice = 0.0; // Total price of the meal
    private Label totalLabel; // Label to display the total price

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Restaurant Application");

        // Main layout
        BorderPane mainLayout = new BorderPane();
        mainLayout.setPadding(new Insets(10));

        // Step 1: Meal Selection Interface
        VBox mealSelectionLayout = createMealSelectionLayout();
        mainLayout.setCenter(mealSelectionLayout);

        // Scene
        Scene scene = new Scene(mainLayout, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Step 1: Meal Selection Interface
     */
    private VBox createMealSelectionLayout() {
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));

        // Label
        Label mealLabel = new Label("Sélectionnez un repas :");

        // ComboBox for meal selection
        ObservableList<String> meals = FXCollections.observableArrayList(
                "Tajine de viande & Pruneaux - €15.00",
                "Tajine de poulet & légumes - €12.00",
                "Pâtes Carbonara - €10.00"
        );
        ComboBox<String> mealComboBox = new ComboBox<>(meals);

        // Next Button
        Button nextButton = new Button("Suivant");
        nextButton.setOnAction(e -> {
            String selectedMeal = mealComboBox.getValue();
            if (selectedMeal != null) {
                // Extract the base price from the selected meal
                double basePrice = Double.parseDouble(selectedMeal.split("€")[1]);
                totalPrice = basePrice; // Reset total price
                totalLabel.setText("Total: €" + totalPrice);

                // Move to the customization interface
                VBox customizationLayout = createCustomizationLayout();
                ((BorderPane) mealComboBox.getScene().getRoot()).setCenter(customizationLayout);
            } else {
                showAlert("Veuillez sélectionner un repas.");
            }
        });

        // Total Price Label
        totalLabel = new Label("Total: €0.00");

        // Add components to layout
        layout.getChildren().addAll(mealLabel, mealComboBox, nextButton, totalLabel);

        return layout;
    }

    /**
     * Step 2: Ingredient and Supplement Customization Interface
     */
    private VBox createCustomizationLayout() {
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));

        // Ingredients Section
        Label ingredientLabel = new Label("Ingrédients :");
        CheckBox cheeseCheckBox = new CheckBox("Fromage (+€1.50)");
        CheckBox tomatoCheckBox = new CheckBox("Tomate (+€0.50)");
        CheckBox onionCheckBox = new CheckBox("Oignon (+€0.75)");

        // Supplements Section
        Label supplementLabel = new Label("Suppléments :");
        CheckBox friesCheckBox = new CheckBox("Frites (+€3.00)");
        CheckBox drinkCheckBox = new CheckBox("Boisson (+€2.00)");

        // Add event listeners to update the total price
        cheeseCheckBox.setOnAction(e -> updateTotal(cheeseCheckBox, 1.50));
        tomatoCheckBox.setOnAction(e -> updateTotal(tomatoCheckBox, 0.50));
        onionCheckBox.setOnAction(e -> updateTotal(onionCheckBox, 0.75));
        friesCheckBox.setOnAction(e -> updateTotal(friesCheckBox, 3.00));
        drinkCheckBox.setOnAction(e -> updateTotal(drinkCheckBox, 2.00));

        // Finish Button
        Button finishButton = new Button("Terminer");
        finishButton.setOnAction(e -> {
            // Display the ticket
            showTicket();
        });

        // Add components to layout
        layout.getChildren().addAll(ingredientLabel, cheeseCheckBox, tomatoCheckBox, onionCheckBox,
                supplementLabel, friesCheckBox, drinkCheckBox, finishButton, totalLabel);

        return layout;
    }

    /**
     * Update the total price based on ingredient/supplement selection
     */
    private void updateTotal(CheckBox checkBox, double price) {
        if (checkBox.isSelected()) {
            totalPrice += price;
        } else {
            totalPrice -= price;
        }
        totalLabel.setText("Total: €" + String.format("%.2f", totalPrice));
    }

    /**
     * Step 4: Display the ticket
     */
//    private void showTicket() {
//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("Ticket de commande");
//        alert.setHeaderText("Votre ticket :");
//        alert.setContentText("Total: €" + String.format("%.2f", totalPrice));
//        alert.showAndWait();
//    }
    private void showTicket() {
        // Données du ticket (à remplacer par les données réelles de la commande)
        String clientName = "Ali baba";
        int numberOfMeals = 2;
        String meal1 = "Tajine de viande & Pruneaux";
        String meal1Ingredients = "Viande: 250 gramme\nPruneaux: 100 gramme";
        String meal1Supplements = "11.0\n12.0";
        String meal2 = "Tajine de poulet & légumes";
        String meal2Ingredients = "Poisson: 250 gramme\nCarotte: 100 gramme\nPomme de terre: 100 gramme\nOlive: 50 gramme";
        String meal2Supplements = "13.0\n14.0";
        double total = 22.75;

        // Construction du ticket
        StringBuilder ticket = new StringBuilder();
        ticket.append("**************************************\n");
        ticket.append("          TICKET DE COMMANDE          \n");
        ticket.append("**************************************\n");
        ticket.append("Bienvenue ").append(clientName).append("\n");
        ticket.append("TICKET\n");
        ticket.append("Nom: ").append(clientName).append("\n");
        ticket.append("Nombre de repas: ").append(numberOfMeals).append("\n");
        ticket.append("Repas N°1: ").append(meal1).append("\n");
        ticket.append("Ingrédients:\n").append(meal1Ingredients).append("\n");
        ticket.append("Suppléments:\n").append(meal1Supplements).append("\n");
        ticket.append("Repas N°2: ").append(meal2).append("\n");
        ticket.append("Ingrédients:\n").append(meal2Ingredients).append("\n");
        ticket.append("Suppléments:\n").append(meal2Supplements).append("\n");
        ticket.append("Total: ").append(total).append("\n");

        // Affichage du ticket dans une boîte de dialogue
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ticket de Commande");
        alert.setHeaderText(null);
        alert.setContentText(ticket.toString());
        alert.showAndWait();
    }

    /**
     * Show an alert message
     */
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Attention");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}