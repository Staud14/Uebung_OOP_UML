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
    private Klasse klasse;

    //Constructors
    public Raum(String raumNum, int maxSitpl, Raumtyp raumty, Hashtable<String, Belegung> x, Klasse klas) {
        raumNummer = raumNum;
        maxSitzplaetze = maxSitpl;
        raumtyp = raumty;
        belegung.putAll(x);
        klasse = klas;
    }

    public Raum(String raumNum, int maxSitpl, Raumtyp raumty, Klasse klas) {
        raumNummer = raumNum;
        maxSitzplaetze = maxSitpl;
        raumtyp = raumty;
        klasse = klas;
    }


    //Methodes
    public String getRaumNummer() {
        return raumNummer;
    }

    public void exportBelegung() {
        Belegung jetzt;
        for (int day = 1; day < 8; day++) {
            for (int einheit = 1; einheit < 12; einheit++) {
                jetzt = getBelegung(DayOfWeek.of(day),einheit);
                System.out.print(DayOfWeek.of(day).getDisplayName(TextStyle.FULL, Locale.GERMAN) + "  ");
                System.out.print(einheit + " Stunde  ");
                if(jetzt != null){
                    System.out.print(jetzt.getLehrer().getKuerzel());
                    System.out.println(jetzt.getFach().getName());
                }
                else{
                    System.out.println("");
                }
                }
        }
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

    public void setKlasse(Klasse klas) {
        klasse = klas;
    }

    public Klasse getKlasse() {
        return klasse;
    }
}

enum Raumtyp {
    KLASSENZIMMER, LABORRAUM
}

