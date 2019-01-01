public class Mitarbeiter extends Person {
    private static int anzahl = 0;

    public Mitarbeiter()
    {
        anzahl++;
    }

    public int getAnzahl() {
        return anzahl;
    }
}
