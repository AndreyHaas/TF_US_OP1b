package tag03.assoziation;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringJoiner;

public class Einkauf {

  // Wir speichern alle Einkäufe in einer statischen Liste, damit wir sie bequem iterieren und ausgeben können.
  protected static final List<Einkauf> EINKAUFS_LISTE = new ArrayList<>();

  private final int id;
  private final String datum;
  private final Person kaufer; // Der Einkauf besteht aus einem Käufer
  private final Produkt ware; // ... und einer Ware. Damit setzt sich ein Einkauf aus Person und Produkt zusammen → Aggregation!

  public int getId() {
    return id;
  }

  public String getDatum() {
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

  public Einkauf(int id, Person kaufer, Produkt ware) {
    this.id = id;
    this.datum = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    this.kaufer = kaufer;
    this.ware = ware;

    EINKAUFS_LISTE.add(this);
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Einkauf.class.getSimpleName() + "[", "]")
        .add("id=" + id)
        .add("datum=" + (datum != null ? datum : "keine"))
        .add("kaufer=" + (kaufer != null ? kaufer : "keine"))
        .add("ware=" + (ware != null ? ware : "keine"))
        .toString();
  }
}
