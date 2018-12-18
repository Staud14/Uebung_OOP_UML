import java.time.LocalDate;

import java.time.Period;
import java.time.ZoneId;
import java.util.Set;
import java.util.TreeSet;

public class Klasse {
    private String bezeichnung;
    private int schulstufe;
    private Schueler klassensprecher;
    private Set<Schueler> pupils = new TreeSet<Schueler>();
    private Set<Fach> lernt;
    private Lehrer klassenvorstand;
    private Fach fach = null;
    private Klasse stammklasse;
    private Abteilung abteilung;

    public String getBezeichnung() {
        return bezeichnung;
    }

    public int getSchulstufe() {
        return schulstufe;
    }

    public float getDurchschnittsalter() {
        int ageSum = 0;
        int cnt = 0;
        LocalDate today = LocalDate.now();

        for (Schueler s : pupils) {
            LocalDate birthDate = s.getGeburtsdatum();
            ageSum += Period.between(birthDate, today).getYears();
            cnt++;
        }
        return ((float) ageSum / (float) cnt);
    }

    public boolean setKlassensprecher(Schueler schueler) {
        klassensprecher = schueler;
        return true;
    }

    public boolean addSchueler(Schueler schueler) {
        return pupils.add(schueler);
    }

    public Set<Schueler> getSchueler() {
        return pupils;
    }

    public void setKlassenvorstand(Lehrer klassenvorstand) {
        klassenvorstand = klassenvorstand;
    }

    public void setFach(Fach sFach) {
        fach = sFach;
    }

    public void setStammklasse(Klasse Stammklasse) {
        stammklasse = Stammklasse;
    }

    public void setAbteilung(Abteilung abteilung) {
        this.abteilung = abteilung;
    }

    public void exportStundenplan(){                    //TODO: Export Stundenplan

    }
}
