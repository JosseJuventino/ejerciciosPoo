package com.german.labo4.videojuego;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class VideojuegoController implements Initializable {

    @FXML private TilePane cardsPane;
    @FXML private Button addButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Videojuego ejemplo = new Videojuego(
                "The Legend of Zelda",
                "Aventura",
                "Nintendo Switch",
                "https://www.nintendo.com/eu/media/images/10_share_images/games_15/nintendo_3ds_25/SI_3DS_TheLegendofZeldaOcarinaofTime3D_image1600w.jpg"
        );
        cardsPane.getChildren().add(createCard(ejemplo));

        addButton.setOnAction(e -> openAddDialog());
    }

    private void openAddDialog() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("add-videojuego-dialog.fxml")
            );
            VBox root = loader.load();

            AddVideojuegoDialogController dialogCtrl = loader.getController();
            dialogCtrl.setOnAdd(vj -> cardsPane.getChildren().add(createCard(vj)));

            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.APPLICATION_MODAL);
            dialogStage.setTitle("Agregar Videojuego");
            dialogStage.setScene(new Scene(root));
            dialogStage.showAndWait();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private VBox createCard(Videojuego vj) {
        VBox card = new VBox(10);
        card.setPrefWidth(180);
        card.setAlignment(Pos.TOP_LEFT);
        card.setPadding(new Insets(10));
        card.setStyle(
                "-fx-border-color: lightgray; " +
                        "-fx-border-width: 1; " +
                        "-fx-border-radius: 5; " +
                        "-fx-background-radius: 5; " +
                        "-fx-background-color: white;"
        );

        ImageView iv = new ImageView();
        iv.setFitWidth(200);
        iv.setFitHeight(150);
        iv.setPreserveRatio(true);
        if (vj.getImageURL() != null && !vj.getImageURL().isBlank()) {
            iv.setImage(new Image(vj.getImageURL(), true));
        }

        Label nombreLabel = new Label("Nombre: " + vj.getNombre());
        Label generoLabel = new Label("Género: " + vj.getGenero());
        Label plataformaLabel = new Label("Plataforma: " + vj.getPlataforma());
        Label descripcion = new Label("Descripción: " + vj.getDescripcion());
        descripcion.setWrapText(true);
        descripcion.setMaxWidth(card.getPrefWidth() - 20);

        card.getChildren().addAll(iv, nombreLabel, generoLabel, plataformaLabel, descripcion);
        return card;
    }
}
