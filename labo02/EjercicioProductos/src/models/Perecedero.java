package models;

public class Perecedero extends Producto implements Descontable {

    private int ciclosVidaUtil;

    public Perecedero(String nombre, double precio, int stock, int ciclosVidaUtil) {
        super(nombre, precio, stock);
        this.ciclosVidaUtil = ciclosVidaUtil;
    }

    @Override
    public int vender() {
        if (ciclosVidaUtil <= 0) {
            System.out.printf("¡Error! %s ha caducado por superar sus %d ciclos de vida útil.%n",
                    nombre, 0);
            return -1;
        }

        if (stock <= 0) {
            System.out.printf("Sin stock de %s%n", nombre);
            return -1;
        }

        stock--;
        ventasRegistradas++;
        ciclosVidaUtil--;

        System.out.printf(
                "Vendido %s | Quedan %d uds. | Ventas totales: %d | Ciclos restantes: %d%n",
                nombre, stock, ventasRegistradas, ciclosVidaUtil
        );
        return ventasRegistradas;
    }

    @Override
    public void aplicarDescuento(double porcentaje) {
        double original = precio;
        double rebajado = precio * (1 - porcentaje / 100);
        precio = rebajado;
        System.out.printf(
                "Perecedero: %s | Precio original: %.2f | Descuento: %.1f%% | Nuevo precio: %.2f%n",
                nombre, original, porcentaje, rebajado
        );
    }

    public int getCiclosVidaUtil() {
        return ciclosVidaUtil;
    }
}
