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

    public String getBezeichnung() {
        return bezeichnung;
    }

    public int getSchulstufe(){
        return schulstufe;
    }

    public float getDurchschnittsalter(){
        int ageSum = 0;
        int cnt = 0;
        LocalDate today = LocalDate.now();

        for(Schueler s: pupils){
<<<<<<< HEAD
            LocalDate birthDate = s.getGeburtsdatum().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            ageSum += Period.between(birthDate, today).getYears();
=======
            LocalDate birthDate = s.getGeburtsdatum();
            durchschnittsalter += Period.between(birthDate, today).getYears();
>>>>>>> 7aa282a67202547a9c3076bec4385df4d955e193
            cnt++;
        }
        return ((float)ageSum/(float)cnt);
    }

    public boolean setKlassensprecher(Schueler schueler){
        klassensprecher = schueler;
        return true;
    }

    public boolean addSchueler(Schueler schueler){
        return pupils.add(schueler);
    }

    public Set<Schueler> getSchueler() {
        return pupils;
    }
}
