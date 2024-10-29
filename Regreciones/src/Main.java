import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static int op;
    static Scanner scanner= new Scanner(System.in);

    public static double[] xValoresParaPredecir = {90, 100, 110, 120, 130};


    public static void main(String[] args) {
        ArrayList<DataSet> datos = DataSet.Datos();
        DataSet.dividirdatos();
        ArrayList<DataSet> datos2 = DataSet.datos70Uno;
        ArrayList<DataSet> datos3 = DataSet.datos30Uno;
        DataSet.dividirdatos2();
        ArrayList<DataSet> datos4 = DataSet.datos70Dos;
        ArrayList<DataSet> datos5 = DataSet.datos30Dos;

        Cuadratica Cuadratica = new Cuadratica();


        double r2CompletoLineal = 0, r2UnoLineal = 0, r2DosLineal = 0;
        double r2CompletoCuadratica = 0, r2UnoCuadratica = 0, r2DosCuadratica = 0;
        double[] mejoresBetas = new double[2]; // Para almacenar las mejores betas de SLR
        
        System.out.println(datos.size());
        do {
            System.out.println("----Selecciona la regrecion: ----");
            System.out.println(" 1- Simple linear regression ");
            System.out.println(" 2- Quadratic linear regression ");
            System.out.println(" 3- Polinomial regression ");
            System.out.println(" 0- Exit ");
                op = scanner.nextInt();


                switch (op){
                    case 1:
                    System.out.println("--------------------------------------");
                    System.out.println("---Datos completos---");
                    System.out.println("--------------------------------------");
                        //SLR
                        // Obtener el conjunto de datos antes de todo
                        //calculo de betas
                        Lineal.calcularBetas(datos);
                        MatDis.correlacion(datos);
                        // Array con los valores de x para predecir
                        Lineal.predecir(xValoresParaPredecir);
                        // Calcular el MSE
                        r2CompletoLineal =  Error.calcularMSE(datos);
                    
                        System.out.println("--------------------------------------");
                        System.out.println("---Datos 70% Uno Se entrena con en 70% inicial---");
                        System.out.println("--------------------------------------");

                        //calcular las betas con el 70% para entrenar 
                        Lineal.calcularBetas(datos2);
                        MatDis.correlacion(datos2);
                        //predices los valores de Y para el 30% restante
                        Lineal.predecirRestante(datos3);
                        // Calcular el MSE con el error del 30% restante usando los valores de Y predecidos por mi modelo entrenado
                        r2UnoLineal= Error.calcularMSE(datos3);
                        // Array con los valores de x para predecir
                        Lineal.predecir(xValoresParaPredecir);

                        System.out.println("--------------------------------------"); 
                        System.out.println("---Datos 70% Dos Se entrena con el 30% inicial---");
                        System.out.println("--------------------------------------");
                        //calculo de betas
                        Lineal.calcularBetas(datos4);
                        MatDis.correlacion(datos4);
                        // Array con los valores de x para predecir
                        Lineal.predecirRestante(datos5);
                        // Calcular el MSE
                        r2DosLineal= Error.calcularMSE(datos5);
                        System.out.println("Prediccion");
                        Lineal.predecir(xValoresParaPredecir);
                        System.out.println("---------------------------------------------");
                        // Comparaciones del mejor R² para regresión lineal
                        if (r2CompletoLineal > r2UnoLineal && r2CompletoLineal > r2DosLineal) {
                            System.out.println("El mejor modelo lineal es el de datos completos con un R^2 de: " + r2CompletoLineal);
                            mejoresBetas = Lineal.calcularBetas(datos); // Guardar las betas del mejor modelo
                        } else if (r2UnoLineal > r2CompletoLineal && r2UnoLineal > r2DosLineal) {
                            System.out.println("El mejor modelo lineal es el de datos 70%-30% uno con un R^2 de: " + r2UnoLineal);
                            mejoresBetas = Lineal.calcularBetas(datos2); // Guardar las betas del mejor modelo
                        } else {
                            System.out.println("El mejor modelo lineal es el de datos 70%-30% dos con un R^2 de: " + r2DosLineal);
                            mejoresBetas = Lineal.calcularBetas(datos4); // Guardar las betas del mejor modelo
                        }
                        


                        break;
                    case 2:
                        System.out.println("--------------------------------------");
                        System.out.println("------------Datos completos-----------");
                        System.out.println("--------------------------------------");
                        Cuadratica.HacerMatriz(datos);
                        Cuadratica.mostrarMatrizInicial();
                        MatDis.correlacionCuadratica(datos);
                        Cuadratica.resolverMatriz();
                        r2CompletoCuadratica = Error.CalcularMSECuadratico(datos);

                        System.out.println("--------------------------------------");
                        System.out.println("-----------Datos 70-30----------------");
                        System.out.println("--------------------------------------");
                        Cuadratica.HacerMatriz(datos2);
                        Cuadratica.mostrarMatrizInicial();
                        MatDis.correlacionCuadratica(datos2);
                        Cuadratica.resolverMatriz();
                        Cuadratica.predecirRestante(datos3);
                        r2UnoCuadratica = Error.CalcularMSECuadratico(datos3);


                        System.out.println("--------------------------------------");
                        System.out.println("----------Datos 30-70-----------------");
                        System.out.println("--------------------------------------");
                        Cuadratica.HacerMatriz(datos4);
                        Cuadratica.mostrarMatrizInicial();
                        MatDis.correlacionCuadratica(datos4);
                        Cuadratica.resolverMatriz();
                        Cuadratica.predecirRestante(datos5);
                        r2DosCuadratica=Error.CalcularMSECuadratico(datos5);
                        System.out.println("---------------------------------------------");
                        // Comparaciones del mejor R² para regresión cuadrática
                        if (r2CompletoCuadratica > r2UnoCuadratica && r2CompletoCuadratica > r2DosCuadratica) {
                            System.out.println("El mejor modelo cuadrático es el de datos completos con un R^2 de: " + r2CompletoCuadratica);
                        } else if (r2UnoCuadratica > r2CompletoCuadratica && r2UnoCuadratica > r2DosCuadratica) {
                            System.out.println("El mejor modelo cuadrático es el de datos 70%-30% uno con un R^2 de: " + r2UnoCuadratica);
                        } else {
                            System.out.println("El mejor modelo cuadrático es el de datos 70%-30% dos con un R^2 de: " + r2DosCuadratica);
                    }
                    break;
                    case 3:
                        System.out.println("En grado 2");
                        System.out.println("--------------------------------------");
                        System.out.println("------------Datos completos-----------");
                        System.out.println("--------------------------------------");

                        int grado = 2;
                        double[][] matriz = Polinomial.generarMatriz(datos, grado);
                       // Polinomial.imprimirMatriz(matriz);
                        Polinomial.GaussJordan(matriz);
                        Polinomial.predecir(xValoresParaPredecir);
                        Error.ErrorMSEPolinomial(datos);

                        System.out.println("--------------------------------------");
                        System.out.println("-----------Datos 70-30----------------");
                        System.out.println("--------------------------------------");        
                        matriz = Polinomial.generarMatriz(datos2, grado);
                        //Polinomial.imprimirMatriz(matriz);
                        Polinomial.GaussJordan(matriz);
                        Polinomial.predecir(xValoresParaPredecir);
                        Error.ErrorMSEPolinomial(datos3);

                        System.out.println("--------------------------------------");
                        System.out.println("----------Datos 30-70-----------------");
                        System.out.println("--------------------------------------");
                        matriz = Polinomial.generarMatriz(datos4, grado);
                        //Polinomial.imprimirMatriz(matriz);
                        Polinomial.GaussJordan(matriz);
                        Polinomial.predecir(xValoresParaPredecir);
                        Error.ErrorMSEPolinomial(datos5);
                        break;
                }


        }while (op!=0);
        scanner.close();

    }
}
