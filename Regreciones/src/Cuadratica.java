import java.util.ArrayList;

public class Cuadratica {

     
        ArrayList<DataSet> datos = DataSet.Datos();
        public  double[][] matrizInicial;
        public  static  double b0, b1, b2;

        public void HacerMatriz(ArrayList<DataSet> datos) {
        // Calcular los valores necesarios
        double sumaX = MatDis.SumaX(datos);
        double sumaY = MatDis.SumaY(datos);
        double sumaXY = MatDis.SumaXY(MatDis.MultXY(datos));
        double sumaXcuad = MatDis.SumaXCuad(MatDis.Xcuadrada(datos));
        double sumaXcubica = MatDis.SumaXCubica(MatDis.XCubica(datos));
        double sumaXcuarta = MatDis.SumaXCuarta(MatDis.XCuarta(datos));
        double sumaXcuadradaY = MatDis.SumaXCuadradaY(MatDis.XCuadradaY(datos));
        double n = MatDis.Tamano(datos);

                //llenar array de resultados para gauss jordan
                matrizInicial = new double[][]{
                        {sumaXcuad, sumaX, n, sumaY},
                        {sumaXcubica, sumaXcuad, sumaX, sumaXY},
                        {sumaXcuarta, sumaXcubica, sumaXcuad, sumaXcuadradaY}
                };

                System.out.println(n);
        };


        // Calcular la matriz aumentada
        public double[][] getMatrizInicial() {
            return matrizInicial;
                }




        // Método para resolver la matriz usando Gauss-Jordan
        public void resolverMatriz() {
        int filas = matrizInicial.length;
        int columnas = matrizInicial[0].length;

        for (int i = 0; i < filas; i++) {
            // Hacer que el pivote sea 1
            double pivote = matrizInicial[i][i];
            for (int j = 0; j < columnas; j++) {
                matrizInicial[i][j] /= pivote;
            }

            // Hacer que los otros elementos en la columna sean 0
            for (int k = 0; k < filas; k++) {
                if (k != i) {
                    double factor = matrizInicial[k][i];
                    for (int j = 0; j < columnas; j++) {
                        matrizInicial[k][j] -= factor * matrizInicial[i][j];
                    }
                }
            }
        }

        // Asignar los resultados a b0, b1, b2
        b2 = matrizInicial[0][columnas - 1];
        b1 = matrizInicial[1][columnas - 1];
        b0 = matrizInicial[2][columnas - 1];

        // Mostrar los resultados
        System.out.println("Coeficientes:");
        System.out.println("b0 = " + b0);
        System.out.println("b1 = " + b1);
        System.out.println("b2 = " + b2);
    }

      // Mostrar matriz aumentada
      public void mostrarMatrizInicial() {
        for (int i = 0; i < matrizInicial.length; i++) {
            for (int j = 0; j < matrizInicial[i].length; j++) {
                System.out.print(matrizInicial[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Método para predecir valores
    public  void predecirRestante(ArrayList<DataSet> datos){
        //for mejorado que se repita hasta terminar xpredicciones
        for (DataSet data: datos){
            double yPredicho = b0 + b1 * data.getX() + b2 * (data.getX() * data.getX());
            System.out.println("Prediccion para x= "+ data.getX() + ": y = "+ yPredicho);
        }
    }


}
