import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.*;

public class Lehrer extends Mitarbeiter {
    private String kuerzel;
    private Set<Fach> unteritsfaecher = new HashSet<>();
    private Klasse[] klassen = {null, null};                        //Lehrer kann nur 2 Klassen unterrichten laut UML Diagramm.


    public Lehrer(long svnr, String vorname, String nachname,
                  LocalDate geburtsdatumm, String email, Adresse wohnort, String kuerzl, Set<Fach> untFaecher) {

        super(svnr, vorname, nachname, geburtsdatumm, email, wohnort);
        kuerzel = kuerzl;
        unteritsfaecher.addAll(untFaecher);
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
        List<Belegung> tmp_day = new LinkedList<Belegung>();
        List<Belegung> tmp_hour = new LinkedList<Belegung>();
        List<Belegung> sorted = new LinkedList<Belegung>();

        for (int x = 0; x < classes.length; x++) {
            if (klassen[x] != null) {
                classes[x] = klassen[x].getBezeichnung();
            }
        }

        for (Fach x : unteritsfaecher) {                   //Alle Unterrichtsstunden des Lehrers suchen
            for (Belegung y : x.getBelegung()) {
                if (y.getLehrer().equals(kuerzel)) {
                    belegung.add(y);
                }
            }
        }

        //Sortiern nach Tag
        for (int i = 1; i < 8; i++) {               //Iteriert über gesamte Raumbelegung
            for (Belegung x : belegung) {
                if (x.getUnterrichtsTag().getValue() == i){
                    tmp_day.add(x);
                }
            }

            //Sortiert nach Stunden
            for(int z = 0; z < 15; z++){
                for(Belegung x : tmp_day){
                    tmp_hour.add(x);
                }
            }
            sorted.addAll(tmp_hour);
            tmp_day.clear();
            tmp_hour.clear();
        }

        belegung.clear();
        belegung.addAll(sorted);


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
        unteritsfaecher.add(newFach);
    }

    public void removeFach(Fach toRemove) {
        unteritsfaecher.remove(toRemove);
    }

    public void removeFach(String toRemove) {
        Fach goingToRemove = null;

        for (Fach x : unteritsfaecher) {
            if (x.getName().equals(toRemove)) {
                goingToRemove = x;
            }
        }

        if (goingToRemove != null) {
            unteritsfaecher.remove(goingToRemove);
        }

    }


}
