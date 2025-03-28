import java.util.Scanner;

public class ConversorTiempo {
    private static final int MINUTOS_POR_HORA = 60;
    private static final int HORAS_POR_DIA = 24;
    private static final int SEGUNDOS_POR_MINUTO = 60;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int opcion;
            do {
                mostrarMenu();
                opcion = scanner.nextInt();
                switch (opcion) {
                    case 1:
                        convertirMinutosSegundos(scanner);
                        break;
                    case 2:
                        convertirHorasAMinutos(scanner);
                        break;
                    case 3:
                        convertirDias(scanner);
                        break;
                    case 4:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("⚠️ Opción no válida");
                }
            }while (opcion != 4);

        } catch (Exception e) {
            System.out.println("Error: Entrada inválida. Asegúrese de ingresar un número entero.");
        }
    }

    private static void mostrarMenu() {
        System.out.println("Seleccione el tipo de conversión:");
        System.out.println("1. Minutos a segundos");
        System.out.println("2. Horas a minutos");
        System.out.println("3. Días a horas");
        System.out.println("4. Salir");
    }

    private static void convertirMinutosSegundos(Scanner scanner) {
        System.out.print("Ingrese el tiempo en minutos: ");
        int minutos = scanner.nextInt();

        if (minutos < 0) {
            System.out.println("⚠️ El tiempo no puede ser negativo.");
            return;
        }

        int segundos = minutos * SEGUNDOS_POR_MINUTO;

        System.out.println(minutos + " minutos equivalen a: " + segundos + " segundos");
    }

    private static void convertirHorasAMinutos(Scanner scanner) {
        System.out.print("Ingrese el tiempo en horas: ");
        int horas = scanner.nextInt();

        if (horas < 0) {
            System.out.println("⚠️ El tiempo no puede ser negativo.");
            return;
        }

        int minutos = horas * MINUTOS_POR_HORA;
        System.out.println(horas + " horas equivalen a " + minutos + " minutos");
    }

    private static void convertirDias(Scanner scanner) {
        System.out.print("Ingrese el tiempo en días: ");
        int dias = scanner.nextInt();

        if (dias < 0) {
            System.out.println("⚠️ El tiempo no puede ser negativo.");
            return;
        }

        int horas = dias * HORAS_POR_DIA;
        System.out.println(dias + " dias equivalen a " + horas  + " horas");
    }
}