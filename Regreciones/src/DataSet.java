import java.util.ArrayList;

public class DataSet {
    double x, y;

    public static ArrayList <DataSet> datosxy =new ArrayList<>();

public DataSet(double x, double y){
    this.x=x;
    this.y=y;

}

    public static ArrayList<DataSet> Datos() {
           // Limpia la lista si ya contiene elementos
           if (!datosxy.isEmpty()) {
            datosxy.clear(); // Esto reinicia la lista antes de agregar nuevos datos
        }
        
        datosxy.add(new DataSet(108, 95));
        datosxy.add(new DataSet(115, 96));
        datosxy.add(new DataSet(106, 95));
        datosxy.add(new DataSet(97, 97));
        datosxy.add(new DataSet(95, 93));
        datosxy.add(new DataSet(91, 94));
        datosxy.add(new DataSet(97, 95));
        datosxy.add(new DataSet(83, 93));
        datosxy.add(new DataSet(83, 92));
        datosxy.add(new DataSet(78, 86));
        datosxy.add(new DataSet(54, 73));
        datosxy.add(new DataSet(67, 80));
        datosxy.add(new DataSet(56, 65));
        datosxy.add(new DataSet(53, 69));
        datosxy.add(new DataSet(61, 77));
        datosxy.add(new DataSet(115, 96));
        datosxy.add(new DataSet(81, 87));
        datosxy.add(new DataSet(78, 89));           ///70%
        datosxy.add(new DataSet(30, 60));
        datosxy.add(new DataSet(45, 63));
        datosxy.add(new DataSet(99, 95));
        datosxy.add(new DataSet(32, 61));
        datosxy.add(new DataSet(25, 55));
        datosxy.add(new DataSet(28, 56));
        datosxy.add(new DataSet(90, 94));
        datosxy.add(new DataSet(89, 93));

        System.out.println("Datos cargados"+ datosxy.size());
        return datosxy;
    }

    public static ArrayList <DataSet> datos70Uno =new ArrayList<>();
    public static ArrayList <DataSet> datos30Uno =new ArrayList<>();


    public static void dividirdatos(){
        int tamano = datosxy.size();
        int setenta = (int) (tamano*0.7);
        
        for (int i=0; i<setenta; i++){
            datos70Uno.add(datosxy.get(i));

        }

        for (int i=setenta; i<tamano; i++){
            datos30Uno.add(datosxy.get(i)); 
        }

    }

    public static ArrayList <DataSet> datos70Dos =new ArrayList<>();
    public static ArrayList <DataSet> datos30Dos =new ArrayList<>();

    public static void dividirdatos2(){
        int tamano = datosxy.size();
        int treinta = (int) (tamano*0.3);
        
        for (int i=0; i<treinta; i++){
            datos30Dos.add(datosxy.get(i));

        }

        for (int i=treinta; i<tamano; i++){
            datos70Dos.add(datosxy.get(i)); 
        }

    }
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

}
