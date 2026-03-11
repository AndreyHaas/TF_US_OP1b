package tag01.aufgaben;

/*
 * Typsichere Aufzählungen können als spezielle Art von Klassen mit dem Schlüsselwort "enum" realisiert werden.
 */

import java.util.ArrayList;
import java.util.Arrays;

public class Enumerationen
{
    // Erstes Enum:
    // Mit einem Enum können wir wichtige Konstanten in unserem Programm zusammenfassen.
    enum Ampelfarbe
    {
        // Konstanten werden großgeschrieben.
        ROT, GELB, GRÜN
    }

    /**
     * Macht eine Ausgabe passend zur übergebenen Enum-Konstante.
     */
    static void info(Ampelfarbe farbe) // Enums können als Parameter für Methoden verwendet werden.
    {
        switch (farbe)
        {
            case ROT:
                // ordinal() gibt den standardmäßig vergebenen Zahlenwert der Konstante zurück. Diese beginnt bei 0.
                System.out.println(farbe.ordinal() + ": Anhalten");
                break;
            case GELB:
                System.out.println(farbe.ordinal() + ": Achtung");
                break;
            case GRÜN:
                System.out.println(farbe.ordinal() + ": Weiterfahren");
                break;
        }
    }

    // Enums funktionieren ähnlich wie Klassen. Wir können in ihnen Attribute und Methoden definieren.
    enum Fehlercode
    {
        ILLEGAL_ARGUMENT(123), OUT_OF_BOUNDS(456), NULL_REFERENCE(789), NUMBER_FORMAT(147);
        // Ähnlich wie bei dem Erzeugen von Objekten können bei dem Erzeugen der Konstanten Argumente übergeben werden.
        // Diese Argumente stellen den Wert der Konstante dar.

        // Ein Feld, das den Wert der Konstante speichert.
        private final int code; // "final" heißt, dass der Wert nicht mehr verändert werden kann.

        public int getCode() // "code" ist "private". Um den Wert trotzdem abfragen zu können, brauchen wir eine öffentliche Methode.
        {
            return code;
        }

        // Ein Konstruktor, der beim Erzeugen der Konstanten aufgerufen wird und der Variable den übergebenen Wert zuweist.
        private Fehlercode(int code)
        {
            this.code = code; // "this" ist hier wichtig, da die Variable für den Wert und der Parameter des Konstruktors gleich heißen.
        }

        /**
         * Macht aus einem übergebenen Integer eine Enum-Konstante, wenn möglich.
         * @param code
         * @return Die Enum-Konstante, wenn es eine passende zu dem übergebenen Code gibt, sonst null.
         */
        public static Fehlercode valueOf(int code)
        {
            Fehlercode[] codes = Fehlercode.values(); // values() gibt uns ein Array mit den Konstanten.
            for (Fehlercode f : codes)
            {
                if (f.code == code) // Wenn eine Konstante den Wert hat, der dieser Methode übergeben wurde,
                    return f; // dann geben wir diese Konstante zurück.
            }
            return null; // Sonst geben wir null zurück.
        }
    }


    public static void main(String[] args)
    {
        // Aus dem Enum können wir eine Variable erzeugen und ihr eine Konstante zuweisen.
        Ampelfarbe farbe = Ampelfarbe.ROT;

        info(farbe); // Variable an die Methode übergeben.

        info(Ampelfarbe.GELB); // Konstanten direkt an die Methode übergeben.
        info(Ampelfarbe.GRÜN);

        // In einer Foreach-Schleife können wir über die verfügbaren Konstanten iterieren:
        for (Ampelfarbe ampelfarbe : Ampelfarbe.values()) // Mit values() erzeugen wir ein Array aus den verfügbaren Konstanten.
            System.out.println(ampelfarbe.name()); // name() gibt den Bezeichner der Konstante zurück, so wie sie im Enum deklariert wurde.

        System.out.println();

        System.out.println(Arrays.toString(Fehlercode.values()));

        Fehlercode fehler = Fehlercode.ILLEGAL_ARGUMENT;
        System.out.println("Die Konstante " + fehler.name() + " hat den Wert " + fehler.getCode());

        Fehlercode fehler2 = Fehlercode.valueOf(456);
        if (fehler2 != null) // Unsere eigene valueOf()-Methode gibt null zurück, wenn es zu dem Code keine Konstante gibt.
            System.out.println("Die Konstante " + fehler2.name() + " hat den Wert " + fehler2.getCode());

        // Beispiel:
        Fehlercode fehler3;
        try
        {
            // Diese Methode könnte eine IllegalArgumentException werfen...
            fehler3 = Fehlercode.valueOf("NULL");
        }
        catch (IllegalArgumentException ex)
        {
            // was dann unserem Fehlercode ILLEGAL_ARGUMENT entsprechen würde.
            fehler3 = Fehlercode.ILLEGAL_ARGUMENT;
        }

        System.out.println("Die Konstante " + fehler3.name() + " hat den Wert " + fehler3.getCode());

        System.out.println();

        System.out.println("Quartal: ");
        System.out.println(Monat.getMonateInQuartal(3));
        System.out.println("Monat: ");
        Monat monat = Monat.valueOf(10);
        System.out.println("Zahl: " + monat.getZahl() + ", Name: " + monat.name() + ", Quartal: " + monat.getQuartal());



    } // Hier endet die Main
} // Hier endet die Klasse

// Komplexes Enum
enum Monat
{
    JANUAR(1, 1), // Januar hat die Zahl 1 und Quartal 1.
    FEBRUAR(2, 1), // Februar hat die Zahl 2 und Quartal 1.
    MÄRZ(3, 1), // usw...
    APRIL(4, 2),
    MAI(5, 2),
    JUNI(6, 2),
    JULI(7, 3),
    AUGUST(8,3),
    SEPTEMBER(9,3),
    OKTOBER(10,4),
    NOVEMBER(11,4),
    DEZEMBER(12, 4);

    // Zwei Felder, um zu jeder Konstante zwei Werte speichern zu können.
    // Jede Konstante erhält eine Kopie dieser Felder.
    private final int zahl;
    private final int quartal;

    // Die beiden Felder sind "private". Damit aus anderen Klassen auf die Werte zugegriffen werden kann, brauchen wir Getter-Methoden.
    public int getZahl()
    {
        return zahl;
    }
    public int getQuartal()
    {
        return quartal;
    }

    private Monat(int z, int q) // Die Parameter des Konstruktors müssen nicht wie die Felder heißen.
    {
        this.zahl = z;
        this.quartal = q;
    }

    /**
     * Erzeugt eine ArrayList mit allen Monaten passend zum übergebenen Quartal.
     * @param quartal
     * @return Die Liste mit den Monaten im angegeben Quartal.
     */
    public static ArrayList<Monat> getMonateInQuartal(int quartal)
    {
        ArrayList<Monat> monateInQuartal = new ArrayList<>(); // Enums sind Datentypen und diese Datentypen können auch für Listen und Arrays verwendet werden.

        for (Monat m : Monat.values()) // Alle Konstanten durchsuchen.
            if (m.quartal == quartal) // Wenn der Wert für Quartal in der Konstante dem gesuchten Quartal entspricht,
                monateInQuartal.add(m); // fügen wir den Monat der Liste hinzu.

        return monateInQuartal; // Zum Schluss geben wir die Liste zurück.
    }

    /**
     * Gibt den Monat passend zur übergebenen Zahl zurück, wenn möglich.
     * @param zahl
     * @return Der Monat passend zur übergebenen Zahl, wenn es einen passenden Monat gibt. Sonst null.
     */
    public static Monat valueOf(int zahl)
    {
        for (Monat m : Monat.values()) // Alle Monate durchsuchen.
            if (m.zahl == zahl) // Wenn der Wert für Zahl in der Konstante der gesuchten Zahl entspricht,
                return m; // geben wir die Konstante zurück.

        return null; // Sonst geben wir null zurück.
    }
}