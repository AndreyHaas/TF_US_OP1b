package tag02.enums;

public class EnumBeispiel4 {
    // Einfaches Enum mit drei Konstanten.
    enum Farbe {
        ROT, GRUEN, BLAU
    }

    // Methode mit einem Enum als Parameter.
    // Je nach übergebener Konstante wird etwas anderes ausgegeben.
    public static void ausgabe(Farbe farbe) {
        switch (farbe) { // switch verzweigt je nach Enum-Konstante.
            case ROT:
                System.out.println("Stopp");
                break; // Beendet den jeweiligen case.

            case GRUEN:
                System.out.println("Gehen");
                break;

            case BLAU:
                System.out.println("Keine Ampelfarbe, nur Beispiel");
                break;
        }
    }

    // Hauptmethode.
    public static void main(String[] args) {
        // Übergibt die Enum-Konstante ROT an die Methode.
        ausgabe(Farbe.ROT);
    }
}
