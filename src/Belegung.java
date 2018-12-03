import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;



public class Belegung {
    private int unterrichtsEinheit;

    public Unterrichtstag getWochentag(){
        String s;
        LocalDate date = LocalDate.now();

        s = date.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("de"));
        s = s.toUpperCase();
        return Unterrichtstag.valueOf(s);
    }

    //TODO: Getter Klasse
    public Klasse getKlasse(){

    }

    //TODO: Getter Lehrer
    public Lehrer getLehrer(){

    }
}

enum Unterrichtstag{
    MONTAG, DIENSTAG, MITTWOCH, DONNERSTAG, FREITAG
}