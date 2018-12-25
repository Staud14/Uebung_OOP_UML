import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Hashtable;
import java.util.Locale;

public class Raum {

    //Variables
    private String raumNummer;
    private int maxSitzplaetze;
    private Raumtyp raumtyp;
    private Hashtable<String, Belegung> belegung = new Hashtable<String, Belegung>();                   //Key: "Wochenkürzel englisch"  + Stundennummer      z.B.: 3Stunde am Dienstang TUE3

    //Constructors
    public Raum(String raumNum, int maxSitpl, Raumtyp raumty, Hashtable<String, Belegung> x) {
        raumNummer = raumNum;
        maxSitzplaetze = maxSitpl;
        raumtyp = raumty;
        belegung.putAll(x);
    }

    public Raum(String raumNum, int maxSitpl, Raumtyp raumty) {
        raumNummer = raumNum;
        maxSitzplaetze = maxSitpl;
        raumtyp = raumty;
    }


    //Methodes
    public String getRaumNummer() {
        return raumNummer;
    }

    //TODO: export Belegung
    public void exportBelegung() {

    }

    public int getMaxSitzplaetze() {
        return maxSitzplaetze;
    }

    public Raumtyp getRaumtyp() {
        return raumtyp;
    }

    public void setRaumtyp(Raumtyp x) {
        raumtyp = x;
    }

    public void addBelegung(Belegung bel) {
        belegung.put((bel.getUnterrichtsTag().getDisplayName(TextStyle.SHORT, Locale.ENGLISH).toUpperCase() + bel.getUnterrichtsEinheit()), bel);
    }

    public Belegung getBelegung(DayOfWeek tag, int unterrichtsEinheit) {
        return belegung.get(tag.getDisplayName(TextStyle.SHORT, Locale.ENGLISH).toUpperCase() + unterrichtsEinheit);
    }

    public void removeBelegung(DayOfWeek tag, int unterrichtsEinheit) {
        belegung.remove(tag.getDisplayName(TextStyle.SHORT, Locale.ENGLISH).toUpperCase() + unterrichtsEinheit);
    }
}

enum Raumtyp {
    KLASSENZIMMER, LABORRAUM
}

