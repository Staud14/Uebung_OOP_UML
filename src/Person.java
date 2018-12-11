import java.time.LocalDate;

public class Person {
    private long svnr;
    private String vorname;
    private String nachname;
    private LocalDate geburtsdatum;
    private String email;
    private Adresse wohnort;
    private Klasse klasse;

    public Person(long svnr, String vorname, String nachname,
                  LocalDate geburtsdatumm, String email, Adresse wohnort){
        this.svnr = svnr;
        this.vorname = vorname;
        this.nachname = nachname;
        this.geburtsdatum = geburtsdatumm;
        this.email = email;
        this.wohnort = wohnort;
    }

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
        return wohnort;
    }

    public long getSvnr() {
        return svnr;
    }
}
