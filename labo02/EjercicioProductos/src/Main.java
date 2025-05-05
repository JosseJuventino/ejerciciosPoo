import models.NoPerecedero;
import models.Perecedero;

public class Main {
    public static void main(String[] args) {
        Perecedero queso = new Perecedero("Queso Fresco", 3.50, 5, 3);
        NoPerecedero taza = new NoPerecedero("Taza Cerámica", 5.00, 3, "Cerámica", 24);

        queso.vender(); // ciclos restantes 2
        queso.vender(); // ciclos restantes 1
        queso.vender(); // ciclos restantes 0
        queso.vender(); // ya caducado

        taza.vender();
        taza.vender();

        queso.aplicarDescuento(10);
        taza.aplicarDescuento(20);

    }
}