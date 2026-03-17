package tag07.druecken;

// Bei der Verwendung von Interfaces spricht man in der Regel nicht vom Erben, sondern von "Implementieren" oder "Realisieren"
public class Dokument implements Druckbar
{
    protected String text;

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public Dokument(String text)
    {
        this.text = text;
    }

    // Abstrakte Methoden des Interfaces müssen in den implementierenden Klassen überschrieben werden.
    // Wir sprechen hier vom Implementieren der Methoden.
    @Override
    public void drucken()
    {
        System.out.println("Druckergeräusche... Das Dokument wird gedruckt: " + text);
    }
}
