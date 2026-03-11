package tag02.enums;

import java.util.ArrayList;

public class EnumBeispiel9 {
    // Einfaches Enum mit drei Konstanten.
    enum Farbe {
        ROT, GRUEN, BLAU
    }

    // Hauptmethode.
    public static void main(String[] args) {

        // Erstellt eine ArrayList, die nur Werte vom Typ Farbe speichern kann.
        ArrayList<Farbe> farben = new ArrayList<>();

        // Fügt die Enum-Konstante ROT zur Liste hinzu.
        farben.add(Farbe.ROT);

        // Fügt die Enum-Konstante BLAU zur Liste hinzu.
        farben.add(Farbe.BLAU);

        // Gibt die gesamte Liste aus.
        System.out.println(farben);
    }
}
