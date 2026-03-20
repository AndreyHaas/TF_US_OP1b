package tag09.fpa.bibliotheken;


import org.jetbrains.annotations.NotNull;
import tag09.wichtigeBibliotheken.Kunde;
import tag09.wichtigeBibliotheken.KundeVerwaltung;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Hauptklasse, die das Zusammenspiel aller Bibliotheken demonstriert
 */
public class Main {

    public static final String WORKSHOP = "Workshop";

    public static void main(String[] args) {
        // 1. Erstellen von Veranstaltungen mit verschiedenen Bibliotheken
        // java.time.LocalDate
        LocalDate date1 = LocalDate.of(2024, 12, 15);
        LocalDate date2 = LocalDate.of(2024, 11, 20);
        LocalDate date3 = LocalDate.of(2025, 1, 10);
        LocalDate date4 = LocalDate.of(2024, 12, 5);

        // java.math.BigDecimal für präzise Preise
        Veranstaltung v1 = new Veranstaltung("Java Konferenz", new BigDecimal("299.99"), "Konferenz", date1);
        Veranstaltung v2 = new Veranstaltung("Spring Boot", new BigDecimal("199.50"), WORKSHOP, date2);
        Veranstaltung v3 = new Veranstaltung("DevOps Tage", new BigDecimal("249.00"), "Konferenz", date3);
        Veranstaltung v4 = new Veranstaltung("Coding POJO", new BigDecimal("49.90"), WORKSHOP, date4);

        // 2. Verwaltung mit java.util.Collections
        VeranstaltungsVerwaltung verwaltung = new VeranstaltungsVerwaltung();
        verwaltung.veranstaltungHinzufuegen(v1);
        verwaltung.veranstaltungHinzufuegen(v2);
        verwaltung.veranstaltungHinzufuegen(v3);
        verwaltung.veranstaltungHinzufuegen(v4);

        // 3. Ausgabe aller Veranstaltungen
        System.out.println("=== Alle Veranstaltungen ===");
        verwaltung.alleVeranstaltungenAusgeben();

        // 4. java.time: Datumsformatierung und Zeitberechnung
        System.out.println("\n=== Datumsinformationen ===");
        for (Veranstaltung veranstaltung : verwaltung.getAlleVeranstaltungen()) {
            System.out.println(veranstaltung.getTitel() + ": " + veranstaltung.getVerbleibendeZeit());
        }

        // 5. java.util: Filtern nach Kategorie
        System.out.println("\n=== Filter: Workshops ===");
        List<Veranstaltung> workshops = verwaltung.veranstaltungenNachKategorie(WORKSHOP);
        for (Veranstaltung veranstaltung : workshops) {
            System.out.println(veranstaltung.beschreibe());
        }

        // 6. java.util.Set: Eindeutige Kategorien
        System.out.println("\n=== Eindeutige Kategorien (Set) ===");
        Set<String> kategorien = verwaltung.getAlleKategorien();
        for (String kategorie : kategorien) {
            System.out.println("- " + kategorie);
        }

        // 7. java.util.Map: Gruppierung nach Kategorie
        System.out.println("\n=== Gruppierung nach Kategorie (Map) ===");
        Map<String, List<Veranstaltung>> gruppiert = verwaltung.gruppiereNachKategorie();
        for (Map.Entry<String, List<Veranstaltung>> entry : gruppiert.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().size() + " Veranstaltung(en)");
        }

        // 8. java.math.BigDecimal: Preisberechnungen
        System.out.println("\n=== Preisberechnungen ===");
        BigDecimal gesamt = verwaltung.gesamtpreisBerechnen();
        System.out.println("Gesamtpreis aller Veranstaltungen: " + gesamt + " €");

        // 9. Sortieren mit Comparator
        System.out.println("\n=== Sortiert nach Preis (absteigend) ===");
        verwaltung.sortiereNachPreisAbsteigend();
        verwaltung.alleVeranstaltungenAusgeben();

        // 10. java.lang: String-Verarbeitung
        System.out.println("\n=== String-Verarbeitung ===");
        String suche = "java";
        System.out.println("Suche nach Veranstaltungen mit '" + suche + "' im Titel:");
        for (Veranstaltung veranstaltung : verwaltung.getAlleVeranstaltungen()) {
            if (veranstaltung.getTitel().toLowerCase().contains(suche.toLowerCase())) {
                System.out.println("  - " + veranstaltung.getTitel());
            }
        }

        // 11. java.lang.Math: Rabattberechnung
        System.out.println("\n=== Rabattberechnung ===");
        int anzahlTickets = 25;
        BigDecimal rabattPreis = v1.berechneRabattPreis(anzahlTickets);
        System.out.println("Originalpreis: " + v1.getPreis() + " €");
        System.out.println("Rabattpreis für " + anzahlTickets + " Tickets: " + rabattPreis + " €");

        // 12. java.time.DateTimeFormatter: Formatierte Ausgabe
        System.out.println("\n=== Formatierte Datumsausgabe ===");
        for (Veranstaltung v : verwaltung.getAlleVeranstaltungen()) {
            System.out.println(v.getTitel() + ": " + v.getDatum().format(getGermanFormatter()));
        }

        //13. Klasse Kundenverwaltung, Kunde, Sortieren nach Kundennamen in der main-Methode
        // Kundenverwaltung erstellen
        KundeVerwaltung kundeVerwaltung = new KundeVerwaltung(new ArrayList<>());

        // Kunden mit verschiedenen Kategorien erstellen
        Kunde kunde1 = new Kunde(1001, "Anna Schmidt", "Economy");
        Kunde kunde2 = new Kunde(1002, "Thomas Weber", "Business");
        Kunde kunde3 = new Kunde(1003, "Maria Fischer", "Economy");
        Kunde kunde4 = new Kunde(1004, "Dr. Klaus Richter", "Business");
        Kunde kunde5 = new Kunde(1005, "Lisa Hoffmann", "Economy");
        Kunde kunde6 = new Kunde(1006, "Christian Bauer", "Premium");

        // Kunden zur Verwaltung hinzufügen
        kundeVerwaltung.kundeHinzufuegen(kunde1);
        kundeVerwaltung.kundeHinzufuegen(kunde2);
        kundeVerwaltung.kundeHinzufuegen(kunde3);
        kundeVerwaltung.kundeHinzufuegen(kunde4);
        kundeVerwaltung.kundeHinzufuegen(kunde5);
        kundeVerwaltung.kundeHinzufuegen(kunde6);

        // 1. Alle Kunden ausgeben
        kundeVerwaltung.alleKundenAusgeben();

        // 2. Gefilterte Ausgabe nach Kategorie "Business"
        kundeVerwaltung.kundenNachKategorieAusgeben("Business");

        // 3. Gefilterte Ausgabe nach Kategorie "Economy"
        kundeVerwaltung.kundenNachKategorieAusgeben("Economy");

        // 4. Gefilterte Ausgabe nach nicht vorhandener Kategorie
        kundeVerwaltung.kundenNachKategorieAusgeben("Gold");

        // 5. Sortieren nach Kundennamen
        System.out.println("\n" + "=".repeat(50));
        kundeVerwaltung.sortiereNachNamen();
        kundeVerwaltung.alleKundenAusgeben();

        // 6. Sortieren nach Kundennummer (ID)
        kundeVerwaltung.sortiereNachId();
        kundeVerwaltung.alleKundenAusgeben();

        // Alternative: Ausgabe mit sortierten Methoden
        System.out.println("\n" + "=".repeat(50));
        kundeVerwaltung.ausgegebenSortiertNachNamen();
        kundeVerwaltung.ausgegebenSortiertNachId();
    }

    private static @NotNull DateTimeFormatter getGermanFormatter() {
        return DateTimeFormatter.ofPattern("EEEE, dd. MMMM yyyy", Locale.GERMAN);
    }
}