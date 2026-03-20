package tag09.wichtigeBibliotheken;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KundeVerwaltung {
    List<Kunde> kunden;

    public KundeVerwaltung(List<Kunde> kunden) {
        this.kunden = new ArrayList<>(kunden);
    }

    public void setKunde(Kunde kunde) {
        kunden.add(kunde);
    }

    public List<Kunde> getKunden() {
        return kunden;
    }

    /**
     * Sortiert die Kundenliste alphabetisch nach Namen (Methode Reference)
     */
    public void sortiereNachKundennamen() {
        kunden.sort(Comparator.comparing(Kunde::getName));
    }

    /**
     * Gibt alle Kunden sortiert nach Namen aus
     */
    public void ausgegebenSortiertNachNamen() {
        sortiereNachKundennamen();
        for (Kunde kunde : kunden) {
            System.out.println(kunde);
        }
    }

    /**
     * Gibt alle Kunden sortiert nach Namen aus
     * mit eigener Comparator-Implementierung
     */
    public void sortiereNachKundennamenAlternativ() {
        kunden.sort(new Comparator<Kunde>() {
            @Override
            public int compare(Kunde k1, Kunde k2) {
                return k1.getName().compareTo(k2.getName());
            }
        });
    }

    /**
     * Gibt alle Kunden sortiert nach Namen aus
     * mit Lambda-Ausdruck
     */
    public void sortiereNachKundennamenLambda() {
        kunden.sort((k1, k2) -> k1.getName().compareTo(k2.getName()));
//        BiConsumer<Kunde, Kunde> vergleicher = (k1, k2) -> {
//            // macht etwas mit k1 und k2, gibt nichts zurück
//        };
    }

    public void alleKundenAusgeben() {
        if (kunden.isEmpty()) {
            System.out.println("Keine Kunden vorhanden.");
            return;
        }
        System.out.println("\n=== Alle Kunden ===");
        for (Kunde kunde : kunden) {
            System.out.println(kunde.toString());
        }
    }

    // Kunden nach Kategorie filtern und ausgeben
    public void kundenNachKategorieAusgeben(String kategorie) {
        List<Kunde> gefiltert = new ArrayList<>();

        for (Kunde kunde : kunden) {
            if (kunde.getKategorie().equalsIgnoreCase(kategorie)) {
                gefiltert.add(kunde);
            }
        }

        if (gefiltert.isEmpty()) {
            System.out.println("\nKeine Kunden in Kategorie '" + kategorie + "' gefunden.");
            return;
        }

        System.out.println("\n=== Kunden in Kategorie: " + kategorie + " ===");
        for (Kunde kunde : gefiltert) {
            System.out.println(kunde.toString());
        }
    }

    // Sortieren nach Kundennamen
    public void sortiereNachNamen() {
        kunden.sort(Comparator.comparing(Kunde::getName));
    }

    // Sortieren nach Kunden-ID
    public void sortiereNachId() {
        kunden.sort(Comparator.comparingLong(Kunde::getId));
    }

    // Sortierte Ausgabe nach ID
    public void ausgegebenSortiertNachId() {
        sortiereNachId();
        System.out.println("\n=== Kunden sortiert nach ID ===");
        for (Kunde kunde : kunden) {
            System.out.println(kunde.toString());
        }
    }

    // Kunde hinzufügen
    public void kundeHinzufuegen(Kunde kunde) {
        if (kunde != null) {
            kunden.add(kunde);
        }
    }
}
