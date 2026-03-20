package tag09.wichtigeBibliotheken;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Produkt {

    private String name;
    private BigDecimal preis;
    private String kategorie;
    private LocalDate haltbarBis;

    public Produkt(String name, BigDecimal preis, String kategorie, LocalDate haltbarBis) {
        this.name = name;
        this.preis = preis;
        this.kategorie = kategorie;
        this.haltbarBis = haltbarBis;
    }

    public String beschreibe() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(": ");
        sb.append(name);
        sb.append(" | ");
        sb.append(preis);
        sb.append(" EUR | ");
        sb.append(kategorie);
        sb.append(" | halbar bis: ");
        sb.append(haltbarBis.format(formatDateDE()));
        return sb.toString();
    }

    public DateTimeFormatter formatDateDE() {
        return DateTimeFormatter.ofPattern("EEEE, dd.MM.yyyy", Locale.GERMAN);
    }

    public DateTimeFormatter formatDateEU() {
        return DateTimeFormatter.ofPattern("dd.MM.yyyy");
    }

    public DateTimeFormatter formatDateUS() {
        return DateTimeFormatter.ofPattern("MM/dd/yyyy");
    }

    public DateTimeFormatter formatDateUSFull() {
        return DateTimeFormatter.ofPattern("MMMM dd, yyyy");
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPreis() {
        return preis;
    }

    public String getKategorie() {
        return kategorie;
    }

    public LocalDate getHaltbarBis() {
        return haltbarBis;
    }
}