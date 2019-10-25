import java.util.Arrays;

public class Sintaxis1 {

    public static void main(String[] args) {
        // 1
        int inicio = 4, fin = 9;
        
        // 2
        int suma = 0;
        for (int i = inicio; i <= fin; i++) {
            suma += i;
        }
        System.out.println("2.- El total es: " + suma);
        
        // 3
        suma = 0;
        for (int i = inicio; i <= fin; i++) {
            if(esPar(i)) {
                suma += i;
            }
        }
        System.out.println("3.- El total es: " + suma);
        
        // 4
        suma = 0;
        int divisor = 3;
        for (int i = inicio; i <= fin; i++) {
            if(esMultiploDe(i, divisor)) {
                suma += i;
            }
        }
        System.out.println("4.- El total es: " + suma);
        
        // 5
        int tamano = 10;
        int[] misNumeros = new int[tamano];
        rellenarDeEnteros(misNumeros);
        
        // 6
        System.out.println("6.- " + Arrays.toString(misNumeros));
        
        // 7 usando un while
        rellenarDeEnteros(misNumeros, inicio);
        System.out.println("7.- " + Arrays.toString(misNumeros));
        
        // 8
        int cuenta = 0;
        for (int i = 0; i < misNumeros.length; i++) {
            if(esMultiploDe(misNumeros[i], divisor)) {
                cuenta++;
            }
        }
        System.out.println(String.format("8.- Hay %s múltiplos de %s entre %s y %s",
                cuenta, divisor, misNumeros[0], misNumeros[misNumeros.length - 1]));
        
        // 9
        cuenta = 0;
        String numerosQueCumplen = "";
        for (int i = 0; i < misNumeros.length; i++) {
            if(!esMultiploDe(misNumeros[i], divisor) && esPar(i + 1) ) {
                cuenta++;
                numerosQueCumplen += misNumeros[i] + ", ";
            }
        }
        System.out.println(String.format("9.- Hay %s NO múltiplos de %s en \"posición par\"\n\tentre %s y %s",
                cuenta, divisor, misNumeros[0], misNumeros[misNumeros.length - 1]));
        
        // 10
        System.out.println("10.- \\ En nuestro ejemplo son " + numerosQueCumplen + "\\");
    }

    private static boolean esPar(int numero) {
        return numero % 2 == 0;// Se puede llamar a esMultiploDe(numero, 2) tambien
    }
    
    private static boolean esMultiploDe(int numero, int divisor) {
        return numero % divisor == 0;
    }

    private static void rellenarDeEnteros(int[] array, int desde) {
        int entero = desde;
        int i = 0;
        while(i < array.length) {
            array[i++] = entero++;
        }
    }
    
    private static void rellenarDeEnteros(int[] array) {
        rellenarDeEnteros(array, 1);
    }
    
}
