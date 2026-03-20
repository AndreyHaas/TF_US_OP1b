package tag10;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        long start = System.nanoTime();

        // Aufgabe 2
        String text = "Unterricht";
        System.out.println("Länge: " + text.length());
        System.out.println("Großbuchstaben: " + text.toUpperCase());
        System.out.println("Substring: " + text.substring(3, 5));

        double zahl = 3.59;
        System.out.println("Gerundet: " + Math.round(zahl));
        System.out.println("Aufrunden: " + Math.ceil(zahl));
        System.out.println("Abrunden: " + Math.floor(zahl));
        System.out.println("Wurzel: " + Math.sqrt(25));
        System.out.println("Potenz: " + Math.pow(5, 2));

        int zahl2 = Integer.parseInt("2");
        Integer zahl3 = 2;
        System.out.println("Integer.parseInt: " + zahl2);
        System.out.println("Autoboxing: " + zahl3);

        // Aufgabe 3
        Produkt produkt = new Produkt(
                "Käse",
                new BigDecimal("3.19"),
                "Milchprodukt",
                LocalDate.of(2026, 3, 19)
        );

        System.out.println(produkt.getName());
        System.out.println(produkt.getPreis());
        System.out.println(produkt.getKategorie());
        System.out.println(produkt.getHaltbarBis());
        System.out.println(produkt.beschreibe());

        // Aufgabe 4
        LocalDate heute = LocalDate.now();
        System.out.println("Heute: " + heute);

        LocalDate gestern = heute.minusDays(1);
        System.out.println("Gestern: " + gestern);
        System.out.println("Gestern formatiert: " +
                gestern.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));

        Period period = Period.between(gestern, heute);
        System.out.println("Period: " + period.getDays() + " Tag(e), Monate: " + period.getMonths());

        // Aufgabe 5
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

        num2 = preis2.divide(num1, 2, RoundingMode.HALF_UP);
        System.out.println("Dividierter Preis: " + num2);

        // Aufgabe 9: Produkte sortieren
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

        produktVerwaltung.getProdukte().sort(Comparator.comparing(Produkt::getPreis));
        System.out.println("Produkte nach Preis sortiert:");
        produktVerwaltung.alleProdukteAusgeben();

        produktVerwaltung.getProdukte().sort(Comparator.comparing(Produkt::getName));
        System.out.println("Produkte nach Name sortiert:");
        produktVerwaltung.alleProdukteAusgeben();

        // Kundenverwaltung erweitert um Kategorien
        KundenVerwaltung verwaltung = new KundenVerwaltung();

        verwaltung.kundeHinzufuegen(new Kunde("Müller", 1001, "Business"));
        verwaltung.kundeHinzufuegen(new Kunde("Schmidt", 1002, "Economy"));
        verwaltung.kundeHinzufuegen(new Kunde("Andersen", 1003, "Business"));

        System.out.println("Alle Kunden:");
        verwaltung.alleKundenAusgeben();

        System.out.println("\nNur Business-Kunden:");
        verwaltung.kundenNachKategorie("Business");

        System.out.println("\nKategorien:");
        KundenDatenanalyse.kategorienAusgeben(verwaltung);

        System.out.println("\nKunden in Map:");
        KundenDatenanalyse.kundenNachNameZuordnen(verwaltung);

        verwaltung.getKunden().sort(Comparator.comparing(Kunde::getName));
        System.out.println("\nNach Sortierung nach Name:");
        verwaltung.alleKundenAusgeben();

        verwaltung.getKunden().sort(Comparator.comparingInt(Kunde::getKundennummer));
        System.out.println("\nNach Sortierung nach Kundennummer:");
        verwaltung.alleKundenAusgeben();

        long end = System.nanoTime();
        System.out.println("Laufzeit des Programms in s: " + (end - start) / 1_000_000_000.0);
    }
}