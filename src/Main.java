import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1, num2, num3;

        // Solicitar al usuario ingresar 3 números enteros distintos
        do {
            try {
                System.out.println("Ingrese el primer número entero:");
                num1 = scanner.nextInt();

                System.out.println("Ingrese el segundo número entero:");
                num2 = scanner.nextInt();

                System.out.println("Ingrese el tercer número entero:");
                num3 = scanner.nextInt();

                // Validar que los números sean distintos
                if (num1 == num2 || num1 == num3 || num2 == num3) {
                    throw new InputMismatchException("Los números deben ser distintos entre sí.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar obligatoriamente números enteros distintos para realizar la acción.");
                scanner.nextLine(); // Limpiar el buffer del scanner
                num1 = num2 = num3 = 0; // Restablecer valores para volver a solicitar números
            }
        } while (num1 == num2 || num1 == num3 || num2 == num3);

        // Calcular la suma de los dos números más pequeños
        int sumaMenores = sumarMasPequenos(num1, num2, num3);
        System.out.println("La suma de los dos números más pequeños es: " + sumaMenores);

        // Calcular la diferencia de los dos números más grandes
        int diferenciaMayores = restarMasGrandes(num1, num2, num3);
        System.out.println("La diferencia de los dos números más grandes es: " + diferenciaMayores);

        // Determinar el mayor entre los 3 números
        int mayor = obtenerMayor(num1, num2, num3);
        System.out.println("El número mayor es: " + mayor);
    }

    // Método para calcular la suma de los dos números más pequeños
    public static int sumarMasPequenos(int num1, int num2, int num3) {
        int min1 = Math.min(Math.min(num1, num2), num3);
        int min2 = (num1 + num2 + num3) - min1 - Math.max(Math.max(num1, num2), num3);
        return min1 + min2;
    }

    // Método para calcular la diferencia de los dos números más grandes
    public static int restarMasGrandes(int num1, int num2, int num3) {
        int max1 = Math.max(Math.max(num1, num2), num3);
        int max2 = (num1 + num2 + num3) - max1 - Math.min(Math.min(num1, num2), num3);
        return max1 - max2;
    }

    // Método para obtener el número mayor entre 3 enteros
    public static int obtenerMayor(int num1, int num2, int num3) {
        if (num1 == num2 && num2 == num3) {
            return num1;
        } else if (num1 >= num2 && num1 >= num3) {
            return num1;
        } else if (num2 >= num1 && num2 >= num3) {
            return num2;
        } else {
            return num3;
        }
    }
}