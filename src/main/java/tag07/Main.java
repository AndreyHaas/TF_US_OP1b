package tag07;

import tag07.druecken.Dokument;
import tag07.druecken.Druckbar;
import tag07.druecken.Mailbar;
import tag07.druecken.PDFDokument;
import tag07.druecken.PDFDruckbar;
import tag07.flaeche.HatFlaeche;


import java.util.ArrayList;
import java.util.List;
import tag07.flaeche.Kreis;
import tag07.flaeche.Rechteck;

public class Main {

  public static void main(String[] args) {
    // Versuch, vom Interface ein Objekt zu erzeugen:
    //Druckbar druckbar = new Druckbar(); // Von Interfaces können keine Instanzen gebildet werden.
    // ACHTUNG: Es können "Anonyme Klassen" erzeugt werden. Dieses Thema besprechen wir in OP2.

    // Aufruf der statischen Methode:
    Druckbar.testDruck();

    // Ein Objekt der Klasse erzeugen und die Methoden aufrufen.
    Dokument dokument = new Dokument("Hallo Welt!");
    if (dokument.prüfeFormat("297 mm x 210 mm")) {// Aufruf der Default-Methode.
      dokument.drucken(); // Aufruf der implementierten Methode.
    }

    System.out.println();
    // Interfaces, wie auch Klassen, können als Datentyp für Variablen verwendet werden.
    PDFDruckbar pdfDruckbar = new PDFDokument("Hallo Welt! (in einem PDF Dokument)");
    pdfDruckbar.drucken(); // Diese Methode erbt das Interface 'PDFDruckbar' vom Interface 'Druckbar'.
    pdfDruckbar.pdfDrucken(); // Diese Methode ist im Interface 'PDFDruckbar' deklariert und in 'PDFDokument' implementiert.

    //PDFDokument pdfDokument = new PDFDokument("Hallo Welt! (wollen wir als Mail versenden)");
    //Mailbar mailbar = (Mailbar) pdfDokument;

    Mailbar mailbar = new PDFDokument("Hallo Welt! (wollen wir als Mail versenden)");
    mailbar.mailVersenden();

    System.out.println();
    // Als Datentyp für Listen:
    // Merke: List<> ist ein Interface, welches von ArrayList implementiert wird. Darum kann List<> der Datentyp der Liste sein.
    List<Druckbar> liste = new ArrayList<>();
    liste.add(
        dokument); // 'Dokument' implementiert das Interface, damit kann das Objekt der Liste hinzugefügt werden.
    liste.add(
        pdfDruckbar); // Das Interface 'PDFDruckbar' erweitert 'Druckbar' und kann damit auch der Liste hinzugefügt werden.
    liste.add(
        (PDFDokument) mailbar); // 'Mailbar' und 'Druckbar' sind eigentlich inkompatibel, aber da das instanziierte Objekt ein 'PDFDokument' ist, welches 'Druckbar' implementiert, kann es nach einem Cast trotzdem der Liste hinzugefügt werden.

    for (Druckbar d : liste) {
      d.drucken();
    }

    System.out.println();
    // Weiteres Beispiel:

    Rechteck rechteck = new Rechteck(5, 10);
    Kreis kreis = new Kreis(2);

    System.out.println("Ausgabe Rechteck: ");
    ausgabeFläche(rechteck);
    System.out.println("Ausgabe Kreis: ");
    ausgabeFläche(kreis);

  } // Hier endet die Main-Methode

  // Interfaces als Methodenparameter:
  // Parameter der Methode ist eine Variable vom Typ des Interfaces 'HatFläche'. Damit können alle Objekte, die das Interface implementiert haben, an die Methode übergeben werden.
  // Best Practice: Methoden sollen so geschrieben werden, dass sie übergeordnete Typen als Parameter entgegennehmen oder zurückgeben, damit so viele Objekte wie möglich mit der Methode arbeiten können.
  static void ausgabeFläche(HatFlaeche hatFlaeche) {
    System.out.println("Fläche: " + hatFlaeche.berechneFlaeche());
  }
}