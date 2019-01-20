import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

import java.time.LocalDate;
import java.time.Period;

public class Schueler extends Person implements Comparable{

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

    @Override
    public int compareTo(Object o) {
        if (o instanceof Schueler)
        {
            Schueler obj = (Schueler) o;
            if(obj.katalognummer == katalognummer)
                return 0;
            if(obj.katalognummer < katalognummer)
                return -1;
            return 1;
        }
        return 0;
    }
}
