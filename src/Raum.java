public class Raum {

    //Variables
    private String raumNummer;
    private int maxSitzplaetze;
    private Raumtyp raumtyp;
    private Belegung belegung;

    //Methodes
    public String getRaumNummer(){
        return raumNummer;
    }

    //TODO: export Belegung
    public void exportBelegung(){

    }

    public int getMaxSitzplaetze() {
        return maxSitzplaetze;
    }

    public Raumtyp getRaumtyp(){
        return raumtyp;
    }
}

enum Raumtyp{
    KLASSENZIMMER, LABORRAUM
}

