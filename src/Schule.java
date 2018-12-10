import java.util.ArrayList;
import java.util.Set;

public class Schule {
    private String name;
    private Long schulkennzahl;
    private String schultyp;
    private Lehrer direktor;
    private Schueler schulsprecher;

    private ArrayList<NichtLehrpersonal> personal;
    private ArrayList<Abteilung> abteilungen;

    public boolean addPersonal(NichtLehrpersonal personal)
    {
        return this.personal.add(personal);
    }

    public boolean addAbteilung(String name, String kuerzel)
    {
        return abteilungen.add(new Abteilung(name,kuerzel));
    }

    public Lehrer getDirektor() {
        return direktor;
    }

    public boolean setDirektor(Lehrer lehrer)
    {
        for(Abteilung abt : abteilungen)
        {
            if(abt.getAbteilungsvorstand() == lehrer)
                return false;
        }
        direktor = lehrer;
        return true;
    }

    public Long getSchulkennzahl() {
        return schulkennzahl;
    }

    public String getName() {
        return name;
    }

    public String getSchultyp() {
        return schultyp;
    }

    public ArrayList<NichtLehrpersonal> getPersonal() {
        return personal;
    }

    public ArrayList<Abteilung> getAbteilungen() {
        return abteilungen;
    }

    public ArrayList<Schueler> getSchueler() {
        ArrayList<Schueler> schueler = new ArrayList<Schueler>();
        for(Abteilung abt : getAbteilungen())
        {
            schueler.addAll(abt.getSchueler());
        }
        return schueler;
    }

    public int getAnzahlSchueler()
    {
        return getSchueler().size();
    }
}
