import javax.management.InvalidAttributeValueException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.TextStyle;
import java.util.Hashtable;
import java.util.Locale;


public class Belegung {
    private int unterrichtsEinheit;
   private Raum raum;
   private Fach fach;

    public Unterrichtstag getWochentag() {
        String s;
        LocalDate date = LocalDate.now();

        s = date.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("de")).toUpperCase();
        return Unterrichtstag.valueOf(s);
    }

    //TODO: Getter Klasse
    public Klasse getKlasse() {

    }

    //TODO: Getter Lehrer
    public Lehrer getLehrer() {

    }

    private void setUnterrichtsEinheit() {
        LocalTime time = LocalTime.now();
        if (time.isAfter(LocalTime.parse("7:50")) && time.isBefore(LocalTime.parse("8:40"))) {
            unterrichtsEinheit = 1;
        } else if (time.isAfter(LocalTime.parse("8:40")) && time.isBefore(LocalTime.parse("9:30"))) {
            unterrichtsEinheit = 2;
        } else if (time.isAfter(LocalTime.parse("9:40")) && time.isBefore(LocalTime.parse("10:30"))) {
            unterrichtsEinheit = 3;
        } else if (time.isAfter(LocalTime.parse("10:30")) && time.isBefore(LocalTime.parse("11:20"))) {
            unterrichtsEinheit = 4;
        } else if (time.isAfter(LocalTime.parse("11:20")) && time.isBefore(LocalTime.parse("12:10"))) {
            unterrichtsEinheit = 5;
        } else if (time.isAfter(LocalTime.parse("12:20")) && time.isBefore(LocalTime.parse("13:10"))) {
            unterrichtsEinheit = 6;
        } else if (time.isAfter(LocalTime.parse("13:10")) && time.isBefore(LocalTime.parse("14:00"))) {
            unterrichtsEinheit = 7;
        } else if (time.isAfter(LocalTime.parse("14:00")) && time.isBefore(LocalTime.parse("14:50"))) {
            unterrichtsEinheit = 8;
        } else if (time.isAfter(LocalTime.parse("15:00")) && time.isBefore(LocalTime.parse("15:50"))) {
            unterrichtsEinheit = 9;
        } else if (time.isAfter(LocalTime.parse("15:50")) && time.isBefore(LocalTime.parse("16:40"))) {
            unterrichtsEinheit = 10;
        }


    }

    private void setUnterrichtsEinheit(LocalTime time) {

        if (time.isAfter(LocalTime.parse("7:50")) && time.isBefore(LocalTime.parse("8:40"))) {
            unterrichtsEinheit = 1;
        } else if (time.isAfter(LocalTime.parse("8:40")) && time.isBefore(LocalTime.parse("9:30"))) {
            unterrichtsEinheit = 2;
        } else if (time.isAfter(LocalTime.parse("9:40")) && time.isBefore(LocalTime.parse("10:30"))) {
            unterrichtsEinheit = 3;
        } else if (time.isAfter(LocalTime.parse("10:30")) && time.isBefore(LocalTime.parse("11:20"))) {
            unterrichtsEinheit = 4;
        } else if (time.isAfter(LocalTime.parse("11:20")) && time.isBefore(LocalTime.parse("12:10"))) {
            unterrichtsEinheit = 5;
        } else if (time.isAfter(LocalTime.parse("12:20")) && time.isBefore(LocalTime.parse("13:10"))) {
            unterrichtsEinheit = 6;
        } else if (time.isAfter(LocalTime.parse("13:10")) && time.isBefore(LocalTime.parse("14:00"))) {
            unterrichtsEinheit = 7;
        } else if (time.isAfter(LocalTime.parse("14:00")) && time.isBefore(LocalTime.parse("14:50"))) {
            unterrichtsEinheit = 8;
        } else if (time.isAfter(LocalTime.parse("15:00")) && time.isBefore(LocalTime.parse("15:50"))) {
            unterrichtsEinheit = 9;
        } else if (time.isAfter(LocalTime.parse("15:50")) && time.isBefore(LocalTime.parse("16:40"))) {
            unterrichtsEinheit = 10;
        }


    }

    private void setUnterrichtsEinheit(int i){
        unterrichtsEinheit = i;
    }

    public void addFach(Fach newFach, int unterriEinheit, String wochentagKuerzel) throws InvalidAttributeValueException {
        wochentagKuerzel = wochentagKuerzel.toUpperCase();
        if (wochentagKuerzel.equals("MO") || wochentagKuerzel.equals("DI") || wochentagKuerzel.equals("MI") || wochentagKuerzel.equals("DO") || wochentagKuerzel.equals("FR")) {
            if (unterriEinheit < 11) {
                belegung.put(wochentagKuerzel + Integer.toString(unterriEinheit), newFach);
            }
        } else {
            throw new InvalidAttributeValueException();
        }
    }

    public void removeFach(int unterriEinheit, String wochentagKuerzel) {
        belegung.remove(wochentagKuerzel + Integer.toString(unterriEinheit));
    }

    public Fach getFach(int unterriEinheit, String wochentagKuerzel) {
        return belegung.get(wochentagKuerzel + Integer.toString(unterriEinheit));
    }
}

enum Unterrichtstag {
    MONTAG, DIENSTAG, MITTWOCH, DONNERSTAG, FREITAG
}

//Belegung enthält 1 Fach und 1 Raum
//Raum und Fach enthalten Hastabeles