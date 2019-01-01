import java.time.LocalDate;

public class NichtLehrpersonal extends Mitarbeiter {

    public NichtLehrpersonal(long svnr, String vorname, String nachname,
                             LocalDate geburtsdatumm, String email, Adresse wohnort){

        super(svnr, vorname, nachname, geburtsdatumm, email, wohnort);
    }

}