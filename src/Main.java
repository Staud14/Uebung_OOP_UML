import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        Fach fsst = new Fach("FSST",5, Raumtyp.KLASSENZIMMER,new HashSet<Klasse>(),new HashSet<Lehrer>(), new HashSet<Belegung>());
        Set<Fach> pfefferfaecher = new HashSet<>();
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
                        new Adresse("Melk","Straße", 5, 500),"KURA", new HashSet<>());
                abteilung.addLehrer(k);
                abteilung.setAbteilungsvorstand(k);

                Lehrer weigl = new Lehrer(rand.nextLong(), "Martin", "Weigl", LocalDate.of(500,Month.MAY,8),"",
                        new Adresse("","",0,0),"WEIG", new HashSet<>());

                abteilung.addLehrer(weigl);
                Lehrer crha = new Lehrer(rand.nextLong(),"Christian", "Crha", LocalDate.of(831, Month.JANUARY,27), "",
                        new Adresse("St. Poelten","",0,3100), "CRHA", new HashSet<>());

                TreeSet<Schueler> schueler = new TreeSet<>();
                schueler.add(new Schueler(rand.nextLong(),"Christian", "Schrefl", LocalDate.of(2000,Month.DECEMBER, 6),"christian.schrefl@htlstp.at",
                        new Adresse("St. Pölten","Hofeckergasse",7,3100),17,LocalDate.of(2000,Month.DECEMBER,6)));
                Schueler klassensp = new Schueler(rand.nextLong(),"Florian","Höllerer",LocalDate.of(178,Month.FEBRUARY,7),"florian@hoellerer@htlstp.at",
                        new Adresse("ort","Straße",0,0),4,LocalDate.of(1342,Month.JUNE,7));
                schueler.add(klassensp);
                Raum w213 = new Raum("W213",24,Raumtyp.KLASSENZIMMER,null);
                Klasse h4a = new Klasse("4AHELS", 8,crha,schueler,w213,abteilung,klassensp);
                w213.setKlasse(h4a);
                w213.addBelegung(new Belegung(9,w213, fsst, DayOfWeek.MONDAY, weigl));
                abteilung.addKlasse(h4a);
            } else if(abteilung.getKuerzel().equals("ET"))
            {
                Lehrer av = new Lehrer(rand.nextLong(),"ETavVN","ETavNN", LocalDate.of(4212,Month.FEBRUARY,7),"ETavEmail",
                        new Adresse("Melk","Straße",5, 500),"ETAV", new HashSet<>());
                abteilung.addLehrer(av);
                abteilung.setAbteilungsvorstand(av);
            }
        });
    }
}
