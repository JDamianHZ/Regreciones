import java.util.ArrayList;

public class MatDis {
    Cuadratica Cuadratica = new Cuadratica();
    double[][] MatrizGauus = Cuadratica.getMatrizInicial();


public static ArrayList<Double> MultXY (ArrayList <DataSet> datos){
    ArrayList<Double> resultadoxy = new ArrayList<>();


    for (DataSet data: datos){
        double xy= data.getX() * data.getY();
        resultadoxy.add(xy);

    }
    return resultadoxy;

}

public static ArrayList<Double> Xcuadrada (ArrayList<DataSet> datos){

    ArrayList <Double>  resultadoXcuadrada = new ArrayList<>();

    for (DataSet data: datos){
        double xcuad= data.getX() * data.getX();
        resultadoXcuadrada.add(xcuad);

    }
    return resultadoXcuadrada;

}

    public static ArrayList<Double> XCubica (ArrayList<DataSet> datos){

        ArrayList <Double>  resultadoXcubica = new ArrayList<>();

        for (DataSet data: datos){
            double xcub= data.getX() * data.getX() * data.getX();
            resultadoXcubica.add(xcub);

        }
        return resultadoXcubica;

    }

    public static ArrayList<Double> XCuarta (ArrayList<DataSet> datos){

        ArrayList <Double>  resultadoXcuarta = new ArrayList<>();

        for (DataSet data: datos){
            double xcuart= data.getX() * data.getX() * data.getX()* data.getX();
            resultadoXcuarta.add(xcuart);

        }
        return resultadoXcuarta;

    }


    public static ArrayList<Double> XCuadradaY (ArrayList<DataSet> datos){

        ArrayList <Double>  resultadoXcuadradaY = new ArrayList<>();

        for (DataSet data: datos){
            double xcuadraday= (data.getX() * data.getX()) * data.getY();
            resultadoXcuadradaY.add(xcuadraday);

        }
        return resultadoXcuadradaY;
    }

    public static double SumaXCuadradaY (ArrayList<Double> XcuadradaY){
        double sumaxcuadraday = 0;

        //iterar sobre el array de productos x * x y sumar los valores
        for(double xxy : XcuadradaY){
            sumaxcuadraday += xxy ;
        }
        return  sumaxcuadraday;
    }


    public static double SumaX (ArrayList<DataSet> datos){

        double sumaX=0;

        for (DataSet data: datos){
        sumaX += data.getX();


        }
        return sumaX;
    }

    public static double SumaY (ArrayList<DataSet> datos){

        double sumaY=0;

        for (DataSet data: datos){
            sumaY += data.getY();

        }
        return sumaY;
    }
    public static double SumaYCuad(ArrayList<DataSet> datos) {
        double sumaYcuad = 0;
    
        // Iterar sobre el array de datos y sumar los cuadrados de Y
        for (DataSet data : datos) {
            sumaYcuad += data.getY() * data.getY();
        }
    
        return sumaYcuad;
    }

    public static double SumaXY(ArrayList<Double> MultXY) {
        double sumaXY = 0;

        // Iterar sobre el array de productos X * Y y sumar los valores
        for (double xy : MultXY) {
            sumaXY += xy;
        }

        return sumaXY;
    }


    public static double SumaXCuad (ArrayList<Double> Xcuadrada){
    double sumaxcuad = 0;

    //iterar sobre el array de productos x * x y sumar los valores
    for(double xx : Xcuadrada){
        sumaxcuad += xx ;
    }
    return  sumaxcuad;
    }

    public static double SumaXCubica (ArrayList<Double> Xcubica){
        double sumaxcubica = 0;

        //iterar sobre el array de productos x * x y sumar los valores
        for(double xxx : Xcubica){
            sumaxcubica += xxx ;
        }
        return  sumaxcubica;
    }

    public static double SumaXCuarta (ArrayList<Double> Xcuarta){
        double sumaxcuarta = 0;

        //iterar sobre el array de productos x * x y sumar los valores
        for(double xxxx : Xcuarta){
            sumaxcuarta += xxxx ;
        }
        return  sumaxcuarta;
    }


 

    public static double Tamano(ArrayList<DataSet> datos){
    double n =0;
    n=datos.size();
    return n;
    }



    public static void correlacion(ArrayList <DataSet> datos){
        double sumaX = SumaX(datos);
        double sumaY = SumaY(datos);
        double sumaXY = SumaXY(MultXY(datos));
        double sumaXcuad = SumaXCuad(Xcuadrada(datos));
        double sumaXcuarta = SumaXCuarta(XCuarta(datos));
        double n = Tamano(datos);
        double r = (n*sumaXY - sumaX*sumaY) / Math.sqrt((n*sumaXcuad - sumaX*sumaX)*(n*sumaXcuarta - sumaX*sumaXcuad));

        System.out.println("El coeficiente de correlacion es: " + r);
    }


    public static void correlacionCuadratica(ArrayList<DataSet> datos){
        double sumaX = SumaX(datos);
        double sumaY = SumaY(datos);
        double sumaXY = SumaXY(MultXY(datos));
        double sumaYcuad= SumaYCuad(datos);
        double sumaXcuad = SumaXCuad(Xcuadrada(datos));
        double n = Tamano(datos);
        
        double r = (n * sumaXY - sumaX * sumaY) / Math.sqrt((n * sumaXcuad - Math.pow(sumaX, 2)) * (n * sumaYcuad - Math.pow(sumaY, 2)));
        System.out.println("El coeficiente de correlacion cuadratica es: " + r);
    }
}
