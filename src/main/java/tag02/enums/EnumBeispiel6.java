package tag02.enums;

public class EnumBeispiel6 {
    // Enum mit zwei Attributen pro Konstante.
    enum Farbe {
        ROT("Lieblingsfarbe", 1), // ROT hat die Eigenschaft "Lieblingsfarbe" und die Nummer 1
        GRUEN("Natur", 2),        // GRUEN hat die Eigenschaft "Natur" und die Nummer 2
        BLAU("Himmel", 3);        // BLAU hat die Eigenschaft "Himmel" und die Nummer 3

        // Erstes Attribut: speichert eine Eigenschaft als Text.
        private final String eigenschaft;

        // Zweites Attribut: speichert eine Nummer.
        private final int nummer;

        // Konstruktor des Enums mit zwei Parametern.
        Farbe(String eigenschaft, int nummer) {
            this.eigenschaft = eigenschaft; // Speichert den Textwert.
            this.nummer = nummer;           // Speichert den Zahlenwert.
        }

        // Getter für die Eigenschaft.
        public String getEigenschaft() {
            return eigenschaft;
        }

        // Getter für die Nummer.
        public int getNummer() {
            return nummer;
        }
    }

    // Hauptmethode.
    public static void main(String[] args) {
        // Gibt die Eigenschaft der Konstante GRUEN aus.
        System.out.println(Farbe.GRUEN.getEigenschaft());

        // Gibt die Nummer der Konstante GRUEN aus.
        System.out.println(Farbe.GRUEN.getNummer());
    }
}
