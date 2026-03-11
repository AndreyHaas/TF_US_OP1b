package tag02.enums; // Gibt an, zu welchem Package diese Klasse gehört.

public class EnumBeispiel { // Öffentliche Klasse mit dem Namen EnumBeispiel.

    // Definition eines Enums mit dem Namen Farbe.
    // Ein Enum ist ein eigener Datentyp mit einer festen Menge an Konstanten.
    enum Farbe {
        ROT,    // Enum-Konstante ROT
        GRUEN,  // Enum-Konstante GRUEN
        BLAU    // Enum-Konstante BLAU
    }

    // Hauptmethode: Hier startet das Java-Programm.
    public static void main(String[] args)
    {
        // Deklaration einer Variable vom Enum-Typ Farbe.
        // Der Variablen meineFarbe wird die Enum-Konstante BLAU zugewiesen.
        Farbe meineFarbe = Farbe.BLAU;

        // Ausgabe der Variablen auf der Konsole.
        // Da meineFarbe die Konstante BLAU enthält, wird "BLAU" ausgegeben.
        System.out.println(meineFarbe);
    }

}