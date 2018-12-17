import java.util.Set;
import java.util.TreeSet;

public class Fach {
    private String name;
    private int wochenstunden;
    private Raumtyp raumanforderung;
    private Set<Klasse> klasse = new TreeSet<Klasse>();

    //TODO: Connection to Lehrer
    //InProgress: Connection to Klasse

    public String getName() {
        return name;
    }

    public int getWochenstunden() {
        return wochenstunden;
    }

    public Raumtyp getRaumanforderung(){
        return raumanforderung;
    }
}
