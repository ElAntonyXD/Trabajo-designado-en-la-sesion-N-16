import java.util.InputMismatchException;
import java.util.Scanner;
// Se realizan los importes necesarios de la clase Java.Util

public class Main {
    //Nombre: Antony Jostin Përez Parrales          Numero de carnet: 2024-1683U

    public static void main(String[] args) {
        Scanner Leer = new Scanner(System.in);
        int num1, num2, num3;

        // Se le solicita al uysuario ingresar sus 3 numeros enteros
        do {
            try {
                System.out.println("Ingrese el primer número entero:");
                num1 = Leer.nextInt();

                System.out.println("Ingrese el segundo número entero:");
                num2 = Leer.nextInt();

                System.out.println("Ingrese el tercer número entero:");
                num3 = Leer.nextInt();

                // Validar que los números sean distintos
                if (num1 == num2 || num1 == num3 || num2 == num3) {
                    throw new InputMismatchException("Los números deben ser distintos entre sí.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar obligatoriamente números enteros distintos para realizar la acción.");
                Leer.nextLine(); // Limpiar el buffer del scanner
                num1 = num2 = num3 = 0; // Se restablecen los valores de los números a cero para repetir las acciones
            }
        } while (num1 == num2 || num1 == num3 || num2 == num3);

        // Llama al metodo que calcula la suma de los mas pequeños

        int SumaMenores = SumarMasPequeños(num1, num2, num3);
        System.out.println("La suma de los dos números más pequeños es: " + SumaMenores);

        // llama al metodo que calcula la diferencia entre los mas grandes
        int diferenciaMayores = RestarMasGrandes(num1, num2, num3);
        System.out.println("La diferencia de los dos números más grandes es: " + diferenciaMayores);

        // Llama al metodo que determina cual de los 3 es mayor
        int mayor = ObtenerMayor(num1, num2, num3);
        System.out.println("El número mayor es: " + mayor);
        Leer.close();
    }

    // Método para calcular la suma de los dos números más pequeños
    public static int SumarMasPequeños(int num1, int num2, int num3) {
        int min1 = Math.min(Math.min(num1, num2), num3);
        int min2 = (num1 + num2 + num3) - min1 - Math.max(Math.max(num1, num2), num3);
        return min1 + min2;
    }

    // Método para calcular la diferencia de los dos números más grandes
    public static int RestarMasGrandes(int num1, int num2, int num3) {
        int max1 = Math.max(Math.max(num1, num2), num3);
        int max2 = (num1 + num2 + num3) - max1 - Math.min(Math.min(num1, num2), num3);
        return max1 - max2;
    }

    // Método para obtener el número mayor entre 3 enteros
    public static int ObtenerMayor(int num1, int num2, int num3) {
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
// Los metodos Math.min y Math.max se utilizan para calucla el valor mayor o el
// valor menor de dso valores, estos salen o deriban de la clase Math