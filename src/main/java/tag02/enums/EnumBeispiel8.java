package tag02.enums;

public class EnumBeispiel8 {
    // Einfaches Enum mit drei Konstanten.
    enum Farbe {
        ROT, GRUEN, BLAU
    }

    // Hauptmethode.
    public static void main(String[] args) {

        // name() liefert den Namen der Enum-Konstante als String.
        System.out.println(Farbe.BLAU.name());

        // ordinal() liefert die Position der Konstante.
        // Die Zählung beginnt bei 0:
        // ROT = 0, GRUEN = 1, BLAU = 2
        System.out.println(Farbe.BLAU.ordinal());
    }
}
