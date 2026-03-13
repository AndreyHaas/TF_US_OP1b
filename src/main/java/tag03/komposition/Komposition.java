package tag03.komposition;

public class Komposition {
    static void main() {
        System.out.println("=== Komposition Gebäude-Raum Demonstration ===\n");

        System.out.println("1. Erstelle Gebäude 'Hauptgebäude' mit Raum 101:");
        Gebeude gebeude = new Gebeude("Hauptgebäude", 101);

        System.out.println("\n2. Füge weitere Räume hinzu:");
        gebeude.addRaum(102);
        gebeude.addRaum(103);
        gebeude.addRaum(104);
        gebeude.addRaum(105);

        System.out.println("\n3. Alle Räume des Gebäudes:");
        System.out.println("   " + gebeude.getRaume());

        System.out.println("\n4. Setze Gebäude-Referenz auf null und rufe GC auf:");
        gebeude = null;
        System.gc();

        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n=== Programm Ende ===");
    }
}