import java.util.InputMismatchException;
import java.util.Scanner;

public class Tamagotchi {
    static int hambre = 50;
    static int felicidad = 50;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        boolean escape = false;

        System.out.println("¡Nueva mascota virtual creada!");

        do {
            mostrarMenu();
            opcion = sc.nextInt();

            try {

                switch(opcion) {
                    case 1:
                        verEstado();
                        break;
                    case 2:
                        alimentar();
                        break;
                    case 3:
                        jugar();
                        break;
                    case 4:
                        System.out.println("¡Adiós!");
                        break;
                    default:
                        System.out.println("Opción no válida");
                }

                hambre += 10;
                felicidad -= 10;

                // Verificar condiciones de escape
                if(hambre >= 100) {
                    System.out.println("¡La mascota se escapó por hambre!");
                    escape = true;
                }
                if(felicidad <= 0) {
                    System.out.println("¡La mascota se escapó por tristeza!");
                    escape = true;
                }

            } catch (InputMismatchException e) {
                System.out.println("Error: Ingresa un número");
                sc.nextLine();
            }

        } while(!escape && opcion != 4);
        sc.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Menú Mascota ---");
        System.out.println("1. Ver estado");
        System.out.println("2. Alimentar");
        System.out.println("3. Jugar");
        System.out.println("4. Salir");
        System.out.print("Elige: ");
    }

    private static void verEstado() {
        System.out.println("\nHambre: " + hambre);
        System.out.println("Felicidad: " + felicidad);
    }

    private static void alimentar() {
        hambre -= 30;
        if(hambre < 0) hambre = 0;
        System.out.println("¡Mascota alimentada! (-30 hambre)");
    }

    private static void jugar() {
        felicidad += 20;
        if(felicidad > 100) felicidad = 100;
        System.out.println("¡Mascota jugó! (+20 felicidad)");
    }
}