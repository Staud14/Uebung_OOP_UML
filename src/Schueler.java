import java.time.LocalDate;
import java.time.Period;

public class Schueler extends Person{

    private int katalognummer;
    private LocalDate eintritsdatum;

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
