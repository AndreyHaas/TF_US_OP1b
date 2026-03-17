package tag07.druecken;

/*
Allgemeine Informationen zu Interfaces in Java: Interfaces sind Referenztypen. Interfaces sind eine Sammlung von abstrakten Methoden. Es sind aber
 auch constants, default Methoden, nested Typen und statische Methoden im Körper eines Interfaces erlaubt. Methodenkörper sind
 in Interfaces erlaubt für default und statische Methoden. Ein Interface ist ein Vertrag darüber, welche Methoden eine implementierende
 Klasse bereitstellen muss. Java unterstützt keine Mehrfachvererbung, darum wurde durch Interfaces
 ein Mittelweg ermöglicht: Es kann nur von einer Klasse geerbt werden, aber mehrere Interfaces können implementiert werden.
 */
// Konventionen in Java für Interfaces: UpperCamelCase Bezeichner. Bezeichner sollen in der Regel ein Adjektiv sein oder wie Superklassen bezeichnet werden.
public interface Druckbar
{
    //public Druckbar() { } // Konstruktoren sind in einem Interface nicht erlaubt, denn von einem Interface können KEINE Objekte erzeugt werden.

    //private int feld; // Fehlermeldung: Private Felder sind in einem Interface unzulässig.

    // In einem Interface können aber Konstanten angegeben werden:
    public static final String DINA4 = "297 mm x 210 mm";

    // Ein Interface ist anschaulich gesprochen nur eine Liste von Werkzeugnamen, also nur eine Sammlung von abstrakten Methodendeklarationen und Konstanten.
    // Methodendeklarationen in einem Interface sind implizit public und abstract.
    //void drucken();
    //abstract void drucken();
    //public void drucken();
    public abstract void drucken();

    // Statische Methoden sind möglich, müssen aber vollständig implementiert sein. Der Aufruf geschieht dann über den Interface-Bezeichner.
    public static void testDruck()
    {
        System.out.println("Druckergeräusche... es wird ein Testblatt gedruckt.");
    }

    // Nicht-statische 'default'-Methoden haben bereits eine Implementierung und werden an die Klassen vererbt.
    public default boolean prüfeFormat(String format)
    {
        if (format.equalsIgnoreCase(DINA4))
            return true;
        return false;
    }
}
