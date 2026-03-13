package tag05.vererbung;

/*
    VERERBUNG:

    Definition:
        Klassen können von anderen Klassen Code übernehmen → der dort implementierte Code muss also nicht erneut geschrieben werden.
        Die erbende Klasse wird "Subklasse" (Kind-Klasse) genannt, die Klasse von der geerbt wird, heißt "Superklasse" (Eltern-Klasse).
        Man spricht auch von "Ableiten", die Subklasse ist die "abgeleitete Klasse".

    Mehrfachvererbung:
        C++ und Python beherrschen die Mehrfachvererbung. Das bedeutet, dass eine Klasse von mehreren Superklassen gleichzeitig erben kann.
        Dies ist in Java und C# nicht möglich. Hier kann eine Klasse immer nur eine Superklasse haben.
*/

import template.lebewesen.*;

public class Vererbung
{
    public static void main(String[] args)
    {
        System.out.println("Vererbungshierarchie Tier -> Hund -> Dackel:");
        //Tier tier = new Tier(5); // Die Klasse 'Tier' liegt in einem anderen Package. Damit sind 'protected' Member nicht mehr zugreifbar.

        Hund hund = new Hund(10, "Braun");
        System.out.println(hund.getAlter()); // Geerbt von Tier.
        System.out.println(hund.getFellfarbe()); // In Hund deklariert.
        hund.ausgabe(); // In Hund deklariert und überschreibt die Methode aus Tier.

        System.out.println();
        Dackel dackel = new Dackel(5, "Grau");
        System.out.println(dackel.getAlter());
        System.out.println(dackel.getFellfarbe());
        dackel.ausgabe();

        System.out.println();
        System.out.println("POLYMORPHIE");

        // Hund IST EIN Tier.
        // Dadurch kann der Datentyp der Variable vom Typ 'Tier' sein.
        // Wir erstellen ein Objekt vom Typ 'Hund' und speichern diesen in einer Variable vom Typ 'Tier'.
        Tier tier = new Hund(8, "Schwarz");
        System.out.println(tier.getAlter()); // Der Datentyp 'Tier' kennt nur die Member, die in 'Tier' definiert sind.
        // Möchte ich die Member aus 'Hund', muss gecastet werden.
        String fellfarbe = ((Hund) tier).getFellfarbe();
        System.out.println(fellfarbe);

        // Andere Schreibweise fürs Casten:
        fellfarbe = Hund.class.cast(tier).getFellfarbe();
        System.out.println(fellfarbe);

        System.out.println();
        // Polymorphie - Vielgestaltigkeit:
        // Der Hund IST EIN Tier, darum kann es in der tierListe gespeichert werden!
        // Vorteil: ALle diese Objekte passen in eine gemeinsame Liste. So können wir mit einer Schleife über alle Tiere iterieren.
        for (Tier t : Tier.tierListe)
        {
            System.out.println(t.getClass()); // Die Methode getClass() gibt die Klasse zur Laufzeit und die Metadaten des Objektes zurück.
            System.out.println(t.getClass().getSimpleName()); // Ausgabe des Klassenbezeichners.

            // Alle Tiere haben ein Alter.
            System.out.println("Alter: " + t.getAlter());

            // Möchten wir wissen, welcher typ unser Objekt eigentlich ist, können wir dies mit 'instanceof' prüfen.
            if (t instanceof Hund) // Ist das Objekt eine Instanz von Hund?
            {
                Hund h = (Hund) t; // Tier in Hund casten und in 'h' speichern.
                System.out.println("Fellfarbe: " + h.getFellfarbe());
            }
        }

        System.out.println();
        System.out.println("OVERRIDE");

        // Ohne Variablen - die Tiere werden durch den Konstruktor direkt der Liste hinzugefügt.
        new Katze(10);
        new Hauskatze(5);
        new NorwegischeWaldkatze(6);

        System.out.println("Ausgabe aller Tiere der tierListe: ");
        for (Tier t : Tier.tierListe)
        {
            // Alle Tiere verfügen über die ausgabe()-Methode.
            t.ausgabe(); // Es wird immer die passende, überschriebene Methode aufgerufen.
        }

    }
}
