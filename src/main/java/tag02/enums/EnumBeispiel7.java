package tag02.enums;

public class EnumBeispiel7 {


    // Enum mit Zusatzattribut.
    enum Farbe {
        ROT("Lieblingsfarbe"),
        GRUEN("Natur"),
        BLAU("Himmel");

        // Attribut der jeweiligen Konstante.
        private final String eigenschaft;

        // Konstruktor des Enums.
        Farbe(String eigenschaft) {
            this.eigenschaft = eigenschaft;
        }

        // Getter-Methode.
        public String getEigenschaft() {
            return eigenschaft;
        }

        // Statische Suchmethode.
        // Sie gehört zum Enum-Typ selbst und nicht zu einer einzelnen Konstante.
        public static Farbe findeNachEigenschaft(String text) {

            // Durchläuft alle Konstanten des Enums.
            for (Farbe f : Farbe.values()) {

                // Vergleicht die gespeicherte Eigenschaft mit dem übergebenen Text.
                // equalsIgnoreCase ignoriert Groß- und Kleinschreibung.
                if (f.eigenschaft.equalsIgnoreCase(text)) {
                    return f; // Gibt die passende Konstante zurück.
                }
            }

            return null; // Falls keine passende Konstante gefunden wurde.
        }
    }

    // Hauptmethode.
    public static void main(String[] args) {

        // Sucht die Farbe mit der Eigenschaft "Himmel".
        Farbe f = Farbe.findeNachEigenschaft("Himmel");

        // Gibt die gefundene Konstante aus.
        System.out.println(f);
    }
}
