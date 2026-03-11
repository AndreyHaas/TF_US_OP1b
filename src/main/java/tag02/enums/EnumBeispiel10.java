package tag02.enums;

public class EnumBeispiel10 {
    // Einfaches Enum mit drei Farben.
    enum Farbe {
        ROT, GRUEN, BLAU
    }

    // Methode mit Enum als Rückgabewert.
    // Die Methode gibt eine Konstante vom Typ Farbe zurück.
    public static Farbe gibStandardfarbe() {
        return Farbe.GRUEN; // Rückgabe der Standardfarbe.
    }

    // Hauptmethode.
    public static void main(String[] args) {

        // Speichert den Rückgabewert der Methode in einer Variablen vom Typ Farbe.
        Farbe f = gibStandardfarbe();

        // Gibt die zurückgegebene Enum-Konstante aus.
        System.out.println(f);
    }
}
