package tag07.druecken;

// Von Klassen erben und Interfaces implementieren ist gleichzeitig möglich.
// Dabei muss die Superklasse vor den Interfaces genannt werden
public class PDFDokument extends Dokument implements PDFDruckbar, Mailbar
{
    public PDFDokument(String text)
    {
        super(text); // 'super()' bezieht sich immer auf die Super-Klasse, also hier: 'Dokument'
    }

    // Die 'drucken()'-Methode aus 'Druckbar' ist bereits in 'Dokument' implementiert und wird hier einfach geerbt.

    // Die Methode des Interfaces 'PDFDruckbar' implementieren:
    @Override
    public void pdfDrucken()
    {
        System.out.println("Digitale Druckergeräusche... Das Dokument wird als PDF gedruckt: " + text); // weil 'text' protected ist, können wir es hier direkt verwenden. Alternativ über getText()
    }

    // Die Methode des Interfaces 'Mailbar' implementieren:
    @Override
    public void mailVersenden()
    {
        System.out.println("Digitale Briefgeräusche... Das Dokument wird per Mail versendet: " + text);
    }
}
