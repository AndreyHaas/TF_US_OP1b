package tag03.assoziation;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class Produkt {
    protected static final List<Produkt> PRODUKT_LISTE = new ArrayList<>();
    private final int id;
    private double preis;
    private String bezeichnung;

    public int getId() {
        return id;
    }

    public double getPreis() {
        return preis;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public List<Produkt> getProductListe() {
        return PRODUKT_LISTE;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public void setProduktListe(Produkt produkt){
        if (!PRODUKT_LISTE.contains(produkt)){
            PRODUKT_LISTE.add(produkt);
        }
    }

    public Produkt(int id, double preis, String bezeichnung) {
        this.id = id;
        this.preis = preis;
        this.bezeichnung = bezeichnung;
        // Automatisch in statische Liste eintragen
        PRODUKT_LISTE.add(this);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Produkt.class.getSimpleName() + "[", "]")
            .add("id=" + id)
            .add("preis=" + preis)
            .add("bezeichnung='" + Objects.requireNonNullElse(bezeichnung, "keine bezeichnung") + "'")
            .toString();
    }
}