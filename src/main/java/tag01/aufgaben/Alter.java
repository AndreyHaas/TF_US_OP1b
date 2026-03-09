package template;

// Dies ist ein alternatives Beispiel für die Vorlesung.
// Ich habe beim letzten Mal dieses Beispiel durch "Fehlercode"-Enum ausgetauscht in der Hoffnung, dass ein realistischeres Beispiel zugänglicher wäre.
// Wenn die Teilnehmenden mit dem "Fehlercode"-Enum nicht so gut klar kommen, könnte dieses Beispiel hier als Alternative helfen.


// Enums funktionieren ähnlich wie Klassen. Wir können in ihnen Attribute und Methoden definieren.
public enum Alter  // Enum "Alter"
{
    NEUGEBOREN(0), VOLLJÄHRIG(18), SENIOR(60);
    // Ähnlich wie bei dem Erzeugen von Objekten können bei dem Erzeugen der Konstanten Argumente übergeben werden.
    // Diese Argumente stellen den Wert der Konstante dar.

    // Eine Variable, die den Wert der Konstante speichert.
    private final int alterZahl; // "final" heißt, dass der Wert nicht mehr verändert werden kann.

    public int getAlterZahl() // alterZahl ist "private". Um den Wert trotzdem abfragen zu können, brauchen wir eine öffentliche Methode.
    {
        return alterZahl;
    }

    // Ein Konstruktor, der beim Erzeugen der Konstanten aufgerufen wird und der Variable den übergebenen Wert zuweist.
    private Alter(int alterZahl)
    {
        this.alterZahl = alterZahl; // "this" ist hier wichtig, da die Variable für den Wert und der Parameter des Konstruktors gleich heißen.
    }

    /**
     * Macht aus einem übergebenen Integer eine Enum-Konstante, wenn möglich.
     *
     * @param zahl
     * @return Die Enum-Konstante, wenn es eine passende zu der übergebenen Zahl gibt, sonst null.
     */
    public static Alter getAlter(int zahl) // Methode um über Angabe
    {
        for (Alter y : Alter.values()) // values() gibt uns ein Array mit den Konstanten.
        {
            if (y.alterZahl == zahl) // Wenn eine Konstante den Wert hat, der dieser Methode übergeben wurde,
            {
                return y; // dann geben wir diese Konstante zurück.
            }
        }
        return null; // Sonst geben wir null zurück.
    }

    /**
     * Gibt passend zu einem übergebenen Konstanten-Namen als String den Wert zurück, wenn möglich.
     *
     * @param name
     * @return Den Wert der Konstante, wenn es eine passende Konstante zu dem übergebenen String gibt, sonst 0.
     */
    public static int getAlterByName(String name)
    {
        for (Alter n : Alter.values())
        {
            if (n.name().equalsIgnoreCase(name)) // name() gibt uns den Bezeichner der Konstante. Wenn dieser dem übergebenen String entspricht,
            {
                return n.alterZahl; // dann geben wir den Wert der Konstanten zurück.
            }
        }
        return 0; // sonst 0.
    }
}