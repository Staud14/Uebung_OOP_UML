import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.*;


public class Fach {
    private String name;
    private int wochenstunden;
    private Raumtyp raumanforderung;
    private Set<Klasse> klasse = new LinkedHashSet<Klasse>();
    private Set<Lehrer> lehrer = new LinkedHashSet<Lehrer>();
    private List<Belegung> belegung = new LinkedList<Belegung>();                   //Key: "Wochenkürzel englisch"  + Stundennummer      z.B.: 3Stunde am Dienstang TUE3

    public String getName() {
        return name;
    }

    public int getWochenstunden() {
        return wochenstunden;
    }

    public void addKlasse(Klasse adding) {
        klasse.add(adding);
    }

    public void deleteKlasse(Klasse removing) {
        klasse.remove(removing);
    }

    public Raumtyp getRaumanforderung() {
        return raumanforderung;
    }

    public void addLehrer(Lehrer adding) {
        lehrer.add(adding);
    }

    public void deleteLehrer(Lehrer removing) {
        lehrer.remove(removing);
    }

    public void addBelegung(Belegung bel) {
        belegung.add(bel);
    }

    public List<Belegung> getBelegung() {
        return belegung;
    }

    public void removeBelegung(Belegung toRemove) {
        belegung.remove(toRemove);
    }
}
