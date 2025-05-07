import models.Descargable;
import models.Formato;
import models.MP3;
import models.Mp4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Formato> archivos = new ArrayList<>();

        System.out.print("¿Cuántos archivos desea agregar? ");
        int cantidad = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < cantidad; i++) {
            System.out.println("\nArchivo #" + (i + 1));
            System.out.print("Tipo (1 = MP3, 2 = MP4): ");
            int tipo = Integer.parseInt(sc.nextLine());

            System.out.print("Nombre del archivo: ");
            String nombre = sc.nextLine();

            System.out.print("Tamaño en MB: ");
            double tamaño = Double.parseDouble(sc.nextLine());

            if (tipo == 1) {
                System.out.print("Bitrate en Kbps: ");
                int bitrate = Integer.parseInt(sc.nextLine());
                archivos.add(new MP3(nombre, tamaño, bitrate));
            } else if (tipo == 2) {
                System.out.print("Resolución (ej. 1920x1080): ");
                String resolucion = sc.nextLine();
                archivos.add(new Mp4(nombre, tamaño, resolucion));
            } else {
                System.out.println("Tipo no válido. Se omite este archivo.");
            }
        }

        System.out.println("\n📂 Reproduciendo todos los archivos:");
        for (Formato archivo : archivos) {
            archivo.reproducir();
        }

        System.out.println("\n📥 Descargando archivos:");
        for (Formato archivo : archivos) {
            if (archivo instanceof Descargable descargable) {
                descargable.descargar();
            }
        }

        sc.close();
    }
}