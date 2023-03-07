
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class NewMain {

    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Colmena> colmenas = new ArrayList<Colmena>();
        //APARTADO 1
        //crea el panal blanca, e inicializamos con una abeja reina, 2 obreras y 1 zangano
        Colmena blanca = new Colmena();
        blanca.añadeAbeja(new Abeja("Reina"));
        blanca.añadeAbeja(new Abeja("Obrera"));
        blanca.añadeAbeja(new Abeja("obrera"));
        blanca.añadeAbeja(new Abeja("zangano"));
        //APARTADO 2
        //muestra el estado de la colmena(abejas del enjambre) y del panal(inicialmente sin huevos)
        blanca.muestraEnjambre();
        blanca.muestraPanal();

        //APARTADO 3, APARTADO 4
        //pone las abejas a trabajar
        blanca.actividadColmena();
        //nuevo estado del panal desps de poner huevos
        blanca.muestraPanal();

        //APARTADO 5, APARTADO 6, APARTADO 7
        //alimentar los huevos para que nazacan abejas
        blanca.alimentaAbejas(0, 0);
        blanca.alimentaAbejas(0, 1);
        //muestra el panal despues de haber nacido las nuevas abejas y el nuevo enjambre
        blanca.muestraEnjambre();
        blanca.muestraPanal();
    }
}
