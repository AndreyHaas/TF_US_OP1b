package tag01;

public class EnumBeispiel3 {
    // Definition eines Enums mit dem Namen Farbe.
    // Jede Konstante bekommt zusätzlich einen String-Wert.
    enum Farbe {
        ROT("Lieblingsfarbe"), // Konstante ROT mit der Eigenschaft "Lieblingsfarbe"
        GRUEN("Natur"),        // Konstante GRUEN mit der Eigenschaft "Natur"
        BLAU("Himmel");        // Konstante BLAU mit der Eigenschaft "Himmel"

        // Attribut der jeweiligen Enum-Konstante.
        // Jede Konstante besitzt ihre eigene Eigenschaft.
        private final String eigenschaft;

        // Konstruktor des Enums.
        // Er wird automatisch beim Erzeugen jeder Konstante aufgerufen.
        Farbe(String eigenschaft) {
            this.eigenschaft = eigenschaft; // Übergabewert wird im Attribut gespeichert.
        }

        // Getter-Methode zum Zurückgeben der Eigenschaft.
        public String getEigenschaft() {
            return eigenschaft;
        }

        // Eigene Methode innerhalb des Enums.
        // Sie gibt den Namen der Konstante und ihre Eigenschaft aus.
        public void info() {
            System.out.println(this.name() + " steht fuer " + eigenschaft);
        }
    }

    // Hauptmethode: Startpunkt des Programms.
    public static void main(String[] args) {
        // Direkter Aufruf der Methode info() auf der Enum-Konstante BLAU.
        Farbe.BLAU.info();
    }
}
