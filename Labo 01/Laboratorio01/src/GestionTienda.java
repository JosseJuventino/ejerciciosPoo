import java.util.InputMismatchException;
import java.util.Scanner;

public class GestionTienda {
    static int stock = 100;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        boolean salir = false;

        do {
            mostrarMenu();

            try {
                opcion = sc.nextInt();

                switch(opcion) {
                    case 1:
                        verStock();
                        break;
                    case 2:
                        vender(sc);
                        break;
                    case 3:
                        reponer(sc);
                        break;
                    case 4:
                        System.out.println("¡Hasta luego!");
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no válida");
                }

            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese solo números");
                sc.nextLine();
            }

        } while(!salir);
        sc.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n=== Gestión Tienda ===");
        System.out.println("1. Ver stock");
        System.out.println("2. Vender");
        System.out.println("3. Reponer");
        System.out.println("4. Salir");
        System.out.print("Elección: ");
    }

    private static void verStock() {
        System.out.println("\nUnidades disponibles: " + stock);
    }

    private static void vender(Scanner sc) {
        System.out.print("Cantidad a vender: ");
        try {
            int cantidad = sc.nextInt();

            if(cantidad < 0) {
                System.out.println("Error: Valor negativo");
                return;
            }

            if(cantidad <= stock) {
                stock -= cantidad;
                System.out.println("Venta realizada");
            } else {
                System.out.println("Error: Stock insuficiente");
            }

        } catch (InputMismatchException e) {
            System.out.println("Error: Ingrese un número válido");
            sc.nextLine();
        }
    }

    private static void reponer(Scanner sc) {
        System.out.print("Cantidad a reponer: ");
        try {
            int cantidad = sc.nextInt();

            if(cantidad < 0) {
                System.out.println("Error: Valor negativo");
                return;
            }

            stock += cantidad;
            System.out.println("Reposición exitosa");

        } catch (InputMismatchException e) {
            System.out.println("Error: Ingrese un número válido");
            sc.nextLine();
        }
    }
}