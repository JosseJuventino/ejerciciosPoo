package com.german.labo4.videojuego;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddVideojuegoDialogController {

    @FXML private TextField nombreField;
    @FXML private TextField generoField;
    @FXML private TextField plataformaField;
    @FXML private TextField imageURLField;
    @FXML private Button addBtn;
    @FXML private Label errorLabel;

    private java.util.function.Consumer<Videojuego> onAdd;

    public void setOnAdd(java.util.function.Consumer<Videojuego> onAdd) {
        this.onAdd = onAdd;
    }

    @FXML
    private void initialize() {
        addBtn.setOnAction(e -> {
            String nombre = nombreField.getText().trim();
            String genero = generoField.getText().trim();
            String plataforma = plataformaField.getText().trim();
            String imageUrl = imageURLField.getText().trim();
            if (nombre.isEmpty() || genero.isEmpty() || plataforma.isEmpty()) {
                errorLabel.setText("Todos los campos excepto URL son obligatorios.");
                return;
            }
            Videojuego vj = new Videojuego(nombre, genero, plataforma, imageUrl);
            if (onAdd != null) onAdd.accept(vj);
            Stage stage = (Stage) addBtn.getScene().getWindow();
            stage.close();
        });
    }
}