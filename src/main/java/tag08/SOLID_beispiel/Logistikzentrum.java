package tag08.SOLID_beispiel;

import java.util.ArrayList;
import java.util.List;

/**
 * Logistikzentrum - GESAMTOBJEKT in einer Komposition
 * Enthält Transportmittel (Komposition!)
 */
public class Logistikzentrum {
  private final String name;

  // ⚠️ KOMPOSITION: Transportmittel werden HIER erzeugt und gehören HIER
  private final List<Transportmittel> flotte = new ArrayList<>();

  public Logistikzentrum(String name) {
    this.name = name;
    System.out.println("🏭 Logistikzentrum '" + name + "' eröffnet");
  }

  /**
   * Komposition: Transportmittel wird INNERHALB erzeugt
   */
  public void addLKW(String kennzeichen, double kapazitaet) {
    LKW neuerLKW = new LKW(kennzeichen, kapazitaet);
    flotte.add(neuerLKW);
    System.out.println("  ➕ Neuer LKW zur Flotte: " + kennzeichen);
  }

  public void addSchiff(String name, double tonnage) {
    Schiff neuesSchiff = new Schiff(name, tonnage);
    flotte.add(neuesSchiff);
    System.out.println("  ➕ Neues Schiff zur Flotte: " + name);
  }

  public void addFlugzeug(String flugnummer, int passagiere) {
    Flugzeug neuesFlugzeug = new Flugzeug(flugnummer, passagiere);
    flotte.add(neuesFlugzeug);
    System.out.println("  ➕ Neues Flugzeug zur Flotte: " + flugnummer);
  }

  /**
   * Dependency Inversion: Hängt von Transportmittel-INTERFACE ab, nicht von konkreten Klassen!
   */
  public void auftragAusfuehren(Transportmittel transportmittel,
      String ware, int gewicht, int entfernung) {
    System.out.println("\n📦 Auftrag für " + transportmittel.getIdentifikation());

    if (!transportmittel.istEinsatzbereit()) {
      System.out.println("❌ " + transportmittel.getIdentifikation() +
          " nicht einsatzbereit! Status: " +
          transportmittel.getStatus().getAnzeigeName());
      return;
    }

    transportmittel.transportieren(ware, gewicht);
    double kosten = transportmittel.berechneKosten(entfernung);
    System.out.printf("💰 Kosten: %.2f€ für %d km%n", kosten, entfernung);
  }

  /**
   * Zeigt alle verfügbaren Transportmittel
   */
  public void zeigeFlottenStatus() {
    System.out.println("\n🚚 Flottenstatus " + name + ":");
    for (Transportmittel tm : flotte) {
      System.out.printf("  • %-20s: %s%n",
          tm.getIdentifikation(),
          tm.getStatus().getAnzeigeName());
    }
  }

  public List<Transportmittel> getFlotte() {
    return flotte;
  }
}