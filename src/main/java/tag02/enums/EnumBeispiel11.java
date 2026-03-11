package tag02.enums;

public class EnumBeispiel11 {

    // Enum mit Zusatzattribut.
    enum Farbe {
        ROT("Lieblingsfarbe"),
        GRUEN("Natur"),
        BLAU("Himmel");

        // Attribut jeder einzelnen Enum-Konstante.
        private final String eigenschaft;

        // Konstruktor des Enums.
        Farbe(String eigenschaft) {
            this.eigenschaft = eigenschaft;
        }

        // Getter-Methode.
        public String getEigenschaft() {
            return eigenschaft;
        }
    }

    // Hauptmethode.
    public static void main(String[] args) {

        // Durchläuft alle Enum-Konstanten des Typs Farbe.
        for (Farbe f : Farbe.values()) {

            // name() gibt den Namen der Konstante zurück.
            System.out.println("Name: " + f.name());

            // ordinal() gibt die Position der Konstante zurück.
            System.out.println("Position: " + f.ordinal());

            // getEigenschaft() gibt das gespeicherte Attribut zurück.
            System.out.println("Eigenschaft: " + f.getEigenschaft());

            // Leerzeile zur besseren Lesbarkeit der Ausgabe.
            System.out.println();
        }
    }
}
