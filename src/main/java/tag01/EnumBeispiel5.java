package tag01; // Gibt an, in welchem Package sich die Klasse befindet.

public class EnumBeispiel5 { // Öffentliche Klasse mit dem Namen EnumBeispiel5.

    // Definition eines einfachen Enums mit drei festen Konstanten.
    // Farbe ist ein eigener Datentyp.
    enum Farbe {
        ROT,    // Erste Enum-Konstante
        GRUEN,  // Zweite Enum-Konstante
        BLAU    // Dritte Enum-Konstante
    }

    // Hauptmethode: Hier startet das Programm.
    public static void main(String[] args) {

        // values() liefert ein Array mit allen Konstanten des Enums Farbe.
        // Dieses Array wird in der Variablen farben gespeichert.
        Farbe[] farben = Farbe.values();

        // Klassische for-Schleife über das Array farben.
        // i ist der Index und läuft von 0 bis zur letzten Position im Array.
        for (int i = 0; i < farben.length; i++) {

            // Gibt das jeweilige Element des Arrays aus.
            // Also nacheinander: ROT, GRUEN, BLAU
            System.out.println(farben[i]);
        }

        // Zweite Möglichkeit:
        // Hier wird nicht zuerst eine Array-Variable gespeichert,
        // sondern values() wird direkt in der Schleife verwendet.
        for (int i = 0; i < Farbe.values().length; i++)
        {
            // Gibt das Element an der Position i direkt aus dem Array zurück,
            // das von values() geliefert wird.
            System.out.println(Farbe.values()[i]);
        }

        // Dritte Möglichkeit:
        // values() liefert ein Array mit allen Enum-Konstanten.
        // Mit der for-each-Schleife wird direkt über alle Konstanten iteriert.
        for (Farbe f : Farbe.values()) {

            // Gibt die aktuelle Enum-Konstante aus.
            // Ausgabe: ROT, GRUEN, BLAU
            System.out.println(f);
        }
    }
}