package org.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    
    // Model class to represent a celestial body
    public static class CuerpoCeleste {
        private String nombre;
        private String tipo;
        private double diametro;
        private double masa;

        public CuerpoCeleste(String nombre, String tipo, double diametro, double masa) {
            this.nombre = nombre;
            this.tipo = tipo;
            this.diametro = diametro;
            this.masa = masa;
        }

        public String getNombre() { return nombre; }
        public void setNombre(String nombre) { this.nombre = nombre; }
        
        public String getTipo() { return tipo; }
        public void setTipo(String tipo) { this.tipo = tipo; }
        
        public double getDiametro() { return diametro; }
        public void setDiametro(double diametro) { this.diametro = diametro; }
        
        public double getMasa() { return masa; }
        public void setMasa(double masa) { this.masa = masa; }
    }

    // Form fields
    @FXML
    private TextField nombreField;
    
    @FXML
    private ComboBox<String> tipoComboBox;
    
    @FXML
    private TextField diametroField;
    
    @FXML
    private TextField masaField;
    
    // Table view
    @FXML
    private TableView<CuerpoCeleste> cuerposCelestesTable;
    
    @FXML
    private TableColumn<CuerpoCeleste, String> nombreColumn;
    
    @FXML
    private TableColumn<CuerpoCeleste, String> tipoColumn;
    
    @FXML
    private TableColumn<CuerpoCeleste, Double> diametroColumn;
    
    @FXML
    private TableColumn<CuerpoCeleste, Double> masaColumn;
    
    // Buttons
    @FXML
    private Button agregarButton;
    
    @FXML
    private Button modificarButton;
    
    @FXML
    private Button eliminarButton;
    
    // Data collection
    private ObservableList<CuerpoCeleste> cuerposCelestes = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Initialize ComboBox items
        tipoComboBox.getItems().addAll("Planeta", "Estrella", "Satélite", "Asteroide", "Cometa");
        
        // Set up table columns
        nombreColumn.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tipoColumn.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        diametroColumn.setCellValueFactory(new PropertyValueFactory<>("diametro"));
        masaColumn.setCellValueFactory(new PropertyValueFactory<>("masa"));
        
        // Connect table to data source
        cuerposCelestesTable.setItems(cuerposCelestes);
        
        // Add some sample data
        cuerposCelestes.add(new CuerpoCeleste("Tierra", "Planeta", 12742, 5.972e24));
        cuerposCelestes.add(new CuerpoCeleste("Luna", "Satélite", 3474, 7.348e22));
        cuerposCelestes.add(new CuerpoCeleste("Sol", "Estrella", 1392700, 1.989e30));
        
        // Set up event handlers
        setupEventHandlers();
    }
    
    private void setupEventHandlers() {
        // Add button event
        agregarButton.setOnAction(event -> {
            try {
                String nombre = nombreField.getText();
                String tipo = tipoComboBox.getValue();
                double diametro = Double.parseDouble(diametroField.getText());
                double masa = Double.parseDouble(masaField.getText());
                
                if (nombre == null || nombre.isEmpty() || tipo == null || tipo.isEmpty()) {
                    showAlert("Datos incompletos", "Por favor ingrese todos los datos requeridos.");
                    return;
                }
                
                CuerpoCeleste nuevoCuerpo = new CuerpoCeleste(nombre, tipo, diametro, masa);
                cuerposCelestes.add(nuevoCuerpo);
                clearForm();
                
            } catch (NumberFormatException e) {
                showAlert("Error de formato", "El diámetro y la masa deben ser valores numéricos.");
            }
        });
        
        // Modify button event
        modificarButton.setOnAction(event -> {
            CuerpoCeleste selected = cuerposCelestesTable.getSelectionModel().getSelectedItem();
            if (selected == null) {
                showAlert("Selección requerida", "Por favor seleccione un cuerpo celeste para modificar.");
                return;
            }
            
            try {
                String nombre = nombreField.getText();
                String tipo = tipoComboBox.getValue();
                double diametro = Double.parseDouble(diametroField.getText());
                double masa = Double.parseDouble(masaField.getText());
                
                if (nombre == null || nombre.isEmpty() || tipo == null || tipo.isEmpty()) {
                    showAlert("Datos incompletos", "Por favor ingrese todos los datos requeridos.");
                    return;
                }
                
                selected.setNombre(nombre);
                selected.setTipo(tipo);
                selected.setDiametro(diametro);
                selected.setMasa(masa);
                
                // Refresh table
                cuerposCelestesTable.refresh();
                clearForm();
                
            } catch (NumberFormatException e) {
                showAlert("Error de formato", "El diámetro y la masa deben ser valores numéricos.");
            }
        });
        
        // Delete button event
        eliminarButton.setOnAction(event -> {
            CuerpoCeleste selected = cuerposCelestesTable.getSelectionModel().getSelectedItem();
            if (selected == null) {
                showAlert("Selección requerida", "Por favor seleccione un cuerpo celeste para eliminar.");
                return;
            }
            
            cuerposCelestes.remove(selected);
            clearForm();
        });
        
        // Table selection event
        cuerposCelestesTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                nombreField.setText(newSelection.getNombre());
                tipoComboBox.setValue(newSelection.getTipo());
                diametroField.setText(String.valueOf(newSelection.getDiametro()));
                masaField.setText(String.valueOf(newSelection.getMasa()));
            }
        });
    }
    
    private void clearForm() {
        nombreField.clear();
        tipoComboBox.getSelectionModel().clearSelection();
        diametroField.clear();
        masaField.clear();
        cuerposCelestesTable.getSelectionModel().clearSelection();
    }
    
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

