package tag10;

public class Kunde {

    private String name;
    private int kundennummer;
    private String kategorie;

    public Kunde(String name, int kundennummer, String kategorie) {
        this.name = name;
        this.kundennummer = kundennummer;
        this.kategorie = kategorie;
    }

    public String getName() {
        return name;
    }

    public int getKundennummer() {
        return kundennummer;
    }

    public String getKategorie() {
        return kategorie;
    }

    public String beschreibe() {
        return name + " | Kundennummer: " + kundennummer + " | Kategorie: " + kategorie;
    }
}