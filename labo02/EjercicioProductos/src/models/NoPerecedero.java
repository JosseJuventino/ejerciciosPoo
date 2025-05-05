package models;

public class NoPerecedero extends Producto implements Descontable {
    private String material;
    private int mesesGarantia;

    public NoPerecedero(String nombre, double precio, int stock, String material, int mesesGarantia) {
        super(nombre, precio, stock);
        this.material = material;
        this.mesesGarantia = mesesGarantia;
    }

    @Override
    public int vender() {
        if (stock <= 0) {
            System.out.printf("Sin stock de %s%n", nombre);
            return -1;
        }

        stock--;
        ventasRegistradas++;
        System.out.printf(
                "Vendido %s | Quedan %d uds. | Ventas totales: %d | Garantía: %d meses%n",
                nombre, stock, ventasRegistradas, mesesGarantia
        );
        return ventasRegistradas;
    }

    @Override
    public void aplicarDescuento(double porcentaje) {
        double original = precio;
        precio = precio * (1 - porcentaje / 100);
        System.out.printf(
                "No perecedero: %s | Precio original: %.2f | Descuento: %.1f%% | Nuevo precio: %.2f%n",
                nombre, original, porcentaje, precio
        );
    }

    public String getMaterial() { return material; }
    public int getMesesGarantia() { return mesesGarantia; }
}

