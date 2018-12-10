import java.time.LocalDate;

public class Person {
    private long svnr;
    private String vorname;
    private String nachname;
    private LocalDate geburtsdatum;
    private String email;
    private Adresse Wohnort;
    private Klasse klasse;

    public LocalDate getGeburtsdatum() {
        return geburtsdatum;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public String getEmail() {
        return email;
    }

    public Adresse getWohnort() {
        return Wohnort;
    }


    public long getSvnr() {
        return svnr;
    }
}
