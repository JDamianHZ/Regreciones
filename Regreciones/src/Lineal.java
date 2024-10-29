import java.util.ArrayList;

public class Lineal {

    public static double b1, b0;
    public static double[] calcularBetas(ArrayList<DataSet> datos) {

        // Calcular los valores necesarios
        double sumaX = MatDis.SumaX(datos);
        double sumaY = MatDis.SumaY(datos);
        double sumaXY = MatDis.SumaXY(MatDis.MultXY(datos));
        double sumaXcuad = MatDis.SumaXCuad(MatDis.Xcuadrada(datos));
        double n = MatDis.Tamano(datos);

        // Calcular la pendiente (b1)
        b1 = (n * sumaXY - sumaX * sumaY) / (n * sumaXcuad - (sumaX * sumaX));

        // Calcular los promedios de X e Y
        double promedioX = sumaX / n;
        double promedioY = sumaY / n;

        // Calcular el intercepto (b0)
        b0 = promedioY - b1 * promedioX;

        // Mostrar los resultados
        System.out.println("b0 (intercepto): " + b0);
        System.out.println("b1 (pendiente): " + b1);

        return new double[]{b0, b1}; // Devolver los valores de b0 y b1
    }




      //prededir
      public static void predecirRestante(ArrayList<DataSet> datos){
         //for mejorado que se repita hasta terminar xpredicciones
        for (DataSet data: datos){
            double yPredicho = b0 + b1 * data.getX();
            System.out.println("Prediccion para x= "+ data.getX() + ": y = "+ yPredicho);
        }
   
    }


    //prededir
    public static void predecir(double[] xpredicciones){

        //for mejorado que se repita hasta terminar xpredicciones
        for (double x: xpredicciones){
            double yPredicho = b0 + b1 * x;
            System.out.println("Prediccion para x= "+ x + ": y = "+ yPredicho);
        }
    }
}
