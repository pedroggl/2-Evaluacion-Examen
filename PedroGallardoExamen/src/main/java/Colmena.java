
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class Colmena {

    private ArrayList<Abeja> enjambre = new ArrayList<Abeja>();
    private int[][] panal;
    private int filas, columnas;

    public Colmena() {
        //generar un numero aleatorio entre 3 y 10
        //mediante la libreria java.util.Random creamos un objeto random llamado aleatorio, el metodo nextInt devuelve un numero aleatorio entre 0 y el argumento -1
        //en nuestro caso genera un numero aleatorio entre 0 y 7, que a sumarle 3 quedaria como 3 y 10
        Random aleatorio = new Random();
        int filas = aleatorio.nextInt(8) + 3;
        //define el numero de filas entre 3 y 10, y el de columnas como un valor menos al de las filas, se inicializa a 0, que significa que esta vacio
        this.panal = new int[filas][filas - 1];
        this.filas = filas;
        this.columnas = filas - 1;
    }

    //metodo para añadir una abeja al enjambre
    public void añadeAbeja(Abeja abeja) {
        enjambre.add(abeja);
    }

    //metodo para añadir un huevo al panal
    public boolean añadeHuevo(int huevos, Castas casta) {
        int i = 0, j = 0;
        int iterador = huevos;
        while (iterador != 0) {
            //si el panal esta vacio, guarda un huevo, resta uno al numero d huevos restantes por poner y comprueba la posicion de la derecha
            if (panal[i][j] == 0 && casta.toString().equals("REINA")) {
                panal[i][j] = 1;
                iterador -= 1;
                j += 1;
            } else if (panal[i][j] == 0 && casta.toString().equals("OBRERA")) {
                panal[i][j] = 2;
                iterador -= 1;
                j += 1;
            } else {
                j += 1;
            }
            //si j llega al numero de columnas, es decir, se sale del rango d columnas, salta a la siguiente linea
            //si i llega al numero de filas, no habria conseguido guardar los huevos requeridos y por tanto devuleve false
            if ((j == columnas) && ((i + 1) < filas)) {
                j = 0;
                i += 1;
            } else if (i == filas) {
                //no se han podido guardar todos los huevos
                return false;
            }
        }
        //se han guardado todos los huevos
        return true;
    }

    //muestra los datos del enjambre
    public void muestraEnjambre() {
        System.out.println("\n\nSe va a mostrar el Enjambre");
        for (Abeja abeja : enjambre) {
            System.out.println(abeja.getDatos());
        }
    }

    //muetra los datos del panal, los 0 son huevos vacios, los 1 son huevos de reina, los 2 son huevos de obrera
    public void muestraPanal() {
        System.out.println("\n\nSe va a mostrar el panal (0->NO HAY HUEVO;1 o 2->SI HAY HUEVO)");
        for (int[] panal1 : panal) {
            System.out.println(Arrays.toString(panal1));
        }
    }

    //recorre la colmena y pone a trabajar a todos sus integrantes
    public void actividadColmena() {
        System.out.println("\n\nSe va a poner a trabajar al enjambre completo");
        for (Abeja abeja : enjambre) {
            switch (abeja.getCasta()) {
                case REINA:
                    if (abeja.isPonehuevos()) {
                        abeja.setPonehuevos(false);
                        System.out.print("Soy la Reina, voy a poner huevos");
                        System.out.println(",  ¿He podido poner todos los huevos? " + añadeHuevo(1, Castas.REINA));
                    } else {
                        abeja.setPonehuevos(true);
                        System.out.println("La Reina esta cansada y no puede poner huevos");
                    }
                    break;
                case OBRERA:
                    System.out.println("Soy una abeja obrera, " + abeja.segregaCera());
                    if (abeja.isPonehuevos()) {
                        abeja.setPonehuevos(false);
                        System.out.print("Voy a poner huevos");
                        System.out.println(",  ¿He podido poner todos los huevos? " + añadeHuevo(2, Castas.OBRERA));
                    }
                    break;
                case ZANGANO:
                    System.out.println("Solo soy un zangano, estoy ocupado zumbando " + abeja.zumbido());
                    break;
                default:
                    System.out.println("Error con los datos");
                    throw new AssertionError();
            }
        }
    }

    public static Scanner in = new Scanner(System.in);

    //metodo para alimentar abejas, recibe la posicion del huevo que pretende alimentar
    public void alimentaAbejas(int i, int j) {
        switch (panal[i][j]) {
            case 1:
                //el huevo es d reina, asi que sera hembra la larva
                System.out.println("\n\nHUEVO DE REINA\n¿Desea alimentar con jalea real?\n(si se alimenta con jalea real nacera una abeja reina, sino será obrera)");
                if (in.nextLine().equals("si")) {
                    añadeAbeja(new Abeja("Reina"));
                    System.out.println("Ha nacido una reina");
                } else {
                    añadeAbeja(new Abeja("Obrera"));
                    System.out.println("Ha nacido una obrera");
                }
                panal[i][j] = 0;
                break;
            case 2:
                //como el huevo es d obrera solo puede salir zangano zangano
                System.out.println("\n\nHUEVO DE OBRERA");
                añadeAbeja(new Abeja("Zangano"));
                System.out.println("Ha nacido un zangano");
                panal[i][j] = 0;
                break;
            default:
                System.out.println("Posicion seleccionada del panal es incorrecta");
                break;
        }
    }
}
