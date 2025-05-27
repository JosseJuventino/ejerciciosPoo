module com.german.labo4.videojuego {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.german.labo4.videojuego to javafx.fxml;
    exports com.german.labo4.videojuego;
}