package tag01; // Gibt an, zu welchem Package diese Klasse gehört.

public class EnumBeispiel2 { // Öffentliche Klasse mit dem Namen EnumBeispiel2.

    // Definition eines Enums mit dem Namen Farbe.
    // Dieses Enum enthält drei feste Konstanten.
    // Jede Konstante bekommt zusätzlich einen String-Wert übergeben.
    enum Farbe {
        ROT("Lieblingsfarbe"), // Konstante ROT mit der Eigenschaft "Lieblingsfarbe"
        GRUEN("Natur"),        // Konstante GRUEN mit der Eigenschaft "Natur"
        BLAU("Himmel");        // Konstante BLAU mit der Eigenschaft "Himmel"

        // Instanzattribut der jeweiligen Enum-Konstante.
        // Jede Konstante besitzt ihre eigene Eigenschaft.
        private final String eigenschaft;

        // Konstruktor des Enums.
        // Er wird automatisch beim Erzeugen jeder Enum-Konstante aufgerufen.
        // Der übergebene String wird im Attribut eigenschaft gespeichert.
        Farbe(String eigenschaft) {
            this.eigenschaft = eigenschaft;
        }

        // Getter-Methode.
        // Sie gibt die gespeicherte Eigenschaft der jeweiligen Konstante zurück.
        public String getEigenschaft() {
            return eigenschaft;
        }
    }

    // Hauptmethode: Hier beginnt die Ausführung des Programms.
    public static void main(String[] args)
    {
        // Deklaration einer Variablen vom Typ Farbe.
        // Der Variablen meineFarbe wird die Enum-Konstante BLAU zugewiesen.
        Farbe meineFarbe = Farbe.BLAU;

        // Ausgabe der Enum-Konstante auf der Konsole.
        // Es wird der Name der Konstante ausgegeben: BLAU
        System.out.println(meineFarbe);

        // Ausgabe der Eigenschaft der Konstante BLAU.
        // Über die Getter-Methode wird der gespeicherte String zurückgegeben: Himmel
        System.out.println(meineFarbe.getEigenschaft());

    }

}