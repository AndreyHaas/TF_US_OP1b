package tag03.komposition;

public class App {

  public static void main(String[] args) {
    System.out.println("*".repeat(36));
    System.out.println("=== KOMPOSITION: GEBÄUDE & RÄUME ===");
    System.out.println("*".repeat(36));

    Gebeude schule = new Gebeude("Gymnasium", 101);

    schule.addRaum(102);
    schule.addRaum(103);
    schule.addRaum(104);
    schule.addRaum(105);

    System.out.println("\nRäume im Gebäude " + schule.getName() + ": Räume: " + schule.getRaume());

    // Raum r = new Raum(5);                // Widerspricht Komposition!
    // schule.raumListe.add(r);             // Umgeht die Kontrolle!

    System.out.println("\n=== GARBAGE COLLECTOR AUFRUF ===\n");

    schule = null;

    System.gc();

    // Warten, damit finalize() sich melden kann
    try {
      Thread.sleep(1_000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("\n=== PROGRAMM ENDE ===");
  }
}