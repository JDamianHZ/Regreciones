import java.util.ArrayList;

public class Polinomial {

    public static  double[] betas; // Array para almacenar los coeficientes de la regresión

    public static double[][] generarMatriz(ArrayList<DataSet> datos, int grado) {
        int n = grado + 1;
        double[][] matriz = new double[n][n + 1]; // Matriz aumentada para sistema de ecuaciones

        // Crear las sumas necesarias para la matriz
        double[] sumasX = new double[2 * grado + 1];
        double[] sumasXY = new double[grado + 1];

        // Llenar las sumas de potencias de X y los productos X * Y
        for (DataSet data : datos) {
            double x = data.getX();
            double y = data.getY();
            
            for (int i = 0; i <= 2 * grado; i++) {
                sumasX[i] += Math.pow(x, i); // Sumatorias de potencias de X
            }

            for (int i = 0; i <= grado; i++) {
                sumasXY[i] += Math.pow(x, i) * y; // Sumatorias de X^i * Y
            }
        }

        // Llenar la matriz aumentada
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = sumasX[i + j]; // Valores de sumatorias de potencias de X
            }
            matriz[i][n] = sumasXY[i]; // Lado derecho de la matriz aumentada con X^i * Y
        }
        return matriz; // Devolver la matriz generada
    }

    // Método para imprimir la matriz
    public static void imprimirMatriz(double[][] matriz) {
        for (double[] fila : matriz) {
            for (double valor : fila) {
                System.out.printf("%10.2f ", valor);
            }
            System.out.println();
        }
    }

    public static void GaussJordan(double[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;
    
            betas = new double[filas]; // Asegúrate de que betas está definido aquí
    
        for (int i = 0; i < filas; i++) {
            // Hacer que el pivote sea 1
            double pivote = matriz[i][i];
            
            if (pivote == 0) {
                throw new IllegalArgumentException("El pivote no puede ser cero.");
            }
            
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] /= pivote;
            }
    
            // Hacer que los otros elementos en la columna sean 0
            for (int k = 0; k < filas; k++) {
                if (k != i) {
                    double factor = matriz[k][i];
                    for (int j = 0; j < columnas; j++) {
                        matriz[k][j] -= factor * matriz[i][j];
                    }
                }
            }
        }
    
        // Asignar los resultados a los coeficientes
        for (int i = 0; i < filas; i++) {
            betas[i] = matriz[i][columnas - 1]; // Usar el parámetro matriz
        }
    
        System.out.println("Coeficientes:");
        for (int i = 0; i < betas.length; i++) {
            System.out.printf("b%d = %.4f%n", i, betas[i]);
    }

    }

    //Predicciones
    public static void predecir(double[] xpredicciones){
        //for mejorado que se repita hasta terminar xpredicciones
        for (double x: xpredicciones){
            double yPredicho = 0;
            for (int i = 0; i < betas.length; i++) {
                yPredicho += betas[i] * Math.pow(x, i);
            }
            System.out.println("Predicción para x = " + x + ": y = " + yPredicho);
        }
    }


}
