import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CajeroAutomatico {
    static double saldo = 1000.0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();

            try {
                opcion = sc.nextInt();

                switch (opcion) {
                    case 1:
                        mostrarSaldo();
                        break;
                    case 2:
                        realizarDeposito(sc);
                        break;
                    case 3:
                        realizarRetiro(sc);
                        break;
                    case 4:
                        System.out.println("\nGracias por usar nuestro cajero.");
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
        System.out.println("\n--- Cajero Automático ---");
        System.out.println("1. Ver saldo");
        System.out.println("2. Depositar dinero");
        System.out.println("3. Retirar dinero");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void mostrarSaldo() {
        System.out.printf("\nSaldo actual: $%.2f%n", saldo);
    }

    private static void realizarDeposito(Scanner sc) {
        System.out.print("\nIngrese monto a depositar: ");
        try {
            double monto = sc.nextDouble();
            if (monto > 0) {
                saldo += monto;
                System.out.println("¡Depósito exitoso!");
            } else {
                System.out.println("Error: El monto debe ser positivo.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Ingrese un valor numérico válido.");
            sc.nextLine();
        }
    }

    private static void realizarRetiro(Scanner sc) {

        System.out.print("\nIngrese monto a retirar: ");
        try {
            double monto = sc.nextDouble();
            if (monto > 0) {
                if (monto <= saldo) {
                    saldo -= monto;
                    System.out.println("¡Retiro exitoso!");

                } else {
                    System.out.println("Error: Saldo insuficiente.");
                }
            } else {
                System.out.println("Error: El monto debe ser positivo.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Ingrese un valor numérico válido.");
            sc.nextLine();
        }

    }
}