public class Adresse {
    private String ort;
    private String strasse;
    private int hausnummer;
    private int plz;

    public Adresse(String ort, String strasse, int hausnummer, int plz)
    {
        this.ort = ort;
        this.strasse = strasse;
        this.hausnummer = hausnummer;
        this.plz = plz;
    }

    public String getOrt() {
        return ort;
    }

    public String getStrasse() {
        return strasse;
    }

    public int getHausnummer() {
        return hausnummer;
    }

    public int getPlz() {
        return plz;
    }

    public void printAddresse()
    {
        System.out.println(strasse + " " + hausnummer);
        System.out.println(getPlz() + " " + getOrt());
    }
}
