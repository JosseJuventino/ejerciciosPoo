import java.util.InputMismatchException;
import java.util.Scanner;

public class GestionEstacionamiento {
    static int plazasDisponibles = 50;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();

            try {
                opcion = sc.nextInt();

                switch (opcion) {
                    case 1:
                        mostrarDisponibles();
                        break;
                    case 2:
                        reservarPlaza(sc);
                        break;
                    case 3:
                        liberarPlaza(sc);
                        break;
                    case 4:
                        System.out.println("\nSistema cerrado.");
                        break;
                    default:
                        System.out.println("Opción inválida. Intente nuevamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número válido.");
                sc.nextLine();
                opcion = 0;
            }

        } while (opcion != 4);
        sc.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Gestión de Estacionamiento ---");
        System.out.println("1. Ver plazas disponibles");
        System.out.println("2. Reservar plazas");
        System.out.println("3. Liberar plazas");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void mostrarDisponibles() {
        System.out.println("\nPlazas disponibles: " + plazasDisponibles);
    }

    private static void reservarPlaza(Scanner sc) {
        System.out.print("\nCantidad de plazas a reservar: ");
        try {
            int cantidad = sc.nextInt();
            if (cantidad > 0) {
                if (cantidad <= plazasDisponibles) {
                    plazasDisponibles -= cantidad;
                    System.out.println("Reserva exitosa!");
                } else {
                    System.out.println("Error: No hay suficientes plazas disponibles.");
                }
            } else {
                System.out.println("Error: La cantidad debe ser positiva.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Ingrese un número válido.");
            sc.nextLine();
        }
    }

    private static void liberarPlaza(Scanner sc) {
        System.out.print("\nCantidad de plazas a liberar: ");
        try {
            int cantidad = sc.nextInt();
            if (cantidad > 0) {
                plazasDisponibles += cantidad;
                System.out.println("Plazas liberadas correctamente!");
            } else {
                System.out.println("Error: La cantidad debe ser positiva.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Ingrese un número válido.");
            sc.nextLine();
        }
    }
}