
import java.util.ArrayList;

public class Error {
    public static double calcularMSE(ArrayList<DataSet> datos) {
        double mse = 0;
        double error1 = 0;
        int n = datos.size();
        double sumaY = MatDis.SumaY(datos);
        double promedioY = sumaY / n;
        double sst = 0; // Suma total de cuadrados
          // Calcular SST
          for (DataSet data : datos) {
            sst += (data.getY() - promedioY) * (data.getY() - promedioY);
        }
        // Para cada punto (x, y real), calcular y predicho usando las betas
        for (DataSet data : datos) {
            double yReal = data.getY();
            double yPredicho = Lineal.b0 + Lineal.b1 * data.getX();
            mse += (yReal - yPredicho) * (yReal - yPredicho);
        }
        error1= mse/n;
        double sse = mse; // Suma de cuadrados de los errores
        double r2 = 1 - (sse / sst); // Calcular R^2
        System.out.println("El error medio es: " + error1);
        System.out.println("El coeficiente de determinación R^2 es: " + r2);

        return r2;
    }

    public static double CalcularMSECuadratico(ArrayList<DataSet> datos) {
        double mse = 0;
        double error1 = 0;
        int n = datos.size();
        double sumaY = MatDis.SumaY(datos);
        double promedioY = sumaY / n;
        double sst = 0; // Suma total de cuadrados

        // Calcular SST
        for (DataSet data : datos) {
            sst += (data.getY() - promedioY) * (data.getY() - promedioY);
        }

        // Para cada punto (x, y real), calcular y predicho usando los coeficientes de la regresión cuadrática
        for (DataSet data : datos) {
            double yReal = data.getY();
            double yPredicho = Cuadratica.b0 + Cuadratica.b1 * data.getX() + Cuadratica.b2 * Math.pow(data.getX(), 2);
            mse += (yReal - yPredicho) * (yReal - yPredicho);
        }

        error1 = mse / n;
        double sse = mse; // Suma de cuadrados de los errores
        double r2 = 1 - (sse / sst); // Calcular R^2

        System.out.println("El error medio cuadrático es: " + error1);
        System.out.println("El coeficiente de determinación R^2 cuadrático es: " + r2);
        return r2;
    }

    public static double ErrorMSEPolinomial(ArrayList<DataSet> datos) {
        double mse = 0;
        double error1 = 0;
        int n = datos.size();
        double sumaY = MatDis.SumaY(datos);
        double promedioY = sumaY / n;
        double sst = 0; // Suma total de cuadrados
    
        // Calcular SST
        for (DataSet data : datos) {
            sst += (data.getY() - promedioY) * (data.getY() - promedioY);
        }
    
        // Para cada punto (x, y real), calcular y predicho usando las betas de la clase Polinomial
        for (DataSet data : datos) {
            double yReal = data.getY();
            double yPredicho = 0;
    
            // Usar las betas de la clase Polinomial para predecir
            for (int i = 0; i < Polinomial.betas.length; i++) {
                yPredicho += Polinomial.betas[i] * Math.pow(data.getX(), i);
            }
    
            mse += (yReal - yPredicho) * (yReal - yPredicho);
        }
    
        error1 = mse / n;
        double sse = mse; // Suma de cuadrados de los errores
        double r2 = 1 - (sse / sst); // Calcular R^2
    
        System.out.println("El error medio cuadrático polinomial es: " + error1);
        System.out.println("El coeficiente de determinación R^2 polinomial es: " + r2);
        return r2;
    }

}
