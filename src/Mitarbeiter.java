import java.time.LocalDate;

public class Mitarbeiter extends Person {
    private static int anzahl = 0;

    public Mitarbeiter(long svnr, String vorname, String nachname,
                       LocalDate geburtsdatumm, String email, Adresse wohnort)
    {
        super(svnr, vorname, nachname, geburtsdatumm, email, wohnort);
        anzahl++;
    }

    public int getAnzahl() {
        return anzahl;
    }
}
