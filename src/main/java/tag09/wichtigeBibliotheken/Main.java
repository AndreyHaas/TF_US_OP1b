package tag09.wichtigeBibliotheken;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        //Aufgabe 2
        String string = "Unterricht";
        System.out.println("Länge: " + string.length());
        System.out.println("Großbuchstaben: " + string.toUpperCase());
        System.out.println("Substring: " + string.substring(3, 5));
        double zahl = 3.59;
        System.out.println("Gerundet: " + Math.round(zahl));
        System.out.println("Aufrunden: " + Math.ceil(zahl));
        System.out.println("Abrunden: " + Math.floor(zahl));
        System.out.println("Wurzel: " + Math.sqrt(25));
        System.out.println("Potenz: " + Math.pow(5, 2));
        int zahl2 = Integer.parseInt("2"); //Unboxing
        Integer zahl3 = 2; //Autoboxing
        System.out.println("Integer.parse" + zahl2);

        //Aufgabe 3
        Produkt produkt = new Produkt(
                "Käse",
                new BigDecimal("3.19"),
                "Milchprodukt",
                LocalDate.of(2026, 3, 19));

        System.out.println(produkt.getName());
        System.out.println(produkt.getPreis());
        System.out.println(produkt.getKategorie());
        System.out.println(produkt.getHaltbarBis());
        System.out.println(produkt.beschreibe());

        //Aufgabe 4
        LocalDate heute = LocalDate.now();
        System.out.println("Heute: " + heute);

        //LocalDate gestern = LocalDate.of(2026, 3, 18);
        LocalDate gestern = heute.minusDays(1);

        System.out.println("Gestern: " + gestern);

        System.out.println("Gestern formatiert: " + gestern.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        Period period = Period.between(gestern, heute);
        System.out.println("Period: " + period.getDays() + " Tag(e) + Monate: " + period.getMonths());

        //Aufgabe 5
        BigDecimal preis1 = new BigDecimal("6.99");
        BigDecimal preis2 = new BigDecimal("2.99");
        BigDecimal summe = preis1.add(preis2);
        System.out.println("Summe: " + summe);

        BigDecimal rabatt = new BigDecimal("0.50");
        BigDecimal rabattierterPreis = preis1.subtract(rabatt);
        System.out.println("Rabattierter Preis: " + rabattierterPreis);

        BigDecimal num1 = new BigDecimal("2");
        BigDecimal num2 = preis2.multiply(num1);
        System.out.println("Multiplizierter Preis: " + num2);

        //zwei Nachkommastellen, normales kaufmännisches Runden
        num2 = preis2.divide(num1, 2, RoundingMode.HALF_UP);
        System.out.println("Dividierter Preis: " + num2);

        BigDecimal gerundet = preis2.setScale(2, RoundingMode.HALF_UP);
        System.out.println(gerundet);

        //Aufgabe 9: Sortieren und Vergleichen von Daten
        ProduktVerwaltung produktVerwaltung = new ProduktVerwaltung();

        produktVerwaltung.produktHinzufuegen(
                new Produkt("Käse", new BigDecimal("3.19"), "Milchprodukt", LocalDate.of(2026, 3, 19))
        );

        produktVerwaltung.produktHinzufuegen(
                new Produkt("Brot", new BigDecimal("1.99"), "Backwaren", LocalDate.of(2026, 3, 20))
        );

        produktVerwaltung.produktHinzufuegen(
                new Produkt("Saft", new BigDecimal("2.49"), "Getränke", LocalDate.of(2026, 3, 25))
        );

        Collections.sort(produktVerwaltung.getProdukte(), Comparator.comparing(Produkt::getPreis));
        System.out.println("Produkte nach Preis sortiert: ");
        produktVerwaltung.alleProdukteAusgeben();

        Collections.sort(produktVerwaltung.getProdukte(), Comparator.comparing(Produkt::getName));
        System.out.println("Produkte nach Name sortiert: ");
        produktVerwaltung.alleProdukteAusgeben();
    }
}