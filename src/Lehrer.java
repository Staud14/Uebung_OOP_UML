import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.*;

public class Lehrer extends Mitarbeiter {
    private String kuerzel;
    private Set<Fach> unteritsfächer = new TreeSet<Fach>();
    private Klasse[] klassen = {null, null};


    public Lehrer(long svnr, String vorname, String nachname,
                  LocalDate geburtsdatumm, String email, Adresse wohnort) {

        super(svnr, vorname, nachname, geburtsdatumm, email, wohnort);
    }


    public String getKuerzel() {
        return kuerzel;
    }

    public void setKuerzel(String x) throws ArrayIndexOutOfBoundsException {
        if (x.length() == 4) {
            kuerzel = x;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void addKlasse(Klasse newKlass) throws ArrayIndexOutOfBoundsException {
        if (klassen[0] != null) {
            klassen[0] = newKlass;
        } else if (klassen[1] != null) {
            klassen[1] = newKlass;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public boolean removeKlasse(Klasse toRemove) {
        for (Klasse now : klassen) {
            if (now == toRemove) {
                now = null;
                return true;
            }
        }
        return false;
    }

    public boolean removeKlasse(int indexOfToRemove) {
        if (indexOfToRemove < 3) {
            klassen[indexOfToRemove] = null;
            return true;
        } else {
            return false;
        }
    }

    public void exportStundenplan() {
        String[] classes = {null, null};
        List<Belegung> belegung = new LinkedList<Belegung>();

        for (int x = 0; x < classes.length; x++) {
            if (klassen[x] != null) {
                classes[x] = klassen[x].getBezeichnung();
            }
        }

        for (Fach x : unteritsfächer) {                   //Alle Unterrichtsstunden des Lehrers suchen
            for (Belegung y : x.getBelegung()) {
                if (y.getLehrer().equals(kuerzel)) {
                    belegung.add(y);
                }
            }
        }

        //TODO: Sortierung der Belegung nach Tag und Unterrichtseineheit

        for (Belegung x : belegung) {
            System.out.print(x.getUnterrichtsTag().getDisplayName(TextStyle.FULL, Locale.GERMAN));
            System.out.print("  ");
            System.out.print(x.getUnterrichtsEinheit());
            System.out.print("  ");
            System.out.print(x.getFach().getName());
            System.out.print("  ");
            System.out.print(x.getRaum().getRaumNummer());
            System.out.print("  ");
            System.out.println(x.getKlasse().getBezeichnung());
        }


    }


    public void addFach(Fach newFach) {
        unteritsfächer.add(newFach);
    }

    public void removeFach(Fach toRemove) {
        unteritsfächer.remove(toRemove);
    }

    public void removeFach(String toRemove) {
        Fach goingToRemove = null;

        for (Fach x : unteritsfächer) {
            if (x.getName().equals(toRemove)) {
                goingToRemove = x;
            }
        }

        if (goingToRemove != null) {
            unteritsfächer.remove(goingToRemove);
        }

    }

    //TODO: Für Christian das XOR


}
