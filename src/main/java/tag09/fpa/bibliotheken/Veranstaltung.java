package tag09.fpa.bibliotheken;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Veranstaltung {

    private final String titel;
    private BigDecimal preis;
    private final String kategorie;
    private final LocalDate datum;

    public Veranstaltung(String titel, BigDecimal preis, String kategorie, LocalDate datum) {
        this.titel = titel;
        this.preis = preisAbrufen(preis);
        this.kategorie = kategorie;
        this.datum = datum;
    }

    public Veranstaltung(String titel, BigDecimal preis, String kategorie) {
        this.titel = titel;
        this.preis = preisAbrufen(preis);
        this.kategorie = kategorie;
        this.datum = LocalDate.now();
    }

    public String getTitel() {
        return titel;
    }

    public BigDecimal getPreis() {
        return preis;
    }

    public String getKategorie() {
        return kategorie;
    }

    public LocalDate getDatum() {
        return datum;
    }

    private static @NotNull BigDecimal preisAbrufen(BigDecimal preis) {
        return Objects.requireNonNullElse(preis, BigDecimal.ZERO).setScale(2, RoundingMode.HALF_UP);
    }

    /**
     * Berechnet den Gesamtpreis für eine bestimmte Anzahl von Tickets
     * Verwendung von multiply()
     */
    public BigDecimal berechneGesamtpreis(int anzahlTickets) {
        BigDecimal anzahl = new BigDecimal(anzahlTickets);
        return preis.multiply(anzahl);
    }

    /**
     * Berechnet den Preis mit Rabatt
     * Verwendung von multiply(), subtract() und divide()
     *
     * @param anzahlTickets wie viel Tickets hat Kunde
     */
    public BigDecimal berechneRabattPreis(int anzahlTickets) {
        BigDecimal rabattProzent = BigDecimal.ZERO;

        if (anzahlTickets >= 50) {
            rabattProzent = new BigDecimal("20");
        } else if (anzahlTickets >= 20) {
            rabattProzent = new BigDecimal("10");
        } else if (anzahlTickets >= 10) {
            rabattProzent = new BigDecimal("5");
        }

        // Rabatt = Preis * (RabattProzent / 100)
        BigDecimal hundert = new BigDecimal("100");
        BigDecimal rabattFaktor = rabattProzent.divide(hundert, 4, RoundingMode.HALF_UP);
        BigDecimal rabattBetrag = preis.multiply(rabattFaktor);

        // Preis nach Rabatt = Preis - Rabatt
        BigDecimal preisNachRabatt = preis.subtract(rabattBetrag);

        // Auf 2 Nachkommastellen runden
        return preisNachRabatt.setScale(2, RoundingMode.HALF_UP);
    }

    /**
     * Berechnet den Endpreis inklusive Mehrwertsteuer
     * Verwendung von add() und multiply()
     */
    public BigDecimal berechneBruttopreis() {
        BigDecimal mwstSatz = new BigDecimal("0.19"); // 19% MwSt
        BigDecimal mwstBetrag = preis.multiply(mwstSatz);
        return preis.add(mwstBetrag).setScale(2, RoundingMode.HALF_UP);
    }

    /**
     * Erhöht den Preis um einen bestimmten Prozentsatz (z.B. Preisanpassung)
     *
     * @param prozent Wert von % der Preis erhöht
     */
    public void erhoehePreisUmProzent(int prozent) {
        BigDecimal prozentFaktor = new BigDecimal(prozent);
        BigDecimal hundert = new BigDecimal("100");
        BigDecimal erhoehung = preis.multiply(prozentFaktor.divide(hundert, 4, RoundingMode.HALF_UP));
        this.preis = preis.add(erhoehung).setScale(2, RoundingMode.HALF_UP);
    }

    /**
     * Berechnet, wie lange es noch bis zur Veranstaltung dauert
     * Verwendung von LocalDate.now() und Period.between()
     */
    public String getVerbleibendeZeit() {
        LocalDate heute = LocalDate.now();

        if (datum.isBefore(heute)) {
            return "Die Veranstaltung hat bereits stattgefunden.";
        }

        if (datum.equals(heute)) {
            return "Die Veranstaltung findet heute statt!";
        }

        Period periode = Period.between(heute, datum);
        long tage = periode.getDays();
        long monate = periode.getMonths();
        long jahre = periode.getYears();

        if (jahre > 0) {
            return "Noch " + jahre + " Jahr(e), " + monate + " Monat(e) und " + tage + " Tag(e)";
        } else if (monate > 0) {
            return "Noch " + monate + " Monat(e) und " + tage + " Tag(e)";
        } else {
            return "Noch " + tage + " Tag(e)";
        }
    }

    /**
     * Gibt das Datum im Format TT.MM.JJJJ zurück
     * Verwendung von DateTimeFormatter
     */
    public String getFormatiertesDatum() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return datum.format(formatter);
    }

    /**
     * Vergleicht zwei Preise miteinander
     * compareTo() ist die korrekte Methode für BigDecimal-Vergleiche
     *
     * @param andere - ein Link zu einer Veranstaltung
     */
    public boolean istTeurerAls(Veranstaltung andere) {
        boolean istTeurerAls = false;
        if (andere != null) {
            istTeurerAls = this.preis.compareTo(andere.getPreis()) > 0;
        }

        return istTeurerAls;
    }

    public String beschreibe() {
        return titel + " (" + kategorie + ") - " + preis + " € - " + getFormatiertesDatum();
    }
}