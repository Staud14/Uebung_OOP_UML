import java.time.LocalDate;
import java.time.Month;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        //Fach[] fächer = [new Fach("FSST",5, Raumtyp.KLASSENZIMMER)];
        Set<Fach> pfefferfaecher = new TreeSet<>();
        Schule schule = new Schule("HTL St.Pölten",5,"HTL",
                new Lehrer(rand.nextLong(),"Matin","Pfeffel",
                        LocalDate.of(1, Month.DECEMBER,5),"", new Adresse("Pfefferdorf","Pfefferstraße",4,50),"",pfefferfaecher),
                new Adresse("St. Pölten","Waldstraße",3,3100));
        schule.addAbteilung("Elektronik und Technische Informatik", "EL");
        schule.addAbteilung("Elektrotechnik", "ET");
        schule.getAbteilungen().forEach((abteilung) -> {
            if(abteilung.getKuerzel() == "EL")
            {
                Lehrer k = new Lehrer(rand.nextLong(),"Wolfgang","Kuran", LocalDate.of(123,Month.JULY,5),"wolfgang.kuran@htlstp.at",
                        new Adresse("Melk","Straße", 5, 500),"KURA", new TreeSet<Fach>());
                abteilung.addLehrer(k);
                abteilung.setAbteilungsvorstand(k);

            } else if(abteilung.getKuerzel() == "ET")
            {
                Lehrer av = new Lehrer(rand.nextLong(),"ETavVN","ETavNN", LocalDate.of(4212,Month.FEBRUARY,7),"ETavEmail",
                        new Adresse("Melk","Straße",5, 500),"ETAV", new TreeSet<Fach>());
                abteilung.addLehrer(av);
                abteilung.setAbteilungsvorstand(av);
            }
        });
    }
}
