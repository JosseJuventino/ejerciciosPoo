import java.util.Scanner;

public class PromedioCalc {
    public static void main(String[] args) {
        double[] notas = new double[5];

        try (Scanner scanner = new Scanner(System.in)) {
            for (int i = 0; i < notas.length; i++) {
                while (true) {
                    System.out.print("Ingrese nota " + (i+1) + " (0-10): ");
                    String entrada = scanner.nextLine().replace(',', '.');

                    try {
                        double nota = Double.parseDouble(entrada);
                        if (nota >= 0 && nota <= 10) {
                            notas[i] = nota;
                            break;
                        } else {
                            System.out.println("⚠️ La nota debe estar entre 0 y 10");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("❌ Entrada inválida. Introduce un número.");
                    }
                }
            }
        }

        double promedio = calcularPromedio(notas);
        double maxima = obtenerMaxima(notas);
        double minima = obtenerMinima(notas);
        String resultado = (promedio >= 6.0) ? "Aprobado" : "Reprobado";

        System.out.printf("Promedio: %.2f\n", promedio);
        System.out.printf("Nota más alta: %.2f\n", maxima);
        System.out.printf("Nota más baja: %.2f\n", minima);
        System.out.println("Estado: " + resultado);
    }

    private static double calcularPromedio(double[] notas) {
        double suma = 0;
        for (double nota : notas) {
            suma += nota;
        }
        return suma / notas.length;
    }

    private static double obtenerMaxima(double[] notas) {
        double max = notas[0];
        for (int i = 1; i < notas.length; i++) {
            if (notas[i] > max) max = notas[i];
        }
        return max;
    }

    private static double obtenerMinima(double[] notas) {
        double min = notas[0];
        for (int i = 1; i < notas.length; i++) {
            if (notas[i] < min) min = notas[i];
        }
        return min;
    }
}