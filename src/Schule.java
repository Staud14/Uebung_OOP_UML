import java.util.ArrayList;
import java.util.Set;

public class Schule {
    private String name;
    private long schulkennzahl;
    private String schultyp;
    private Lehrer direktor;
    private Schueler schulsprecher;
    private Adresse standort;

    private ArrayList<NichtLehrpersonal> personal;
    private ArrayList<Abteilung> abteilungen;

    public Schule(String name, long schulkennzahl, String schultyp, Lehrer direktor, Adresse standort){
        this.name=name;
        this.schulkennzahl=schulkennzahl;
        this.schultyp=schultyp;
        this.direktor=direktor;
        this.schulsprecher=null;
        this.standort=standort;
        personal = new ArrayList<>();
        abteilungen = new ArrayList<>();
    }

    public boolean addPersonal(NichtLehrpersonal personal)
    {
        return this.personal.add(personal);
    }

    public boolean addAbteilung(String name, String kuerzel)
    {
        return abteilungen.add(new Abteilung(name,kuerzel,this));
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
