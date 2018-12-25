import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;
import java.util.Hashtable;


public class Fach {
    private String name;
    private int wochenstunden;
    private Raumtyp raumanforderung;
    private Set<Klasse> klasse = new LinkedHashSet<Klasse>();
    private Set<Lehrer> lehrer = new LinkedHashSet<Lehrer>();
    private Hashtable<String, Belegung> belegung = new Hashtable<String, Belegung>();                   //Key: "Wochenkürzel englisch"  + Stundennummer      z.B.: 3Stunde am Dienstang TUE3

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
        belegung.put((bel.getUnterrichtsTag().getDisplayName(TextStyle.SHORT, Locale.ENGLISH).toUpperCase() + bel.getUnterrichtsEinheit()), bel);
    }

    public Belegung getBelegung(DayOfWeek tag, int unterrichtsEinheit) {
        return belegung.get(tag.getDisplayName(TextStyle.SHORT, Locale.ENGLISH).toUpperCase() + unterrichtsEinheit);
    }

    public void removeBelegung(DayOfWeek tag, int unterrichtsEinheit) {
        belegung.remove(tag.getDisplayName(TextStyle.SHORT, Locale.ENGLISH).toUpperCase() + unterrichtsEinheit);
    }
}
