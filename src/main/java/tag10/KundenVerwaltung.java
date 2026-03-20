package tag10;

import java.util.ArrayList;
import java.util.List;

public class KundenVerwaltung {

    private List<Kunde> kunden;

    public KundenVerwaltung() {
        kunden = new ArrayList<>();
    }

    public void kundeHinzufuegen(Kunde kunde) {
        kunden.add(kunde);
    }

    public List<Kunde> getKunden() {
        return kunden;
    }

    public void alleKundenAusgeben() {
        for (Kunde kunde : kunden) {
            System.out.println(kunde.beschreibe());
        }
    }

    public void kundenNachKategorie(String kategorie) {
        for (Kunde kunde : kunden) {
            if (kunde.getKategorie().equalsIgnoreCase(kategorie)) {
                System.out.println(kunde.beschreibe());
            }
        }
    }
}