package tag03.assoziation;

public class Produkt {
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

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public Produkt(int id, double preis, String bezeichnung) {
        this.id = id;
        this.preis = preis;
        this.bezeichnung = bezeichnung;
    }


}
