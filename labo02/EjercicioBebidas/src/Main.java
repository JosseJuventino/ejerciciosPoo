import models.Cafe;
import models.Te;

public class Main {
    public static void main(String[] args) {
        Cafe miCafe = new Cafe("Café Exquisito", 200, 2.50, 4, "oscuro");
        Te miTe = new Te("Té Verde Premium", 150, 1.80, "verde", "80°C");

        miCafe.servir();
        miCafe.servir();
        miTe.servir();

        miCafe.valorar(5);
        miTe.valorar(4);
    }
}