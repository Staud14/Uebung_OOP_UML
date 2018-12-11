import java.util.ArrayList;

public class Abteilung {
    private String name;
    private String kuerzel;

    private Lehrer abteilungsvorstand;
    private Schueler abteilingssprecher;
    private Schule schule;
    private ArrayList<Lehrer> lehrer;
    private ArrayList<Klasse> klassen;

    public Abteilung(String name, String kuerzel, Schule schule){
        this.schule         = schule;
        this.name           = name;
        this.kuerzel        = kuerzel;
        lehrer              = new ArrayList<Lehrer>();
        klassen             = new ArrayList<Klasse>();
        abteilingssprecher  = null;
        abteilungsvorstand  = null;
    }

    public String getName() {
        return name;
    }

    public String getKuerzel() {
        return kuerzel;
    }


    public Lehrer getAbteilungsvorstand() {
        return abteilungsvorstand;
    }

    public boolean setAbteilungsvorstand(Lehrer lehrer){
        if(schule.getDirektor() == lehrer)
            return false;
        for(Abteilung abt : schule.getAbteilungen())
        {
            if(abt.getAbteilungsvorstand() == lehrer)
                return false;
        }
        abteilungsvorstand = lehrer;
        return true;
    }

    public boolean addLehrer(Lehrer lehrer)
    {
        return this.lehrer.add(lehrer);
    }

    public ArrayList<Klasse> getKlassen() {
        return klassen;
    }

    public ArrayList<Schueler> getSchueler() {
        ArrayList<Schueler> schueler = new ArrayList<Schueler>();
        for(Klasse kl : getKlassen())
        {
            schueler.addAll(kl.getSchueler());
        }
        return schueler;
    }
}
