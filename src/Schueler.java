import java.time.LocalDate;
import java.time.Period;

public class Schueler extends Person{

    private int katalognummer;
    private LocalDate eintritsdatum;


    public Schueler(long svnr, String vorname, String nachname,
                    LocalDate geburtsdatumm, String email, Adresse wohnort,
                    int katalognummer, LocalDate eintritsdatum)
    {
        super(svnr,vorname,nachname,geburtsdatumm,email,wohnort);

        this.katalognummer = katalognummer;
        this.eintritsdatum = eintritsdatum;
    }

    public int getKatalognummer() {
        return katalognummer;
    }
    public LocalDate getEintritsdatum() {
        return eintritsdatum;
    }
    public boolean isEigenberechtigt() {
        LocalDate today = LocalDate.now();
        return Period.between(today, getGeburtsdatum())
                .getYears() > 18;
    }
}
