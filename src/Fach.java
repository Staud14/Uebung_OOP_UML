import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Fach {
    private String name;
    private int wochenstunden;
    private Raumtyp raumanforderung;
    private Set<Klasse> klasse = new LinkedHashSet<Klasse>();
    private Set<Lehrer> lehrer = new LinkedHashSet<Lehrer>();

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

    public void addLehrer(Lehrer adding){
        lehrer.add(adding);
    }

    public void deleteLehrer(Lehrer removing){
        lehrer.remove(removing);
    }
}
