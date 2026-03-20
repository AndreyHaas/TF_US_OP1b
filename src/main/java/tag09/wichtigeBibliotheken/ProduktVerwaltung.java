package tag09.wichtigeBibliotheken;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProduktVerwaltung {

    private final List<Produkt> produkte;

    public List<Produkt> getProdukte() {
        return produkte;
    }

    public ProduktVerwaltung() {
        produkte = new ArrayList<>();
    }

    public void produktHinzufuegen(Produkt produkt) {
        produkte.add(produkt);
    }

    public void alleProdukteAusgeben() {

        for (Produkt produkt : produkte) {
            System.out.println(produkt.beschreibe());
        }
    }

    public void produkteNachKategorie(String kategorie) {

        for (Produkt produkt : produkte) {
            if (produkt.getKategorie().equalsIgnoreCase(kategorie)) {
                System.out.println(produkt.beschreibe());
            }
        }

    }

    public BigDecimal gesamtpreisBerechnen() {
        BigDecimal summe = BigDecimal.ZERO;

        for (Produkt produkt : produkte) {
            summe = summe.add(produkt.getPreis());
        }

        return summe;
    }
}