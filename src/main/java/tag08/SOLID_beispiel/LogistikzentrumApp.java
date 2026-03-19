package tag08.SOLID_beispiel;

/**
 * Hauptprogramm - demonstriert ALLE Konzepte
 * - SOLID-Prinzipien
 * - Abstraktionen & Interfaces
 * - Enums
 * - Assoziationen
 * - Komposition
 */
public class LogistikzentrumApp {

  public static void main(String[] args) {
    System.out.println("🎯 SOLID-Prinzipien Demo - Logistiksystem");
    System.out.println("==========================================\n");

    // ===== 1. KOMPOSITION: Logistikzentrum erzeugen =====
    Logistikzentrum zentrum = new Logistikzentrum("Hauptlager Berlin");

    // Transportmittel werden INNERHALB des Zentrums erzeugt!
    zentrum.addLKW("B-LK-123", 5000);
    zentrum.addLKW("B-LK-456", 8000);
    zentrum.addSchiff("MS Europa", 20000);
    zentrum.addFlugzeug("LH-400", 300);

    // ===== 2. ASSOZIATION: Fahrer erstellen und zuweisen =====
    Fahrer klaus = new Fahrer("Klaus", "CE");
    Fahrer anna = new Fahrer("Anna", "CE");

    // LKWs aus der Flotte holen
    LKW lkw1 = (LKW) zentrum.getFlotte().get(0);
    LKW lkw2 = (LKW) zentrum.getFlotte().get(1);

    // Assoziationen herstellen
    klaus.addQualifiziertenLKW(lkw1);
    anna.addQualifiziertenLKW(lkw1);
    anna.addQualifiziertenLKW(lkw2);

    lkw1.setFahrer(klaus);

    // ===== 3. ENUM: Statusänderungen demonstrieren =====
    System.out.println("\n🔄 Statusänderungen mit ENUM:");
    lkw2.setStatus(TransportStatus.WARTUNG);

    // ===== 4. STATUS-Abfrage mit Enum-Methode =====
    System.out.println("\n🔍 Ist LKW1 verfügbar? " +
        (lkw1.istEinsatzbereit() ? "✅ Ja" : "❌ Nein"));

    // ===== 5. POLYMORPHIE: Gleicher Code, verschiedene Typen =====
    System.out.println("\n🎭 Polymorphie in Aktion:");
    for (Transportmittel tm : zentrum.getFlotte()) {
      System.out.println("  • " + tm.getIdentifikation() +
          " - Kosten pro 100km: " + tm.berechneKosten(100) + "€");
    }

    // ===== 6. AUFTRÄGE mit Dependency Inversion =====
    System.out.println("\n📋 Auftragsabwicklung (Dependency Inversion):");

    zentrum.auftragAusfuehren(lkw1, "Baumaterial", 3000, 250);

    // Fahrer fährt LKW (Assoziation)
    klaus.fahre(lkw1, "München");

    zentrum.auftragAusfuehren(zentrum.getFlotte().get(2), "Container", 15000, 800);
    zentrum.auftragAusfuehren(zentrum.getFlotte().get(3), "Express-Pakete", 500, 600);

    // ===== 7. NICHT-EINSATZBEREITES Transportmittel =====
    System.out.println("\n⚠️ Test mit nicht verfügbarem Transportmittel:");
    zentrum.auftragAusfuehren(lkw2, "Möbel", 2000, 150);

    // ===== 8. FLOTTENSTATUS anzeigen =====
    zentrum.zeigeFlottenStatus();

    // ===== 9. Open/Closed Prinzip demonstrieren =====
    System.out.println("\n🔓  Open/Closed Prinzip:");
    System.out.println("      Neues Transportmittel könnte leicht hinzugefügt werden,");
    System.out.println("      ohne bestehenden Code zu ändern!");
  }
}