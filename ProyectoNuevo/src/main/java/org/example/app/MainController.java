package org.example.app;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.factory.CuerpoCelesteFactory;
import org.example.model.CuerpoCeleste;
import org.example.observer.GestorCuerpos;

public class MainController {
    @FXML private TableView<CuerpoCeleste> tablaCuerpos;
    @FXML private TableColumn<CuerpoCeleste, String>  colNombre;
    @FXML private TableColumn<CuerpoCeleste, Number>  colMasa;
    @FXML private TableColumn<CuerpoCeleste, Number>  colRadio;
    @FXML private TableColumn<CuerpoCeleste, String>  colTipo;
    @FXML private Button btnAgregar;
    @FXML private Button btnEliminar;

    private final GestorCuerpos gestor = new GestorCuerpos();
    private final ObservableList<CuerpoCeleste> listaUI = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        colNombre.setCellValueFactory(c ->
                new SimpleStringProperty(c.getValue().getNombre())
        );

        colMasa.setCellValueFactory(c ->
                // SimpleDoubleProperty es ObservableValue<Number>
                new SimpleDoubleProperty(c.getValue().getMasa())
        );

        colRadio.setCellValueFactory(c ->
                new SimpleDoubleProperty(c.getValue().getRadio())
        );

        colTipo.setCellValueFactory(c ->
                new SimpleStringProperty(
                        c.getValue().getClass().getSimpleName()
                )
        );

        // Vincula la lista al TableView
        tablaCuerpos.setItems(listaUI);

        // Maneja el botón Agregar
        btnAgregar.setOnAction(evt -> {
            // Ejemplo muy sencillo: agregamos un planeta Tierra
            CuerpoCeleste nuevo = CuerpoCelesteFactory.crear(
                    "PLANETA", "Tierra", 5.97e24, 6371
            );
            gestor.agregar(nuevo);
            listaUI.add(nuevo);
        });

        // Maneja el botón Eliminar
        btnEliminar.setOnAction(evt -> {
            CuerpoCeleste sel = tablaCuerpos.getSelectionModel().getSelectedItem();
            if (sel != null) {
                tablaCuerpos.getItems().remove(sel);
                // Si tu GestorCuerpos tuviera método eliminar, también lo invocarías:
                // gestor.eliminar(sel);
            }
        });

        // Inicialmente puedes poblar la lista con algún ejemplo
        CuerpoCeleste sol = CuerpoCelesteFactory.crear("ESTRELLA","Sol",1.99e30,696340);
        gestor.agregar(sol);
        listaUI.add(sol);
    }
}

