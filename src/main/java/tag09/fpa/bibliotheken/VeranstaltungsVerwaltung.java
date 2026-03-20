package tag09.fpa.bibliotheken;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class VeranstaltungsVerwaltung {

    private final List<Veranstaltung> veranstaltungen;

    public VeranstaltungsVerwaltung() {
        this.veranstaltungen = new ArrayList<>();
    }

    /**
     * Sortiert Veranstaltungen alphabetisch nach Titel
     * Verwendung von List.sort() mit Comparator una Lambda
     */
    public void sortiereNachTitel() {
        veranstaltungen.sort((v1, v2) -> v1.getTitel().compareTo(v2.getTitel()));
    }

    /**
     * Fügt eine Veranstaltung zur Verwaltung hinzu
     */
    public void veranstaltungHinzufuegen(Veranstaltung veranstaltung) {
        if (veranstaltung != null) {
            veranstaltungen.add(veranstaltung);
        }
    }

    /**
     * Gibt alle Veranstaltungen aus
     * Verwendung von for-each-Schleife
     */
    public void alleVeranstaltungenAusgeben() {
        if (veranstaltungen.isEmpty()) {
            System.out.println("Keine Veranstaltungen vorhanden.");
            return;
        }

        System.out.println("\n=== Alle Veranstaltungen ===");
        for (Veranstaltung v : veranstaltungen) {
            System.out.println(v.beschreibe());
        }
    }

    /**
     * Gibt alle Veranstaltungen als Liste zurück
     */
    public List<Veranstaltung> getAlleVeranstaltungen() {
        return veranstaltungen;
    }

    /**
     * Filtert Veranstaltungen nach Kategorie
     * Verwendung von Schleife und String-Vergleich
     */
    public List<Veranstaltung> veranstaltungenNachKategorie(String kategorie) {
        List<Veranstaltung> gefiltert = new ArrayList<>();

        for (Veranstaltung v : veranstaltungen) {
            if (v.getKategorie().equalsIgnoreCase(kategorie)) {
                gefiltert.add(v);
            }
        }

        return gefiltert;
    }

    /**
     * Sammelt alle Kategorien als Set (keine Duplikate)
     * Verwendung von HashSet
     */
    public Set<String> getAlleKategorien() {
        Set<String> kategorien = new HashSet<>();

        for (Veranstaltung v : veranstaltungen) {
            kategorien.add(v.getKategorie());
        }

        return kategorien;
    }

    /**
     * Sortiert Veranstaltungen nach Preis (aufsteigend)
     * Verwendung von Comparator.comparing() für kompakte Schreibweise
     */
    public void sortiereNachPreis() {
        veranstaltungen.sort(Comparator.comparing(Veranstaltung::getPreis));
    }

    /**
     * Sortiert Veranstaltungen nach Preis (absteigend)
     */
    public void sortiereNachPreisAbsteigend() {
        veranstaltungen.sort(Comparator.comparing(Veranstaltung::getPreis).reversed());
    }

    /**
     * Sortiert Veranstaltungen nach Datum (chronologisch)
     */
    public void sortiereNachDatum() {
        veranstaltungen.sort(Comparator.comparing(Veranstaltung::getDatum));
    }

    /**
     * Sortiert Veranstaltungen nach Kategorie und dann nach Titel
     * mehrstufige Sortierung mit thenComparing()
     */
    public void sortiereNachKategorieDannTitel() {
        veranstaltungen.sort(Comparator
                .comparing(Veranstaltung::getKategorie)
                .thenComparing(Veranstaltung::getTitel));
    }

    /**
     * Berechnet die Summe aller Ticketpreise (wenn pro Veranstaltung 1 Ticket)
     * Verwendung von BigDecimal für genaue Summe
     */
    public BigDecimal gesamtpreisBerechnen() {
        BigDecimal summe = BigDecimal.ZERO;

        for (Veranstaltung v : veranstaltungen) {
            summe = summe.add(v.getPreis());
        }

        return summe;
    }

    /**
     * Erstellt eine Map: Kategorie -> Liste der Veranstaltungen in dieser Kategorie
     * Verwendung von HashMap
     */
    public Map<String, List<Veranstaltung>> gruppiereNachKategorie() {
        Map<String, List<Veranstaltung>> kategorieMap = new HashMap<>();

        for (Veranstaltung v : veranstaltungen) {
            String kategorie = v.getKategorie();

            // Wenn die Kategorie noch nicht in der Map ist, neue Liste anlegen
            if (!kategorieMap.containsKey(kategorie)) {
                kategorieMap.put(kategorie, new ArrayList<>());
            }

            // Veranstaltung zur Liste der Kategorie hinzufügen
            kategorieMap.get(kategorie).add(v);
        }

        return kategorieMap;
    }

    /**
     * Sortiert mit eigener Comparator-Implementierung (als Lambda)
     * sortiert nach Datum, zukünftige zuerst
     */
    public void sortiereNachNaechsterVeranstaltung() {
        veranstaltungen.sort((v1, v2) -> {
            LocalDate heute = LocalDate.now();
            boolean v1Vergangen = v1.getDatum().isBefore(heute);
            boolean v2Vergangen = v2.getDatum().isBefore(heute);

            // Vergangene Veranstaltungen ans Ende
            if (v1Vergangen && !v2Vergangen) {
                return 1;
            }
            if (!v1Vergangen && v2Vergangen) {
                return -1;
            }

            // Ansonsten nach Datum sortieren
            return v1.getDatum().compareTo(v2.getDatum());
        });
    }

    /**
     * Gibt sortierte Veranstaltungen aus
     */
    public void ausgegebenSortiert(String kriterium) {
        switch (kriterium.toLowerCase()) {
            case "titel":
                sortiereNachTitel();
                break;
            case "preis":
                sortiereNachPreis();
                break;
            case "preisab":
                sortiereNachPreisAbsteigend();
                break;
            case "datum":
                sortiereNachDatum();
                break;
            case "kategorie":
                sortiereNachKategorieDannTitel();
                break;
            default:
                System.out.println("Unbekanntes Sortierkriterium");
                return;
        }

        System.out.println("\n=== Sortiert nach " + kriterium + " ===");
        for (Veranstaltung v : veranstaltungen) {
            System.out.println(v.beschreibe());
        }
    }
}