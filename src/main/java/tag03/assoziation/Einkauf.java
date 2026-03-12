package tag03.assoziation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Einkauf {
    // Wir speichern alle Einkäufe in einer statischen Liste, damit wir sie bequem iterieren und ausgeben können.
    protected static final List<Einkauf> EINKAUFS_LISTE = new ArrayList<>();

    private final int id;
    private final LocalDateTime datum;
    private final Person kaufer; // Der Einkauf besteht aus einem Käufer
    private final Produkt ware; // ... und einer Ware. Damit setzt sich ein Einkauf aus Person und Produkt zusammen → Aggregation!

    public int getId() {
        return id;
    }

    public LocalDateTime getDatum() {
        return datum;
    }

    public Person getKaufer() {
        return kaufer;
    }

    public Produkt getWare() {
        return ware;
    }

    public List<Einkauf> getEinkaufsListe() {
        return EINKAUFS_LISTE;
    }

    public Einkauf(int id, LocalDateTime datum, Person kaufer, Produkt ware) {
        this.id = id;
        this.datum = datum;
        this.kaufer = kaufer;
        this.ware = ware;

        EINKAUFS_LISTE.add(this);
    }

    @Override
    public String toString() {
        return String.format("Einkauf{id=%d, datum=%s, käufer=%s, ware=%s}",
            id, datum.toLocalDate(),
            kaufer.getNachname(), ware.getBezeichnung());
    }
}
