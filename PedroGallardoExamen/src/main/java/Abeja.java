
public class Abeja {

    private Castas casta;
    private String sexo;
    private boolean ponehuevos;
    private int huevos;

    public Abeja(String casta) {
        //Defino la abeja segun su casta, si es zangano se define macho, si no se define hembra y si ademas fuera reina define poner huevos true
        this.casta = Castas.valueOf(casta.toUpperCase());
        if (casta.toUpperCase().equals("ZANGANO")) {
            this.sexo = "MACHO";
            this.ponehuevos = false;
        } else {
            this.sexo = "HEMBRA";
            this.ponehuevos = true;
        }

    }

    //devuelve la casta de la abeja
    public Castas getCasta() {
        return casta;
    }

    //actualiza el valor de si puede o no poner huevos
    public void setPonehuevos(boolean ponehuevos) {
        this.ponehuevos = ponehuevos;
    }

    //devuelve si puede o no poner huevos
    public boolean isPonehuevos() {
        return ponehuevos;
    }

    //deuvelve como pone cera la abeja
    public String segregaCera() {
        return "Segregando cera, no molesten";
    }

    //sdevuelve string con el zumbido
    public String zumbido() {
        return "Bzzzzz";
    }

    //devulve un String de todos los datos sobre una abeja
    public String getDatos() {
        return "Casta: " + casta.toString() + ", Sexo: " + sexo;
    }

    //todas las abejas pueden volar
    public void muestraVuelo() {
        System.out.println("VOLAAANDO VOY, VOLAAAANDO VENGO");
    }
}
