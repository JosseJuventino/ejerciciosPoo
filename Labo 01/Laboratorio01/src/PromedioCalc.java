import java.util.Scanner;

public class PromedioCalc {
    public static void main(String[] args) {
        double[] notas = new double[5];

        try(Scanner entrada = new Scanner(System.in)) {
            // Pedir las notas
            for (int i = 0; i < notas.length; i++) {
                System.out.print("Ingrese la nota " + (i + 1) + ": ");
                notas[i] = entrada.nextDouble();
            }
        }

        double promedio = calcularPromedio(notas);
        double maximo = obtenerMaxima(notas);
        double minimo = obtenerMinima(notas);

        System.out.println("Promedio: " + promedio);
        System.out.println("Máximo: " + maximo);
        System.out.println("Minimo: " + minimo);
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
